package ec.espe.edu.rolepaymentsystem.model;

import java.util.Date;

/**
 *
 * @author Code Master
 */
public class SalaryUpdate {
    private double oldSalary;
    private double newSalary;
    private Date updateDate;

    public SalaryUpdate( double oldSalary, double newSalary) {
        this.oldSalary = oldSalary;
        this.newSalary = newSalary;
        this.updateDate = new Date();
    }
    public double getOldSalary() {
        return oldSalary;
    }

    public void setOldSalary(double oldSalary) {
        this.oldSalary = oldSalary;
    }

    public double getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(double newSalary) {
        this.newSalary = newSalary;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
