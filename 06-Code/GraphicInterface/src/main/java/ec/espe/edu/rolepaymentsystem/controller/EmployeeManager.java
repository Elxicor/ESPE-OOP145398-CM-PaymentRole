
package ec.espe.edu.rolepaymentsystem.controller;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import ec.espe.edu.rolepaymentsystem.model.Employee;
import java.io.*;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Gestiona los empleados utilizando almacenamiento abstracto.
 */
public class EmployeeManager {
    private final String employeeFilePath;
    private final Gson gsonInstance;
    private final List<Employee> employeeList;
    private final IEmployeeStorage storage;

    /**
     * Constructor que recibe las dependencias necesarias.
     * 
     * @param filePath Ruta del archivo de empleados
     * @param storage Instancia de almacenamiento inyectada
     */
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

    /**
     * Agrega un empleado a la lista y guarda los cambios.
     * 
     * @param employee Empleado a agregar
     */
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
        saveEmployees();
    }

    /**
     * Actualiza un empleado existente.
     * 
     * @param updatedEmployee Empleado actualizado
     */
    public void updateEmployee(Employee updatedEmployee) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getIdNumber().equals(updatedEmployee.getIdNumber())) {
                employeeList.set(i, updatedEmployee);
                saveEmployees();
                return;
            }
        }
    }

    /**
     * Guarda la lista de empleados utilizando el almacenamiento inyectado.
     */
    private void saveEmployees() {
        storage.save(employeeFilePath, employeeList);
    }

    /**
     * Carga la lista de empleados desde el almacenamiento inyectado.
     */
    private List<Employee> loadEmployees() {
        return storage.load(employeeFilePath);
    }

    // Clase interna para adaptar la fecha
    private class DateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
        private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        @Override
        public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(dateFormat.format(src));
        }

        @Override
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            try {
                return dateFormat.parse(json.getAsString());
            } catch (ParseException e) {
                throw new JsonParseException(e);
            }
        }
    }
}
