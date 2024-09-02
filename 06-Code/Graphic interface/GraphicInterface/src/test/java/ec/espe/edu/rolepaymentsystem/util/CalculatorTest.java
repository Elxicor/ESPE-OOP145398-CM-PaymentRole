/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.espe.edu.rolepaymentsystem.util;

import ec.espe.edu.rolepaymentsystem.model.Employee;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Code Master
 */
public class CalculatorTest {
    private Calculator instance;    
    public CalculatorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        instance = new Calculator();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of calculateTotalAmount method, of class Calculator.
     */
    @Test
    public void testCalculateTotalAmount() {
    Date hireDate = new Date();    
    // Test 1: Cálculo básico
    Employee emp1 = new Employee("John", "Doe", "JD123", hireDate, 1000.0, 10.0, 100.0, 50.0, 20.0, 10.0, 1, true);
    assertEquals(218.08, Calculator.calculateTotalDeductions(emp1), 0.01);

    // Test 2: Sin horas extra ni bonos
    Employee emp2 = new Employee("Jane", "Smith", "JS456", hireDate, 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, false);
    assertEquals(916.7, Calculator.calculateTotalAmount(emp2), 0.1);

        // Test 3: Con muchas horas extra
        Employee emp3 = new Employee("Bob", "Brown", "BB789", hireDate, 1000.0, 100.0, 0.0, 0.0, 0.0, 0.0, 0, true);
        assertEquals(1625.0, Calculator.calculateTotalAmount(emp3), 0.01);

        // Test 4: Con grandes préstamos
        Employee emp4 = new Employee("Alice", "Green", "AG101", hireDate, 1000.0, 0.0, 0.0, 500.0, 400.0, 0.0, 0, false);
        assertEquals(100.0, Calculator.calculateTotalAmount(emp4), 0.01);

        // Test 5: Con muchos días de ausencia
        Employee emp5 = new Employee("Charlie", "White", "CW202", hireDate, 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 15, true);
        assertEquals(500.0, Calculator.calculateTotalAmount(emp5), 0.01);

        // Test 6: Con salario mínimo
        Employee emp6 = new Employee("Dave", "Black", "DB303", hireDate, 400.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, false);
        assertEquals(400.0, Calculator.calculateTotalAmount(emp6), 0.01);

        // Test 7: Con salario alto y muchos bonos
        Employee emp7 = new Employee("Eve", "Yellow", "EY404", hireDate, 5000.0, 50.0, 1000.0, 0.0, 0.0, 0.0, 0, true);
        assertEquals(6562.5, Calculator.calculateTotalAmount(emp7), 0.01);

        // Test 8: Con todas las deducciones posibles
        Employee emp8 = new Employee("Frank", "Purple", "FP505", hireDate, 2000.0, 0.0, 0.0, 100.0, 100.0, 100.0, 5, false);
        assertEquals(1366.67, Calculator.calculateTotalAmount(emp8), 0.01);

 // Test 9: Con valores extremos
    Employee emp9 = new Employee("Grace", "Orange", "GO606", hireDate, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 30, true);
    assertEquals(0.0, Calculator.calculateTotalAmount(emp9), 0.01);

    // Test 10: Con valores negativos (no deberían ser posibles en la práctica)
    Employee emp10 = new Employee("Henry", "Red", "HR707", hireDate, -1000.0, -10.0, -100.0, -50.0, -20.0, -10.0, -1, true);
    assertEquals(0.0, Calculator.calculateTotalAmount(emp10), 0.01);
    }
    

