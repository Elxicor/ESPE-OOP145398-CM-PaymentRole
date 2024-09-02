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
    private static double iessPercentage = 0.0945;
    private static double overtimeHourIncrease = 1.5;
    private static double reserveFundsPercentage = 0.0833;
    private static double employerContributionPercentage = 0.1215;
    private static int regularHoursPerMonth = 240;
    private static double basicSalary = 460.0;

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

    public static int getRegularHoursPerMonth() {
        return regularHoursPerMonth;
    }

    public static void setRegularHoursPerMonth(int regularHoursPerMonth) {
        Constants.regularHoursPerMonth = regularHoursPerMonth;
    }

    public static double getBasicSalary() {
        return basicSalary;
    }

    public static void setBasicSalary(double basicSalary) {
        Constants.basicSalary = basicSalary;
    }
}
