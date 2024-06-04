/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.rolepaymentsystem.model;

import java.time.LocalDate;

/**
 *
 * @author Erick Tufiño
 */
public class ReserveFunds {
    private int id;
    private Employee[] employee;
    private double reserveFunds;
    private LocalDate birthdayDate;

    public ReserveFunds(int id, Employee[] employee, double reserveFunds, LocalDate birthdayDate) {
        this.id = id;
        this.employee = employee;
        this.reserveFunds = reserveFunds;
        this.birthdayDate = birthdayDate;
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
     * @return the reserveFunds
     */
    public double getReserveFunds() {
        return reserveFunds;
    }

    /**
     * @param reserveFunds the reserveFunds to set
     */
    public void setReserveFunds(double reserveFunds) {
        this.reserveFunds = reserveFunds;
    }

    /**
     * @return the birthdayDate
     */
    public LocalDate getBirthdayDate() {
        return birthdayDate;
    }

    /**
     * @param birthdayDate the birthdayDate to set
     */
    public void setBirthdayDate(LocalDate birthdayDate) {
        this.birthdayDate = birthdayDate;
    }
    
    
}
