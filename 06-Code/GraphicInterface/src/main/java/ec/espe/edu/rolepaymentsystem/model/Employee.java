/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.rolepaymentsystem.model;

import java.util.Date;

/**
 *
 * @author Code Master
 */
public class Employee {
    private String name;
    private String lastName;
    private String idNumber;
    private Date hireDate;
    private double basicSalary;
    private double overtimeHours;
    private double absentDays;
    private double bonuses;
    private double iessLoans;
    private double companyLoans;
    private double fines;
    private boolean bringOwnFood;

    public Employee(String name, String lastName, String idNumber, Date hireDate, double basicSalary, double overtimeHours, double absentDays, double bonuses, double iessLoans, double companyLoans, double fines, boolean bringOwnFood) {
        this.name = name;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.hireDate = hireDate;
        this.basicSalary = basicSalary;
        this.overtimeHours = overtimeHours;
        this.absentDays = absentDays;
        this.bonuses = bonuses;
        this.iessLoans = iessLoans;
        this.companyLoans = companyLoans;
        this.fines = fines;
        this.bringOwnFood = bringOwnFood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public double getAbsentDays() {
        return absentDays;
    }

    public void setAbsentDays(double absentDays) {
        this.absentDays = absentDays;
    }

    public double getBonuses() {
        return bonuses;
    }

    public void setBonuses(double bonuses) {
        this.bonuses = bonuses;
    }

    public double getIessLoans() {
        return iessLoans;
    }

    public void setIessLoans(double iessLoans) {
        this.iessLoans = iessLoans;
    }

    public double getCompanyLoans() {
        return companyLoans;
    }

    public void setCompanyLoans(double companyLoans) {
        this.companyLoans = companyLoans;
    }

    public double getFines() {
        return fines;
    }

    public void setFines(double fines) {
        this.fines = fines;
    }

    public boolean getBringOwnFood() {
        return bringOwnFood;
    }

    public void setBringOwnFood(boolean bringOwnFood) {
        this.bringOwnFood = bringOwnFood;
    }
}
