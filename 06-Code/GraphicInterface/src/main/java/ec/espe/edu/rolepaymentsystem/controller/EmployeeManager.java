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
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Code Maters
 */
public class EmployeeManager {
    private final String employeesFile = "employees.json";
    private Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final List<Employee> employees;
        public EmployeeManager() {
        GSON = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(Date.class, new DateAdapter())
            .create();
        employees = loadEmployees();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
//        saveEmployees();
    }

    public void updateEmployee(Employee updatedEmployee) {
    for (int i = 0; i < employees.size(); i++) {
        if (employees.get(i).getIdNumber().equals(updatedEmployee.getIdNumber())) {
            employees.set(i, updatedEmployee);
            break;
        }
    }
//    saveEmployees();
    }
    public void removeEmployee(int index) {
       if (index >= 0 && index < employees.size()) {
            employees.remove(index);
        }
//        saveEmployees();
    }
    public List<Employee> getEmployees() {
        return employees;
    }

   private List<Employee> loadEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Reader reader = new FileReader(employeesFile)) {
            Type listType = new TypeToken<ArrayList<Employee>>(){}.getType();
            employees = GSON.fromJson(reader, listType);
        } catch (IOException e) {
            System.out.println("Error al cargar los empleados: " + e.getMessage());
        }
        return employees != null ? employees : new ArrayList<>();
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
            for (SimpleDateFormat format : inputFormats) {
                try {
                    return format.parse(dateStr);
                } catch (ParseException e) {
                }
            }
            throw new JsonParseException("Unparseable date: \"" + dateStr + "\"");
        }
    }
}
