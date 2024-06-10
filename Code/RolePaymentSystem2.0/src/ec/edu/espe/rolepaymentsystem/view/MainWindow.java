/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.rolepaymentsystem.view;
import ec.edu.espe.rolepaymentsystem.controller.EmployeeManager;
import ec.edu.espe.rolepaymentsystem.controller.PayrollGenerator;
/**
 *
 * @author Erick Tufiño
 */
public class MainWindow {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        PayrollGenerator payrollGenerator = new PayrollGenerator();
        UserInterface userInterface = new UserInterface(employeeManager, payrollGenerator);

        userInterface.showMainMenu();
    }
  }
 
