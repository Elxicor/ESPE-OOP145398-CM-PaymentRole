
package ec.espe.edu.rolepaymentsystem.controller;

import ec.espe.edu.rolepaymentsystem.model.Employee;
import ec.espe.edu.rolepaymentsystem.util.EmployeeObserver;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private List<EmployeeObserver> observers = new ArrayList<>();

    public void addObserver(EmployeeObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(EmployeeObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String eventType, String employeeId) {
        for (EmployeeObserver observer : observers) {
            observer.update(eventType, employeeId);
        }
    }

    public void addEmployee(Employee employee) {
        // Code to add employee
        System.out.println("Employee " + employee.getId() + " added.");
        notifyObservers("ADD", employee.getId());
    }

    public void updateEmployee(Employee employee) {
        // Code to update employee
        System.out.println("Employee " + employee.getId() + " updated.");
        notifyObservers("UPDATE", employee.getId());
    }

    public void deleteEmployee(String employeeId) {
        // Code to delete employee
        System.out.println("Employee " + employeeId + " deleted.");
        notifyObservers("DELETE", employeeId);
    }
}