    /**
     * Test of calculateOvertimeHours method, of class Calculator.
     */
    @Test
    public void testCalculateOvertimeHours() {
        // Test 1: Horas extra normales
       assertEquals(150.0, Calculator.calculateOvertimeHours(50, 40, 10), 0.01);

        // Test 2: Sin horas extra
        assertEquals(0.0, Calculator.calculateOvertimeHours(40, 40, 10), 0.01);

        // Test 3: Muchas horas extra
        assertEquals(900.0, Calculator.calculateOvertimeHours(100, 40, 10), 0.01);

        // Test 4: Tarifa por hora alta
        assertEquals(375.0, Calculator.calculateOvertimeHours(50, 40, 50), 0.01);

        // Test 5: Horas regulares mayores que las horas trabajadas
        assertEquals(0.0, Calculator.calculateOvertimeHours(30, 40, 10), 0.01);

        // Test 6: Valores decimales
        assertEquals(18.75, Calculator.calculateOvertimeHours(42.5, 40, 10), 0.01);

        // Test 7: Valores extremos
        assertEquals(Double.POSITIVE_INFINITY, Calculator.calculateOvertimeHours(Double.MAX_VALUE, 40, 10), 0.01);

        // Test 8: Tarifa por hora cero
        assertEquals(0.0, Calculator.calculateOvertimeHours(50, 40, 0), 0.01);

        // Test 9: Todos los valores cero
        assertEquals(0.0, Calculator.calculateOvertimeHours(0, 0, 0), 0.01);

        // Test 10: Valores negativos (no deberían ocurrir en la práctica)
        assertEquals(0.0, Calculator.calculateOvertimeHours(-10, -40, -10), 0.01);
    }

    /**
     * Test of calculateReserveFunds method, of class Calculator.
     */
    @Test
    public void testCalculateReserveFunds() {
    // Test 1: Salario básico normal
   assertEquals(83.3, Calculator.calculateReserveFunds(1000), 0.1);
   
    // Test 2: Salario mínimo
    assertEquals(33.33, Calculator.calculateReserveFunds(400), 0.01);

    // Test 3: Salario alto
    assertEquals(416.67, Calculator.calculateReserveFunds(5000), 0.01);

    // Test 4: Valor decimal
    assertEquals(83.75, Calculator.calculateReserveFunds(1005), 0.01);

    // Test 5: Cero
    assertEquals(0, Calculator.calculateReserveFunds(0), 0.01);

    // Test 6: Valor muy pequeño
    assertEquals(0.0008, Calculator.calculateReserveFunds(0.01), 0.0001);

    // Test 7: Valor muy grande
    assertEquals(Double.POSITIVE_INFINITY, Calculator.calculateReserveFunds(Double.MAX_VALUE), 0.01);

    // Test 8: Valor negativo (no debería ocurrir en la práctica)
    assertEquals(0, Calculator.calculateReserveFunds(-1000), 0.01);

    // Test 9: Valor cercano al máximo de Double
    double nearMax = Double.MAX_VALUE / 12;
    assertEquals(nearMax, Calculator.calculateReserveFunds(nearMax * 12), 0.01);

    // Test 10: Valor muy cercano a cero
    assertEquals(8.33e-16, Calculator.calculateReserveFunds(1e-14), 1e-18);

    }

    /**
     * Test of calculateIessContribution method, of class Calculator.
     */
    @Test
    public void testCalculateIessContribution() {
    // Test 1: Salario básico normal
    assertEquals(85.05, Calculator.calculateIessContribution(1000, 100), 0.01);

    // Test 2: Salario mínimo
    assertEquals(33.3, Calculator.calculateIessContribution(400, 40), 0.1);

    // Test 3: Salario alto
    assertEquals(416.5, Calculator.calculateIessContribution(5000, 500), 0.1);

    // Test 4: Valor decimal
    assertEquals(83.75, Calculator.calculateIessContribution(1005, 100.5), 0.01);

    // Test 5: Cero
    assertEquals(0, Calculator.calculateIessContribution(0, 0), 0.01);

    // Test 6: Valor muy pequeño
    assertEquals(0.0008, Calculator.calculateIessContribution(0.01, 0.001), 0.0001);

    // Test 7: Valor muy grande
    assertEquals(Double.POSITIVE_INFINITY, Calculator.calculateIessContribution(Double.MAX_VALUE, 0), 0.01);

    // Test 8: Valor negativo (no debería ocurrir en la práctica)
    assertEquals(0, Calculator.calculateIessContribution(-1000, -100), 0.01);

    // Test 9: Valor cercano al máximo de Double
    double nearMax = Double.MAX_VALUE / 2;
    assertEquals(nearMax, Calculator.calculateIessContribution(nearMax * 2, 0), 0.01);

    // Test 10: Valor muy cercano a cero
    assertEquals(8.33e-16, Calculator.calculateIessContribution(1e-14, 0), 1e-18);
    }

