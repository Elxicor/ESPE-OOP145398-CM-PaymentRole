/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.rolepaymentsystem.model;

/**
 *
 * @author Code Masters
 */
public class Deductions {
    private double contributionIESS;
    private double advancesFortnight;
    private double loans;
    private double fines;
    private double mealDeduction;
    private AdditionalIncome[] additionalIncome;

    public Deductions( double contributionIESS, double advancesFortnight, double loans, double fines, double mealDeduction, AdditionalIncome[] additionalIncome) {
        this.contributionIESS = contributionIESS;
        this.advancesFortnight = advancesFortnight;
        this.loans = loans;
        this.fines = fines;
        this.mealDeduction = mealDeduction;
        this.additionalIncome = additionalIncome;
    }


    public double getContributionIESS() {
        return contributionIESS;
    }

    public void setContributionIESS(double contributionIESS) {
        this.contributionIESS = contributionIESS;
    }

    public double getAdvancesFortnight() {
        return advancesFortnight;
    }

    public void setAdvancesFortnight(double advancesFortnight) {
        this.advancesFortnight = advancesFortnight;
    }

    public double getLoans() {
        return loans;
    }

    public void setLoans(double loans) {
        this.loans = loans;
    }

    public double getFines() {
        return fines;
    }

    public void setFines(double fines) {
        this.fines = fines;
    }

    public double getMealDeduction() {
        return mealDeduction;
    }

    public void setMealDeduction(double mealDeduction) {
        this.mealDeduction = mealDeduction;
    }

    public AdditionalIncome[] getAdditionalIncome() {
        return additionalIncome;
    }

    public void setAdditionalIncome(AdditionalIncome[] additionalIncome) {
        this.additionalIncome = additionalIncome;
    }


}