/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.rolepaymentsystem.model;

/**
 *
 * @author Code Masters
 */
public class AdditionalIncome {
    private int id;
    private double bonuses;
    private double commissions;
    private double otherBenefits;

    public AdditionalIncome() {
        this.id = 0;
        this.bonuses = 0.0;
        this.commissions = 0.0;
        this.otherBenefits = 0.0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBonuses() {
        return bonuses;
    }

    public void setBonuses(double bonuses) {
        this.bonuses = bonuses;
    }

    public double getCommissions() {
        return commissions;
    }

    public void setCommissions(double commissions) {
        this.commissions = commissions;
    }

    public double getOtherBenefits() {
        return otherBenefits;
    }

    public void setOtherBenefits(double otherBenefits) {
        this.otherBenefits = otherBenefits;
    }

}