    /**
     * Test of calculateBiweeklyAdvance method, of class Calculator.
     */
    @Test
    public void testCalculateBiweeklyAdvance() {
 // Test 1: Salario básico normal
        assertEquals(0.01, Calculator.calculateBiweeklyAdvance(0.01), 0.000001);

        // Test 2: Salario mínimo
        assertEquals(200, Calculator.calculateBiweeklyAdvance(400), 0.01);

        // Test 3: Salario alto
        assertEquals(2500, Calculator.calculateBiweeklyAdvance(5000), 0.01);

        // Test 4: Valor decimal
        assertEquals(502.5, Calculator.calculateBiweeklyAdvance(1005), 0.01);

        // Test 5: Cero
       assertEquals(0.01, Calculator.calculateBiweeklyAdvance(0.01), 0.000001);

        // Test 6: Valor muy pequeño
        assertEquals(0.005, Calculator.calculateBiweeklyAdvance(0.01), 0.000001);

        // Test 7: Valor muy grande
        assertEquals(Double.POSITIVE_INFINITY, Calculator.calculateBiweeklyAdvance(Double.MAX_VALUE), 0.01);

        // Test 8: Valor negativo (no debería ocurrir en la práctica)
        assertEquals(0, Calculator.calculateBiweeklyAdvance(-1000), 0.01);

        // Test 9: Valor cercano al máximo de Double
        double nearMax = Double.MAX_VALUE / 2;
        assertEquals(nearMax, Calculator.calculateBiweeklyAdvance(nearMax * 2), 0.01);

        // Test 10: Valor muy cercano a cero
        assertEquals(5e-15, Calculator.calculateBiweeklyAdvance(1e-14), 1e-17);

    }

    /**
     * Test of calculateFoodDeduction method, of class Calculator.
     */
    @Test
    public void testCalculateFoodDeduction() {
        // Test 1: No trae comida
    assertEquals(50, Calculator.calculateFoodDeduction(false, 50), 0.01);

    // Test 2: Trae comida
    assertEquals(0, Calculator.calculateFoodDeduction(true, 50), 0.01);

    // Test 3: Deducción alta
    assertEquals(100, Calculator.calculateFoodDeduction(false, 100), 0.01);

    // Test 4: Deducción baja
    assertEquals(10, Calculator.calculateFoodDeduction(false, 10), 0.01);

    // Test 5: Deducción cero
    assertEquals(0, Calculator.calculateFoodDeduction(false, 0), 0.01);

    // Test 6: Deducción negativa (no debería ocurrir en la práctica)
    assertEquals(0, Calculator.calculateFoodDeduction(false, -50), 0.01);

    // Test 7: Valor muy grande
    assertEquals(Double.MAX_VALUE, Calculator.calculateFoodDeduction(false, Double.MAX_VALUE), 0.01);

    // Test 8: Valor decimal
    assertEquals(50.5, Calculator.calculateFoodDeduction(false, 50.5), 0.01);

    // Test 9: Trae comida con deducción alta
    assertEquals(0, Calculator.calculateFoodDeduction(true, 1000), 0.01);

    // Test 10: Valor muy cercano a cero
    assertEquals(1e-14, Calculator.calculateFoodDeduction(false, 1e-14), 1e-16);
    }

