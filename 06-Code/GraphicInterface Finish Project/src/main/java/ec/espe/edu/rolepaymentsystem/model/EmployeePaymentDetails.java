
package ec.espe.edu.rolepaymentsystem.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Code Master
 */
public class EmployeePaymentDetails {
    private static final List<EmployeePaymentDetails> allDetails = new ArrayList<>();
    private double overtimePayment;
    private double reserveFunds;
    private double totalIncome;
    private double iessContribution;
    private double biweeklyAdvance;
    private double foodDeduction;
    private double totalExpenses;
    private double netPayment;
    private double employerContribution;
    private double totalEmployeeCost;

    public EmployeePaymentDetails(double overtimePayment, double reserveFunds, double totalIncome, double iessContribution, double biweeklyAdvance, double foodDeduction, double totalExpenses, double netPayment, double employerContribution, double totalEmployeeCost) {
        this.overtimePayment = overtimePayment;
        this.reserveFunds = reserveFunds;
        this.totalIncome = totalIncome;
        this.iessContribution = iessContribution;
        this.biweeklyAdvance = biweeklyAdvance;
        this.foodDeduction = foodDeduction;
        this.totalExpenses = totalExpenses;
        this.netPayment = netPayment;
        this.employerContribution = employerContribution;
        this.totalEmployeeCost = totalEmployeeCost;
        allDetails.add(this);
    }
    public static List<EmployeePaymentDetails> getAllDetails() {
        return allDetails;
    }

    public double getOvertimePayment() {
        return overtimePayment;
    }

    public void setOvertimePayment(double overtimePayment) {
        this.overtimePayment = overtimePayment;
    }

    public double getReserveFunds() {
        return reserveFunds;
    }

    public void setReserveFunds(double reserveFunds) {
        this.reserveFunds = reserveFunds;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getIessContribution() {
        return iessContribution;
    }

    public void setIessContribution(double iessContribution) {
        this.iessContribution = iessContribution;
    }

    public double getBiweeklyAdvance() {
        return biweeklyAdvance;
    }

    public void setBiweeklyAdvance(double biweeklyAdvance) {
        this.biweeklyAdvance = biweeklyAdvance;
    }

    public double getFoodDeduction() {
        return foodDeduction;
    }

    public void setFoodDeduction(double foodDeduction) {
        this.foodDeduction = foodDeduction;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public double getNetPayment() {
        return netPayment;
    }

    public void setNetPayment(double netPayment) {
        this.netPayment = netPayment;
    }

    public double getEmployerContribution() {
        return employerContribution;
    }

    public void setEmployerContribution(double employerContribution) {
        this.employerContribution = employerContribution;
    }

    public double getTotalEmployeeCost() {
        return totalEmployeeCost;
    }

    public void setTotalEmployeeCost(double totalEmployeeCost) {
        this.totalEmployeeCost = totalEmployeeCost;
    }
    
}
