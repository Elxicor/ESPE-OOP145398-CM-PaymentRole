/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.rolepaymentsystem.util;

import ec.espe.edu.rolepaymentsystem.model.Constants;
import ec.espe.edu.rolepaymentsystem.model.Employee;

/**
 *
 * @author PAOLA-SSD
 */
public class Calculator {
    public static double calculateTotalAmount(Employee emp) {
        double totalAmount = emp.getBasicSalary();
        totalAmount += emp.getBonuses();
        totalAmount += calculateOvertimeHours(emp.getOvertimeHours(), Constants.getRegularHoursPerMonth(), emp.getBasicSalary() / 160);
        totalAmount -= calculateTotalDeductions(emp);
        return Math.max(totalAmount, 0);
    }

    public static double calculateOvertimeHours(double hoursWorked, double regularHours, double hourlyRate) {
        double overtimeHours = Math.max(hoursWorked - regularHours, 0);
        double overtimeValue = overtimeHours * hourlyRate * Constants.getOvertimeHourIncrease();
        return Math.round(overtimeValue * 100.0) / 100.0;
    }

    public static double calculateReserveFunds(double basicSalary) {
        return Math.round(basicSalary * Constants.getReserveFundsPercentage() * 100.0) / 100.0;
    }

    public static double calculateIessContribution(double totalIncome, double reserveFunds) {
        double iessContribution = (totalIncome - reserveFunds) * Constants.getIessPercentage();
        return Math.round(iessContribution * 100.0) / 100.0;
    }
    
    public static double calculateBiweeklyAdvance(double basicSalary) {
        return (basicSalary < 0.01) ? 0 : Math.round((basicSalary / 2) * 100.0) / 100.0;
    }
    
    public static double calculateFoodDeduction(boolean bringsOwnFood, double foodDeductionAmount) {
        return bringsOwnFood ? 0 : Math.max(foodDeductionAmount, 0);
    }

    public static double calculateTotalIncome(double basicSalary, double overtimePayment, double bonuses) {
        double totalIncome = basicSalary + overtimePayment + bonuses;
        return (totalIncome > Double.MAX_VALUE) ? Double.POSITIVE_INFINITY : totalIncome;
    }

    public static double calculateTotalExpenses(double iessContribution, double biweeklyAdvance, double iessLoans, double companyLoans, double fines, double foodDeduction) {
        double totalExpenses = iessContribution + biweeklyAdvance + iessLoans + companyLoans + fines + foodDeduction;
        return (totalExpenses > Double.MAX_VALUE) ? Double.POSITIVE_INFINITY : totalExpenses;
    }

    public static double calculateNetPayment(double totalIncome, double totalExpenses) {
        double result = Math.max(Math.round((totalIncome - totalExpenses) * 100.0) / 100.0, 0);
        return (result < 1e-10) ? 0 : result;
    }

    public static double calculateEmployerContribution(double totalIncome, double reserveFunds) {
        return Math.round((totalIncome + reserveFunds) * Constants.getEmployerContributionPercentage() * 100.0) / 100.0;
    }

    public static double calculateTotalEmployeeCost(double netPayment, double employerContribution) {
        double totalCost = netPayment + employerContribution;
        return (totalCost > Double.MAX_VALUE) ? Double.POSITIVE_INFINITY : totalCost;
    }

    public static double calculateTotalDeductions(Employee emp) {
        double totalDeductions = emp.getIessLoans();
        totalDeductions += emp.getCompanyLoans();
        totalDeductions += emp.getFines();
        totalDeductions += emp.getAbsentDays() * (emp.getBasicSalary() / 30);
        totalDeductions += calculateFoodDeduction(emp.getBringOwnFood(), 50);
        totalDeductions += calculateIessContribution(calculateTotalIncome(emp.getBasicSalary(), calculateOvertimeHours(emp.getOvertimeHours(), Constants.getRegularHoursPerMonth(), emp.getBasicSalary() / 160), emp.getBonuses()), calculateReserveFunds(emp.getBasicSalary()));
        return Math.round(totalDeductions * 100.0) / 100.0;
    }
}
