/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.rolepaymentsystem.model;

import java.util.Date;

/**
 *
 * @author PAOLA-SSD
 */
public class RatesParametersUpdate {
    private double oldIessPercentage;
    private double newIessPercentage;
    private double oldReserveFundsPercentage;
    private double newReserveFundsPercentage;
    private double oldOvertimeHourIncrease;
    private double newOvertimeHourIncrease;
    private double oldEmployerContributionPercentage;
    private double newEmployerContributionPercentage;
    private int oldRegularHoursPerMonth;
    private int newRegularHoursPerMonth;
    private Date updateDate;

    public RatesParametersUpdate(double oldIessPercentage, double newIessPercentage, double oldReserveFundsPercentage, double newReserveFundsPercentage, double oldOvertimeHourIncrease, double newOvertimeHourIncrease, double oldEmployerContributionPercentage, double newEmployerContributionPercentage, int oldRegularHoursPerMonth, int newRegularHoursPerMonth) {
        this.oldIessPercentage = oldIessPercentage;
        this.newIessPercentage = newIessPercentage;
        this.oldReserveFundsPercentage = oldReserveFundsPercentage;
        this.newReserveFundsPercentage = newReserveFundsPercentage;
        this.oldOvertimeHourIncrease = oldOvertimeHourIncrease;
        this.newOvertimeHourIncrease = newOvertimeHourIncrease;
        this.oldEmployerContributionPercentage = oldEmployerContributionPercentage;
        this.newEmployerContributionPercentage = newEmployerContributionPercentage;
        this.oldRegularHoursPerMonth = oldRegularHoursPerMonth;
        this.newRegularHoursPerMonth = newRegularHoursPerMonth;
        this.updateDate = new Date();
    }

    public double getOldIessPercentage() {
        return oldIessPercentage;
    }

    public void setOldIessPercentage(double oldIessPercentage) {
        this.oldIessPercentage = oldIessPercentage;
    }

    public double getNewIessPercentage() {
        return newIessPercentage;
    }

    public void setNewIessPercentage(double newIessPercentage) {
        this.newIessPercentage = newIessPercentage;
    }

    public double getOldReserveFundsPercentage() {
        return oldReserveFundsPercentage;
    }

    public void setOldReserveFundsPercentage(double oldReserveFundsPercentage) {
        this.oldReserveFundsPercentage = oldReserveFundsPercentage;
    }

    public double getNewReserveFundsPercentage() {
        return newReserveFundsPercentage;
    }

    public void setNewReserveFundsPercentage(double newReserveFundsPercentage) {
        this.newReserveFundsPercentage = newReserveFundsPercentage;
    }

    public double getOldOvertimeHourIncrease() {
        return oldOvertimeHourIncrease;
    }

    public void setOldOvertimeHourIncrease(double oldOvertimeHourIncrease) {
        this.oldOvertimeHourIncrease = oldOvertimeHourIncrease;
    }

    public double getNewOvertimeHourIncrease() {
        return newOvertimeHourIncrease;
    }

    public void setNewOvertimeHourIncrease(double newOvertimeHourIncrease) {
        this.newOvertimeHourIncrease = newOvertimeHourIncrease;
    }

    public double getOldEmployerContributionPercentage() {
        return oldEmployerContributionPercentage;
    }

    public void setOldEmployerContributionPercentage(double oldEmployerContributionPercentage) {
        this.oldEmployerContributionPercentage = oldEmployerContributionPercentage;
    }

    public double getNewEmployerContributionPercentage() {
        return newEmployerContributionPercentage;
    }

    public void setNewEmployerContributionPercentage(double newEmployerContributionPercentage) {
        this.newEmployerContributionPercentage = newEmployerContributionPercentage;
    }

    public int getOldRegularHoursPerMonth() {
        return oldRegularHoursPerMonth;
    }

    public void setOldRegularHoursPerMonth(int oldRegularHoursPerMonth) {
        this.oldRegularHoursPerMonth = oldRegularHoursPerMonth;
    }

    public int getNewRegularHoursPerMonth() {
        return newRegularHoursPerMonth;
    }

    public void setNewRegularHoursPerMonth(int newRegularHoursPerMonth) {
        this.newRegularHoursPerMonth = newRegularHoursPerMonth;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    
}
