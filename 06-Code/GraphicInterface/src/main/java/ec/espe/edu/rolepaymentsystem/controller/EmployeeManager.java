/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.rolepaymentsystem.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import ec.espe.edu.rolepaymentsystem.model.Employee;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 *
 * @author Code Maters
 */
public class EmployeeManager implements IEmployeeRepository  {
    private final String employeeFilePath = "employees.json";
    private Gson gsonInstance = new GsonBuilder().setPrettyPrinting().create();
    private final List<Employee> employeeList;
    public EmployeeManager() {
        gsonInstance = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(Date.class, new DateAdapter())
            .create();
    List<Employee> loadedEmployees = loadEmployees();
    employeeList = (loadedEmployees != null) ? loadedEmployees : new ArrayList<>();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public void updateEmployee(Employee updatedEmployee) {
    for (int i = 0; i < employeeList.size(); i++) {
        if (employeeList.get(i).getIdNumber().equals(updatedEmployee.getIdNumber())) {
            employeeList.set(i, updatedEmployee);
            break;
        }
    }
    }
    @Override
    public void removeEmployee(int index) {
        if (index >= 0 && index < employeeList.size()) {
            employeeList.remove(index);
        }
    }
    @Override
    public List<Employee> getEmployees() {
        return employeeList;
    }
    private List<Employee> loadEmployees() {
        try (Reader reader = new FileReader(employeeFilePath)) {
            return parseEmployeesFromJson(reader);
        } catch (IOException e) {
            handleLoadError(e);
            return new ArrayList<>();
        }
    }

    private List<Employee> parseEmployeesFromJson(Reader reader) {
        Type listType = new TypeToken<List<Employee>>(){}.getType();
        return gsonInstance.fromJson(reader, listType);
    }

    private void handleLoadError(IOException e) {
        System.out.println("Error al cargar los empleados: " + e.getMessage());
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