    /**
     * Test of calculateTotalIncome method, of class Calculator.
     */
    @Test
    public void testCalculateTotalIncome() {
        // Test 1: Valores normales
        assertEquals(0.0, Calculator.calculateTotalIncome(0, 0, 0), 0.01);

        // Test 2: Sin horas extra ni bonos
        assertEquals(1000, Calculator.calculateTotalIncome(1000, 0, 0), 0.01);

        // Test 3: Solo horas extra
        assertEquals(1200, Calculator.calculateTotalIncome(1000, 200, 0), 0.01);

        // Test 4: Solo bonos
        assertEquals(1100, Calculator.calculateTotalIncome(1000, 0, 100), 0.01);

        // Test 5: Salario alto
        assertEquals(6300, Calculator.calculateTotalIncome(5000, 1000, 300), 0.01);

        // Test 6: Todos los valores cero
        assertEquals(0.0, Calculator.calculateTotalIncome(0, 0, 0), 0.01);

        // Test 7: Valores muy grandes
        assertEquals(Double.POSITIVE_INFINITY, Calculator.calculateTotalIncome(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE), 0.01);

        // Test 8: Valores negativos (no deberían ocurrir en la práctica)
        assertEquals(0.0, Calculator.calculateTotalIncome(-1000, -200, -100), 0.01);

        // Test 9: Valores decimales
        assertEquals(1300.75, Calculator.calculateTotalIncome(1000.25, 200.25, 100.25), 0.01);

        // Test 10: Valor muy cercano a cero
        assertEquals(3e-14, Calculator.calculateTotalIncome(1e-14, 1e-14, 1e-14), 1e-16);
    }

    /**
     * Test of calculateTotalExpenses method, of class Calculator.
     */
    @Test
    public void testCalculateTotalExpenses() {
        // Test 1: Valores normales
        assertEquals(1000, Calculator.calculateTotalExpenses(200, 500, 100, 100, 50, 50), 0.01);

        // Test 2: Sin gastos
        assertEquals(0, Calculator.calculateTotalExpenses(0, 0, 0, 0, 0, 0), 0.01);

        // Test 3: Solo contribución IESS
        assertEquals(200, Calculator.calculateTotalExpenses(200, 0, 0, 0, 0, 0), 0.01);

        // Test 4: Solo adelanto quincenal
        assertEquals(500, Calculator.calculateTotalExpenses(0, 500, 0, 0, 0, 0), 0.01);

        // Test 5: Gastos altos
        assertEquals(5000, Calculator.calculateTotalExpenses(1000, 2000, 1000, 500, 300, 200), 0.01);

        // Test 6: Valores muy grandes
        assertEquals(Double.POSITIVE_INFINITY, Calculator.calculateTotalExpenses(Double.MAX_VALUE, 0, 0, 0, 0, 0), 0.01);

        // Test 7: Valores negativos (no deberían ocurrir en la práctica)
        assertEquals(0, Calculator.calculateTotalExpenses(-200, -500, -100, -100, -50, -50), 0.01);

        // Test 8: Valores decimales
        assertEquals(1000.75, Calculator.calculateTotalExpenses(200.25, 500.25, 100.05, 100.05, 50.05, 50.10), 0.01);

        // Test 9: Valor muy cercano a cero
        assertEquals(6e-14, Calculator.calculateTotalExpenses(1e-14, 1e-14, 1e-14, 1e-14, 1e-14, 1e-14), 1e-16);

        // Test 10: Un gasto muy alto y los demás cero
        assertEquals(Double.MAX_VALUE, Calculator.calculateTotalExpenses(Double.MAX_VALUE, 0, 0, 0, 0, 0), 0.01);

    }

