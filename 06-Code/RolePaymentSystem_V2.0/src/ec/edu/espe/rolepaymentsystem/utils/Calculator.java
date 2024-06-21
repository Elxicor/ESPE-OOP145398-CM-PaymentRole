/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.rolepaymentsystem.utils;

import ec.edu.espe.rolepaymentsystem.model.Constants;

/**
 *
 * @author Code Masters
 */
public class Calculator {
    public static double calculateBasicSalary(double annualSalary) {
        return annualSalary / 12;
    }

    public static double calculateOvertimeHours(double hoursWorked, double regularHours, double hourlyRate) {
        double overtimeHours = hoursWorked - regularHours;
        double overtimeValue = overtimeHours * hourlyRate * Constants.OVERTIME_HOUR_INCREASE;
        return overtimeValue;
    }

    public static double calculateReserveFunds(double basicSalary) {
        return basicSalary * Constants.RESERVE_FUNDS_PERCENTAGE;
    }

    public static double calculateIessContribution(double totalIncome, double reserveFunds) {
        double iessContribution = (totalIncome - reserveFunds) * Constants.IESS_PERCENTAGE;
        return iessContribution;
    }
    
    public static double calculateBiweeklyAdvance(double basicSalary) {
    return basicSalary / 2;
    }
    
    public static double calculateFoodDeduction(boolean bringsOwnFood, double foodDeductionAmount) {
    return bringsOwnFood ? 0 : foodDeductionAmount;
    }

    public static double calculateTotalIncome(double basicSalary, double overtimePayment, double bonuses) {
        return basicSalary + overtimePayment + bonuses;
    }

    public static double calculateTotalExpenses(double iessContribution, double biweeklyAdvance, double iessLoans, double companyLoans, double fines, double foodDeduction) {
        return iessContribution + biweeklyAdvance + iessLoans + companyLoans + fines + foodDeduction;
    }

    public static double calculateNetPayment(double totalIncome, double totalExpenses) {
        return totalIncome - totalExpenses;
    }

    public static double calculateEmployerContribution(double totalIncome, double reserveFunds) {
        return (totalIncome + reserveFunds) * Constants.EMPLOYER_CONTRIBUTION_PERCENTAGE;
    }

    public static double calculateTotalEmployeeCost(double netPayment, double employerContribution) {
        return netPayment + employerContribution;
    }
}
