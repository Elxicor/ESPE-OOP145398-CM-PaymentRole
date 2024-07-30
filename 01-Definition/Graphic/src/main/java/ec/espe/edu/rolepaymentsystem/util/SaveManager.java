/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.rolepaymentsystem.util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.espe.edu.rolepaymentsystem.model.Employee;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 *
 * @author Code Master
 */
public class SaveManager {
        private final String employeesFile = "employees.json";
        private Gson GSON = new GsonBuilder().setPrettyPrinting().create();
   public void saveEmployees(List<Employee> employees) {
        try (Writer writer = new FileWriter(employeesFile)) {
            GSON.toJson(employees, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar los empleados: " + e.getMessage());
        }
    }
    public void saveIndividualEmployee(Employee employee) {
        String fileName = employee.getIdNumber() + "_employee.json";
        try (Writer writer = new FileWriter(fileName)) {
            GSON.toJson(employee, writer);
            System.out.println("Empleado guardado en: " + fileName);
        } catch (IOException e) {
            System.out.println("Error al guardar el empleado individual: " + e.getMessage());
        }
    }
}