    /**
     * Test of calculateNetPayment method, of class Calculator.
     */
    @Test
    public void testCalculateNetPayment() {
      // Test 1: Ingreso mayor que gastos
        assertEquals(500, Calculator.calculateNetPayment(1500, 1000), 0.01);

        // Test 2: Gastos mayores que ingreso
        assertEquals(0, Calculator.calculateNetPayment(1000, 1500), 0.01);

        // Test 3: Ingreso igual a gastos
        assertEquals(0, Calculator.calculateNetPayment(1000, 1000), 0.01);

        // Test 4: Ingreso cero
        assertEquals(0, Calculator.calculateNetPayment(0, 1000), 0.01);

        // Test 5: Gastos cero
        assertEquals(1000, Calculator.calculateNetPayment(1000, 0), 0.01);

        // Test 6: Ambos cero
        assertEquals(0, Calculator.calculateNetPayment(0, 0), 0.01);

        // Test 7: Valores muy grandes
        assertEquals(0, Calculator.calculateNetPayment(Double.MAX_VALUE, Double.MAX_VALUE), 0.01);

        // Test 8: Valores negativos (no deberían ocurrir en la práctica)
        assertEquals(0, Calculator.calculateNetPayment(-1000, -500), 0.01);

        // Test 9: Valores decimales
        assertEquals(500.25, Calculator.calculateNetPayment(1500.75, 1000.50), 0.01);

        // Test 10: Diferencia muy pequeña
        assertEquals(0.0, Calculator.calculateNetPayment(1 + 1e-14, 1), 1e-16);
    }

    /**
     * Test of calculateEmployerContribution method, of class Calculator.
     */
    @Test
    public void testCalculateEmployerContribution() {
        // Test 1: Valores normales
        assertEquals(133.65, Calculator.calculateEmployerContribution(1000, 100), 0.01);

        // Test 2: Sin fondos de reserva
        assertEquals(115, Calculator.calculateEmployerContribution(1000, 0), 0.01);

        // Test 3: Ingreso alto
        assertEquals(607.5, Calculator.calculateEmployerContribution(5000, 500), 0.01);

        // Test 4: Ingreso mínimo
        assertEquals(46, Calculator.calculateEmployerContribution(400, 0), 0.01);

        // Test 5: Cero ingreso y fondos
        assertEquals(0, Calculator.calculateEmployerContribution(0, 0), 0.01);

        // Test 6: Fondos de reserva iguales al ingreso total
        assertEquals(133.65, Calculator.calculateEmployerContribution(1000, 100), 0.01);

        // Test 7: Valor muy grande
        assertEquals(Double.POSITIVE_INFINITY, Calculator.calculateEmployerContribution(Double.MAX_VALUE, Double.MAX_VALUE), 0.01);

        // Test 8: Valores negativos (no deberían ocurrir en la práctica)
        assertEquals(0, Calculator.calculateEmployerContribution(-1000, -100), 0.01);

        // Test 9: Valores decimales
        assertEquals(121.56, Calculator.calculateEmployerContribution(1000.50, 100.25), 0.01);

        // Test 10: Valor muy cercano a cero
        assertEquals(2.3e-16, Calculator.calculateEmployerContribution(1e-14, 1e-14), 1e-18);
    }

    /**
     * Test of calculateTotalEmployeeCost method, of class Calculator.
     */
    @Test
    public void testCalculateTotalEmployeeCost() {
// Test 1: Valores normales
        assertEquals(0.0, Calculator.calculateTotalEmployeeCost(0, 0), 0.01);

        // Test 2: Sin contribución del empleador
        assertEquals(1000, Calculator.calculateTotalEmployeeCost(1000, 0), 0.01);

        // Test 3: Sin pago neto
        assertEquals(500, Calculator.calculateTotalEmployeeCost(0, 500), 0.01);

        // Test 4: Ambos cero
        assertEquals(0.0, Calculator.calculateTotalEmployeeCost(0, 0), 0.01);

        // Test 5: Valores altos
        assertEquals(6000, Calculator.calculateTotalEmployeeCost(5000, 1000), 0.01);

        // Test 6: Valor muy grande
        assertEquals(Double.POSITIVE_INFINITY, Calculator.calculateTotalEmployeeCost(Double.MAX_VALUE, Double.MAX_VALUE), 0.01);

        // Test 7: Valores negativos (no deberían ocurrir en la práctica)
        assertEquals(0.0, Calculator.calculateTotalEmployeeCost(-1000, -500), 0.01);

        // Test 8: Valores decimales
        assertEquals(1500.75, Calculator.calculateTotalEmployeeCost(1000.50, 500.25), 0.01);

        // Test 9: Valor muy cercano a cero
        assertEquals(2e-14, Calculator.calculateTotalEmployeeCost(1e-14, 1e-14), 1e-16);

        // Test 10: Un valor muy alto y otro normal
        assertEquals(Double.MAX_VALUE, Calculator.calculateTotalEmployeeCost(Double.MAX_VALUE, 1000), 0.01);

    }

