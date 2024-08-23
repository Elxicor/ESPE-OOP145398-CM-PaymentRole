/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.rolepaymentsystem.controller;

import ec.espe.edu.rolepaymentsystem.model.Employee;
import java.util.List;

/**
 *
 * @author Code Master
 */
public interface IEmployeeRepository {
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void removeEmployee(int index);
    List<Employee> getEmployees();
}
