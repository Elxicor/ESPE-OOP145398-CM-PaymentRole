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
    private int netPay;

    public HoursWorked(int hoursWorked, int overtime, int netPay) {
        this.hoursWorked = hoursWorked;
        this.overtime = overtime;
        this.netPay = netPay;
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

    public int getNetPay() {
        return netPay;
    }

    public void setNetPay(int netPay) {
        this.netPay = netPay;
    }
    

    
}
