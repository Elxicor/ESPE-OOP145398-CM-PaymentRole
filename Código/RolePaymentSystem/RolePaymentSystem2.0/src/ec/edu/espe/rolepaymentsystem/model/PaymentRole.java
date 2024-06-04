/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.rolepaymentsystem.model;
import java.util.List;

/**
 *
 * @author Code Masters
 */
public class PaymentRole {
    private int id;
    private Employee[] employee;
    private double income;
    private double expenses;
    private double ReserveFunds;
    private List<Deductions> deductions;

    public PaymentRole(int id, Employee[] employee, double income, double expenses, double ReserveFunds, List<Deductions> deductions) {
        this.id = id;
        this.employee = employee;
        this.income = income;
        this.expenses = expenses;
        this.ReserveFunds = ReserveFunds;
        this.deductions = deductions;
    }



    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the employee
     */
    public Employee[] getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee[] employee) {
        this.employee = employee;
    }

    /**
     * @return the income
     */
    public double getIncome() {
        return income;
    }

    /**
     * @param income the income to set
     */
    public void setIncome(double income) {
        this.income = income;
    }

    /**
     * @return the expenses
     */
    public double getExpenses() {
        return expenses;
    }

    /**
     * @param expenses the expenses to set
     */
    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    /**
     * @return the ReserveFunds
     */
    public double getReserveFunds() {
        return ReserveFunds;
    }

    /**
     * @param ReserveFunds the ReserveFunds to set
     */
    public void setReserveFunds(double ReserveFunds) {
        this.ReserveFunds = ReserveFunds;
    }

    /**
     * @return the deductions
     */
    public List<Deductions> getDeductions() {
        return deductions;
    }

    /**
     * @param deductions the deductions to set
     */
    public void setDeductions(List<Deductions> deductions) {
        this.deductions = deductions;
    }
    
    
}
