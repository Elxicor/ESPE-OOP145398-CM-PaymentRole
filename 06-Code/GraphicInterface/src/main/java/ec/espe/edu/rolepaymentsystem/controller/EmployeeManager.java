
package ec.espe.edu.rolepaymentsystem.controller;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import ec.espe.edu.rolepaymentsystem.controller.IEmployeeStorage;
import ec.espe.edu.rolepaymentsystem.model.Employee;
import java.io.*;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author Code Maters
 */
public class EmployeeManager {
    private final String employeeFilePath;
    private final Gson gsonInstance;
    private final List<Employee> employeeList;
    private final IEmployeeStorage storage;

    public EmployeeManager(String filePath, IEmployeeStorage storage) {
        this.employeeFilePath = filePath;
        this.storage = storage;
        this.gsonInstance = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(Date.class, new DateAdapter())
            .create();
        List<Employee> loadedEmployees = loadEmployees();
        this.employeeList = (loadedEmployees != null) ? loadedEmployees : new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
        saveEmployees();
    }

    public void updateEmployee(Employee updatedEmployee) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getIdNumber().equals(updatedEmployee.getIdNumber())) {
                employeeList.set(i, updatedEmployee);
                saveEmployees();
                break;
            }
        }
    }

    public void removeEmployee(int index) {
        if (index >= 0 && index < employeeList.size()) {
            employeeList.remove(index);
            saveEmployees();
        }
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employeeList);
    }

    private List<Employee> loadEmployees() {
        try (Reader reader = storage.getReader(employeeFilePath)) {
            return parseEmployeesFromJson(reader);
        } catch (IOException e) {
            handleLoadError(e);
            return new ArrayList<>();
        }
    }

    private void saveEmployees() {
        try (Writer writer = storage.getWriter(employeeFilePath)) {
            gsonInstance.toJson(employeeList, writer);
        } catch (IOException e) {
            handleSaveError(e);
        }
    }

    private List<Employee> parseEmployeesFromJson(Reader reader) {
        Type listType = new TypeToken<List<Employee>>(){}.getType();
        return gsonInstance.fromJson(reader, listType);
    }

    private void handleLoadError(IOException e) {
        System.out.println("Error al cargar los empleados: " + e.getMessage());
    }

    private void handleSaveError(IOException e) {
        System.out.println("Error al guardar los empleados: " + e.getMessage());
    }

    private static class DateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
        private final SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
        private final SimpleDateFormat[] inputFormats = {
            new SimpleDateFormat("dd/MM/yyyy"),
            new SimpleDateFormat("MMM d, yyyy", Locale.US)
        };

        @Override
        public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(outputFormat.format(src));
        }

        @Override
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            String dateStr = json.getAsString();
            return Arrays.stream(inputFormats)
                .map(format -> {
                    try {
                        return format.parse(dateStr);
                    } catch (ParseException e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(() -> new JsonParseException("Unparseable date: \"" + dateStr + "\""));
        }
    }
}
