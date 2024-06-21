/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.rolepaymentsystem.model;
import ec.edu.espe.rolepaymentsystem.model.AdditionalIncome;
import java.util.List;
/**
 *
 * @author Code Masters
 */
public class Deductions {
    private List<Deduction> deductions;
    private AdditionalIncome additionalIncome;

    public Deductions(List<Deduction> deductions, AdditionalIncome additionalIncome) {
        this.deductions = deductions;
        this.additionalIncome = additionalIncome;
    }

    public double getTotalDeductions() {
        double total = 0;
        for (Deduction deduction : deductions) {
            total += deduction.getValue();
        }
        return total;
    }

    public List<Deduction> getDeductions() {
        return deductions;
    }

    public void setDeductions(List<Deduction> deductions) {
        this.deductions = deductions;
    }

    public AdditionalIncome getAdditionalIncome() {
        return additionalIncome;
    }

    public void setAdditionalIncome(AdditionalIncome additionalIncome) {
        this.additionalIncome = additionalIncome;
    }
    
}
