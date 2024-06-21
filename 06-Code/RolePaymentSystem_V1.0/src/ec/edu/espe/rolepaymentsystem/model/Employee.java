/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.rolepaymentsystem.model;

import java.time.LocalDate;
import java.time.Period;
/**
 *
 * @author Code Masters
 */
public class Employee {
    private int id;
    private String name;
    //private int age;
    private double basicSalary;
    private HoursWorked hoursWorked;
    private LocalDate entryDate;
    private Deductions deductions;
    
    public Employee(int id, String name, LocalDate entryDate, double basicSalary,int hoursWorked, Deductions deductions,int overtime) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
        this.entryDate = entryDate;
        this.deductions = deductions;
        this.hoursWorked = new HoursWorked(hoursWorked, overtime);
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
        employeeData = id + "," + name + "," + basicSalary + "," + hoursWorked.getHoursWorked() + "," + entryDate;
    } else if (type.equals("txt")) { // TXT
        employeeData = "Payroll\n\n" +
                       "ID: " + id + "\n" +
                       "Name: " + name + "\n" +
                       "Basic Salary: $" + basicSalary + "\n" +
                       "Hours Worked: " + hoursWorked.getHoursWorked() + "\n" +
                       "Entry Date: " + entryDate + "\n";
    } else if (type.equals("json")) { // JSON
        employeeData = "{\n" +
                       "  \"ID\": " + id + ",\n" +
                       "  \"Name\": \"" + name + "\",\n" +
                       "  \"BasicSalary\": " + basicSalary + ",\n" +
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

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
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

    public Deductions getDeductions() {
        return deductions;
    }

    public void setDeductions(Deductions deductions) {
        this.deductions = deductions;
    }

    public double calculateNetPay() {
        return hoursWorked.calculateNetPay(basicSalary / 240);
    }
 }
    
    
