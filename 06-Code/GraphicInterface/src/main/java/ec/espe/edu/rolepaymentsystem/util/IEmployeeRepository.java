/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.rolepaymentsystem.util;

import ec.espe.edu.rolepaymentsystem.model.Employee;
import ec.espe.edu.rolepaymentsystem.model.EmployeePaymentDetails;
import ec.espe.edu.rolepaymentsystem.model.Password;
import ec.espe.edu.rolepaymentsystem.model.SalaryUpdate;
import java.util.Date;

/**
 *
 * @author PAOLA-SSD
 */
public interface IEmployeeRepository {
    void saveEmployee(Employee employee);
    void savePaymentDetails(EmployeePaymentDetails paymentDetails);
    void saveAmount(Employee employee);
    void savePassword(Password password);
    void saveSalaryUpdate(SalaryUpdate salaryUpdate);
    void savePDFMetadata(String employeeId, Date startDate, Date endDate);
    void updateEmployeeSalary(String employeeId, double newSalary);
    void updateEmployeeData(Employee employee);
    void deleteEmployeeData(String employeeId);
}

