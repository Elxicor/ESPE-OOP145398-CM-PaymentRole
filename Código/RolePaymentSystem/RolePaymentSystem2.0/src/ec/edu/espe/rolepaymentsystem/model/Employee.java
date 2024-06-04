/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.rolepaymentsystem.model;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Erick Tufiño
 */
public class Employee {
    private int id;
    private String name;
    //private int age;
    private double basicsalary;
    private HoursWorked hoursWorked;
    private LocalDate entryDate;

    public Employee(int id, String name, double basicsalary, HoursWorked hoursWorked, LocalDate entryDate) {
        this.id = id;
        this.name = name;
        this.basicsalary = basicsalary;
        this.hoursWorked = hoursWorked;
        this.entryDate = entryDate;
    }

    


    /*
    private int CalculationAge(LocalDate entryDate) {
    LocalDate today = LocalDate.now();
    if (entryDate != null) {
        return Period.between(entryDate, today).getYears();
    } else {
        return 0;
    }
    } */
    
    public String toString(String type) {
    String employeeData = "";
    if (type.equals("csv")) { // CSV
        employeeData = id + "," + name + "," + basicsalary + "," + hoursWorked.getHoursWorked() + "," + entryDate;
    } else if (type.equals("txt")) { // TXT
        employeeData = "Payroll\n\n" +
                       "ID: " + id + "\n" +
                       "Name: " + name + "\n" +
                       "Basic Salary: $" + basicsalary + "\n" +
                       "Hours Worked: " + hoursWorked.getHoursWorked() + "\n" +
                       "Entry Date: " + entryDate + "\n";
    } else if (type.equals("json")) { // JSON
        employeeData = "{\n" +
                       "  \"ID\": " + id + ",\n" +
                       "  \"Name\": \"" + name + "\",\n" +
                       "  \"BasicSalary\": " + basicsalary + ",\n" +
                       "  \"HoursWorked\": " + hoursWorked.getHoursWorked() + ",\n" +
                       "  \"EntryDate\": \"" + entryDate + "\"\n" +
                       "}";
    } else {
        employeeData = "Invalid type";
    }
    return employeeData;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(double basicsalary) {
        this.basicsalary = basicsalary;
    }

    public HoursWorked getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(HoursWorked hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }
 }
    
    
