/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.rolepaymentsystem.view;

import ec.edu.espe.rolepaymentsystem.model.AdditionalIncome;
import ec.edu.espe.rolepaymentsystem.model.Deduction;
import ec.edu.espe.rolepaymentsystem.model.Employee;
import ec.edu.espe.rolepaymentsystem.model.Deductions;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import utils.FileManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Code Masters
 */
public class RolePaymentSystem {
    public static void main(String[] args) {
        System.out.println("\t\tProgram Initialization");
        try (Scanner scanner = new Scanner(System.in)) {
        int number;
        List<Employee> employees = new ArrayList<>();
        do {
            System.out.println("What would you like to do in the program?\n1. General Payment Role\n2. Individual Pay Role\n3. Generate Report\n4. Exit the program");
            number = scanner.nextInt();
            scanner.nextLine();
            
            switch (number) {
            case 1 -> {
                System.out.println("Enter the number of employees you want to add to the system: ");
                int numberOfEmployees = scanner.nextInt();
                scanner.nextLine();
                addEmployee(scanner, numberOfEmployees, employees);
                    }
            case 2 -> {
                addEmployee(scanner, 1, employees);
                System.out.println("How do you want to generate the payment role in the system?");
                System.out.println("Enter the file type for saving (csv/txt/json):");
                String fileType = scanner.nextLine().toLowerCase();
                Employee employee = employees.get(employees.size() - 1);
                String employeeData = employee.toString(fileType);
                try {
                    FileManager.save(employeeData, "RolePaymentSystem", fileType);
                } catch (IOException ex) {
                    Logger.getLogger(RolePaymentSystem.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Data saved in --> " + fileType);
                }
            case 3 -> {
                System.out.println("How do you want to generate the payment role in the system?");
                System.out.println("Enter the file type for saving (csv/txt/json):");
                String fileTypes = scanner.nextLine().toLowerCase();
                System.out.println("Enter the employee ID:");
                int targetId = scanner.nextInt();
                scanner.nextLine();
                        
                Employee foundEmployee = null;
                for (Employee employe : employees) {
                    if (employe.getId() == targetId) {
                        foundEmployee = employe;
                        break;
                }
                }
                if (foundEmployee != null) {
                    System.out.println("Employee information found!");
                } else {
                    System.out.println("Employee with ID " + targetId + " not found in the list.");
                }
                        
                String employeesData = foundEmployee.toString(fileTypes);
                try {
                    FileManager.save(employeesData, "RolePaymentSystem"+targetId, fileTypes);
                } catch (IOException ex) {
                    Logger.getLogger(RolePaymentSystem.class.getName()).log(Level.SEVERE, null, ex);
                }
                    System.out.println("Data saved in --> " + fileTypes);
                }
            default -> System.out.println("Invalid option. Please try again.");
            }
        } while (number != 4);
    }
    System.out.println("Exited successfully!");
    } 

private static void addEmployee(Scanner scanner, int numberEmployee, List<Employee> employees) {
    for (int i = 0; i < numberEmployee; i++) {
        System.out.println(".Employee Facts:\n" + (i + 1) + ".-Enter employee ID:");
        int idEmployee = scanner.nextInt();
        scanner.nextLine();
        System.out.println((i + 1) + ".-Enter employee name: ");
        String nameEmployee = scanner.nextLine().toLowerCase();

        System.out.println((i + 1) + ".-Enter the employee's minimum wage: ");
        double basicSalaryEmployee = scanner.nextDouble();
        scanner.nextLine();
        System.out.println((i + 1) + ".-Enter the employee's hours worked(hours)");
        int hoursWorked = scanner.nextInt();
        scanner.nextLine();
        System.out.println((i + 1) + ".-Enter the day the employee started(dd/MM/yyyy): ");
        String entryDate = scanner.nextLine();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate entryDates = LocalDate.parse(entryDate, dateFormat);
        System.out.println((i + 1) + ".-Enter the employee's overtime hours:");
        int overtimeHours = scanner.nextInt();
        scanner.nextLine();
        List<Deduction> deductionsList = new ArrayList<>();
        Deductions deductions = calculateDeductions(scanner, deductionsList);
        Employee employee = new Employee(idEmployee, nameEmployee, entryDates, basicSalaryEmployee, hoursWorked, deductions, overtimeHours);
        employees.add(employee); 
    }
}

    private static Deductions calculateDeductions(Scanner scanner, List<Deduction> deductionsList) {
        System.out.println("Select how many deductions you are going to put");
        int numberDeductions = scanner.nextInt();
        scanner.nextLine();
        for (int j = 0; j < numberDeductions; j++) {
            System.out.println("Enter deduction type (1 for Bonuses, 2 for otherBenefits):");
            int deductionType = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter deduction value:");
            double deductionValue = scanner.nextDouble();
            scanner.nextLine();
            Deduction deduction = new Deduction(deductionType, deductionValue);
            deductionsList.add(deduction);
        }
        AdditionalIncome additionalIncome = new AdditionalIncome();
        return new Deductions(deductionsList, additionalIncome);
    }
}