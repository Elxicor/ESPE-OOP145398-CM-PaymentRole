/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.rolepaymentsystem.model;

/**
 *
 * @author Code Master
 */
public class Constants {
    private static double iessPercentage;
    private static double overtimeHourIncrease;
    private static double reserveFundsPercentage;
    private static double employerContributionPercentage;
    private static double regularHoursPerMonth;
    private static double basicSalary;

    public static double getIessPercentage() {
        return iessPercentage;
    }

    public static void setIessPercentage(double iessPercentage) {
        Constants.iessPercentage = iessPercentage;
    }

    public static double getOvertimeHourIncrease() {
        return overtimeHourIncrease;
    }

    public static void setOvertimeHourIncrease(double overtimeHourIncrease) {
        Constants.overtimeHourIncrease = overtimeHourIncrease;
    }

    public static double getReserveFundsPercentage() {
        return reserveFundsPercentage;
    }

    public static void setReserveFundsPercentage(double reserveFundsPercentage) {
        Constants.reserveFundsPercentage = reserveFundsPercentage;
    }

    public static double getEmployerContributionPercentage() {
        return employerContributionPercentage;
    }

    public static void setEmployerContributionPercentage(double employerContributionPercentage) {
        Constants.employerContributionPercentage = employerContributionPercentage;
    }

    public static double getRegularHoursPerMonth() {
        return regularHoursPerMonth;
    }

    public static void setRegularHoursPerMonth(double regularHoursPerMonth) {
        Constants.regularHoursPerMonth = regularHoursPerMonth;
    }

    public static double getBasicSalary() {
        return basicSalary;
    }

    public static void setBasicSalary(double basicSalary) {
        Constants.basicSalary = basicSalary;
    }
}