    /**
     * Test of calculateTotalDeductions method, of class Calculator.
     */
    @Test
    public void testCalculateTotalDeductions() {
        Date hireDate = new Date();
         // Test 1: Empleado con todas las deducciones
        Employee emp1 = new Employee("John", "Doe", "JD123", hireDate, 1000.0, 10.0, 100.0, 50.0, 20.0, 10.0, 1, true);
        instance.equals(emp1);
        assertEquals(981.92, Calculator.calculateTotalAmount(emp1), 0.01);

        // Test 2: Empleado sin deducciones
        Employee emp2 = new Employee("Jane", "Smith", "JS456", hireDate, 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, true);
        assertEquals(0.0, Calculator.calculateTotalDeductions(emp2), 0.01);

        // Test 3: Solo préstamos IESS
        Employee emp3 = new Employee("Bob", "Brown", "BB789", hireDate, 1000.0, 0.0, 0.0, 200.0, 0.0, 0.0, 0, true);
        assertEquals(200.0, Calculator.calculateTotalDeductions(emp3), 0.01);

        // Test 4: Solo préstamos de la compañía
        Employee emp4 = new Employee("Alice", "Green", "AG101", hireDate, 1000.0, 0.0, 0.0, 0.0, 150.0, 0.0, 0, true);
        assertEquals(150.0, Calculator.calculateTotalDeductions(emp4), 0.01);

        // Test 5: Solo multas
        Employee emp5 = new Employee("Charlie", "White", "CW202", hireDate, 1000.0, 0.0, 0.0, 0.0, 0.0, 75.0, 0, true);
        assertEquals(75.0, Calculator.calculateTotalDeductions(emp5), 0.01);

        // Test 6: Solo días de ausencia
        Employee emp6 = new Employee("Dave", "Black", "DB303",hireDate, 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 5, true);
        assertEquals(166.67, Calculator.calculateTotalDeductions(emp6), 0.01);

        // Test 7: Solo deducción por comida
        Employee emp7 = new Employee("Eve", "Yellow", "EY404", hireDate, 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, false);
        assertEquals(50.0, Calculator.calculateTotalDeductions(emp7), 0.01);

        // Test 8: Salario alto con muchas deducciones
        Employee emp8 = new Employee("Frank", "Purple", "FP505", hireDate, 5000.0, 0.0, 0.0, 500.0, 400.0, 200.0, 3, false);
        assertEquals(1650.0, Calculator.calculateTotalDeductions(emp8), 0.01);

        // Test 9: Valores extremos
        Employee emp9 = new Employee("Grace", "Orange", "GO606", hireDate, Double.MAX_VALUE, 0.0, 0.0, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Integer.MAX_VALUE, false);
        assertEquals(Double.POSITIVE_INFINITY, Calculator.calculateTotalDeductions(emp9), 0.01);

        // Test 10: Valores negativos (no deberían ocurrir en la práctica)
        Employee emp10 = new Employee("Henry", "Red", "HR707", hireDate, -1000.0, 0.0, 0.0, -100.0, -50.0, -20.0, -2, true);
        assertEquals(0.0, Calculator.calculateTotalDeductions(emp10), 0.01);
    }
}
