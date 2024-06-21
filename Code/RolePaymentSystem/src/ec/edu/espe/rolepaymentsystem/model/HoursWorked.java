/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.rolepaymentsystem.model;

/**
 *
 * @author Code Masters
 */
public class HoursWorked{
    private int hoursWorked;
    private int overtime;

    public HoursWorked(int hoursWorked, int overtime) {
        this.hoursWorked = hoursWorked;
        this.overtime = overtime;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    public double calculateNetPay(double hourlyRate) {
        double netPay = (hoursWorked * hourlyRate) + (overtime * hourlyRate * 1.5); // Asumiendo que las horas extras se pagan al 150%
        return netPay;
    }    
}
