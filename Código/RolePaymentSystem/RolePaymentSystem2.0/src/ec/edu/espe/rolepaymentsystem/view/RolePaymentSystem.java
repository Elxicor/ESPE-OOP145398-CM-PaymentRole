/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.rolepaymentsystem.view;

import ec.edu.espe.rolepaymentsystem.model.Employee;
import ec.edu.espe.rolepaymentsystem.model.PaymentRole;
import ec.edu.espe.rolepaymentsystem.model.HoursWorked;
import ec.edu.espe.rolepaymentsystem.model.AdditionalIncome;
import ec.edu.espe.rolepaymentsystem.model.Deductions;
import ec.edu.espe.rolepaymentsystem.model.ReserveFunds;
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
        Scanner scanner = new Scanner(System.in);
        int number;
        List<Employee> employees = new ArrayList<>();

        do {
            System.out.println("What would you like to do in the program?\n1. General Payment Role\n2. Individual Pay Role\n3. Generate Report\n4. Exit the program");
            number = scanner.nextInt();
            scanner.nextLine();

            switch (number) {
                case 1:
                    System.out.println("Enter the number of employees you want to add to the system: ");
                    int numberOfEmployees = scanner.nextInt();
                    scanner.nextLine(); 
                    addEmployee(scanner, numberOfEmployees, employees);
                    break;
                case 2:
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
                    break;
                case 3:
                    System.out.println("How do you want to generate the payment role in the system?");
                    System.out.println("Enter the file type for saving (csv/txt/json):");
                    String fileTypes = scanner.nextLine().toLowerCase();
                    System.out.println("Enter the employee ID:");
                    int targetId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline after nextInt()

                    Employee foundEmployee = null;
                    for (Employee emp : employees) {
                        if (emp.getId() == targetId) {
                            foundEmployee = emp;
                            break;
                        }
                    }

                    if (foundEmployee != null) {
                        System.out.println("Employee information found!");
                        String employeesData = foundEmployee.toString(fileTypes);
                        try {
                            FileManager.save(employeesData, "RolePaymentSystem" + foundEmployee.getId(), fileTypes);
                        } catch (IOException ex) {
                            Logger.getLogger(RolePaymentSystem.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println("Data saved in --> " + fileTypes);
                    } else {
                        System.out.println("Employee with ID " + targetId + " not found in the list.");
                    }
                    break;
                case 4:
                    System.out.println("Exited successfully!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (number != 4);

        scanner.close();
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

            System.out.println((i + 1) + ".-Enter the employee's hours worked(hours):");
            int hoursWorked = scanner.nextInt();
            scanner.nextLine();

            System.out.println((i + 1) + ".-Enter the day the employee started(dd/MM/yyyy): ");
            String entryDate = scanner.nextLine();
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate entryDates = LocalDate.parse(entryDate, dateFormat);

           HoursWorked hoursWorkedObject = new HoursWorked(hoursWorked, 0, 0);
           Employee employee = new Employee(idEmployee, nameEmployee, basicSalaryEmployee, hoursWorkedObject, entryDates);

            // Create instances of related classes
            PaymentRole paymentRole = new PaymentRole(idEmployee, new Employee[]{employee}, basicSalaryEmployee, 0, 0, new ArrayList<Deductions>());
            Deductions deductions = new Deductions(0, 0, 0, 0, 0, new AdditionalIncome[]{});
            AdditionalIncome additionalIncome = new AdditionalIncome(idEmployee, 0, 0, 0);
            ReserveFunds reserveFunds = new ReserveFunds(idEmployee, new Employee[]{employee}, 0, entryDates);

            System.out.println("Enter IESS contribution: ");
            double iessContribution = scanner.nextDouble();
            deductions.setContributionIESS(iessContribution);

            System.out.println("Enter bonuses: ");
            double bonuses = scanner.nextDouble();
            additionalIncome.setBonuses(bonuses);

            System.out.println("Enter reserve funds: ");
            double reserveFundsAmount = scanner.nextDouble();
            reserveFunds.setReserveFunds(reserveFundsAmount);

            // Add related objects to employee
           /* employee.setPaymentRole(paymentRole);
            employee.setDeductions(deductions);
            employee.setHoursWorked(hoursWorkedObject);
            employee.setAdditionalIncome(additionalIncome);
            employee.setReserveFunds(reserveFunds);*/

            employees.add(employee);
        }
    }

    private static void calculateSalary() {
        // Calculate salary logic here
    }
}
