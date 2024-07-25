/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.espe.edu.rolepaymentsystem.controller;

import ec.espe.edu.rolepaymentsystem.model.Employee;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PAOLA-SSD
 */
public class EmployeeManagerTest {
    private EmployeeManager instance;
    public EmployeeManagerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
         instance = new EmployeeManager();
         instance.getEmployees().clear();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addEmployee method, of class EmployeeManager.
     */
    @Test
    public void testAddEmployee() {
    // Test 1: Añadir un empleado válido
    Employee employee1 = new Employee("John", "Doe", "JD123456", new Date(), 1000.0, 10.0, 0.0, 100.0, 50.0, 0.0, 0.0, true);
    instance.addEmployee(employee1);
    assertTrue(instance.getEmployees().contains(employee1));

    // Test 2: Añadir un empleado con salario mínimo
    Employee employee2 = new Employee("Jane", "Smith", "JS123457", new Date(), 0.01, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false);
    instance.addEmployee(employee2);
    assertTrue(instance.getEmployees().contains(employee2));

    // Test 3: Añadir un empleado con valores máximos
    Employee employee3 = new Employee("Max", "Value", "MV123458", new Date(), Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, true);
    instance.addEmployee(employee3);
    assertTrue(instance.getEmployees().contains(employee3));

    // Test 4: Añadir un empleado con fecha de contratación futura
    Employee employee4 = new Employee("Future", "Hire", "FH123459", new Date(System.currentTimeMillis() + 86400000), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, true);
    instance.addEmployee(employee4);
    assertTrue(instance.getEmployees().contains(employee4));

    // Test 5: Añadir un empleado con fecha de contratación pasada
    Employee employee5 = new Employee("Past", "Hire", "PH123460", new Date(0), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false);
    instance.addEmployee(employee5);
    assertTrue(instance.getEmployees().contains(employee5));

    // Test 6: Añadir un empleado con nombre muy largo
    Employee employee6 = new Employee("VeryLongFirstName".repeat(10), "VeryLongLastName".repeat(10), "VL123461", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, true);
    instance.addEmployee(employee6);
    assertTrue(instance.getEmployees().contains(employee6));

    // Test 7: Añadir un empleado con caracteres especiales en el nombre
    Employee employee7 = new Employee("Sp€cial", "Ch@racters", "SC123462", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false);
    instance.addEmployee(employee7);
    assertTrue(instance.getEmployees().contains(employee7));

    // Test 8: Añadir un empleado con todos los valores en cero excepto el salario
    Employee employee8 = new Employee("Zero", "Values", "ZV123463", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false);
    instance.addEmployee(employee8);
    assertTrue(instance.getEmployees().contains(employee8));

    // Test 9: Añadir un empleado con todos los valores máximos excepto el salario
    Employee employee9 = new Employee("Max", "Except Salary", "ME123464", new Date(), 1000.0, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, true);
    instance.addEmployee(employee9);
    assertTrue(instance.getEmployees().contains(employee9));

    // Test 10: Añadir un empleado con horas extra muy altas
    Employee employee10 = new Employee("Overtime", "Worker", "OW123465", new Date(), 1000.0, 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, true);
    instance.addEmployee(employee10);
    assertTrue(instance.getEmployees().contains(employee10));
}

    @Test
    public void testUpdateEmployee() {
        // Test 1: Actualizar el salario de un empleado
        Employee employee1 = new Employee("John", "Doe", "JD123456", new Date(), 1000.0, 10.0, 0.0, 100.0, 50.0, 0.0, 0.0, true);
        instance.addEmployee(employee1);
        Employee updatedEmployee1 = new Employee("John", "Doe", "JD123456", new Date(), 1200.0, 10.0, 0.0, 100.0, 50.0, 0.0, 0.0, true);
        instance.updateEmployee(updatedEmployee1);
        Employee retrievedEmployee1 = instance.getEmployees().stream().filter(e -> "JD123456".equals(e.getIdNumber())).findFirst().orElse(null);
        assertNotNull(retrievedEmployee1);
        assertEquals(1200.0, retrievedEmployee1.getBasicSalary(), 0.01);

        // Test 2: Actualizar múltiples campos de un empleado
        Employee employee2 = new Employee("Jane", "Smith", "JS123457", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false);
        instance.addEmployee(employee2);
        Employee updatedEmployee2 = new Employee("Janet", "Smithson", "JS123457", new Date(), 1100.0, 5.0, 1.0, 50.0, 0.0, 100.0, 0.0, true);
        instance.updateEmployee(updatedEmployee2);
        Employee retrievedEmployee2 = instance.getEmployees().stream().filter(e -> "JS123457".equals(e.getIdNumber())).findFirst().orElse(null);
        assertNotNull(retrievedEmployee2);
        assertEquals("Janet", retrievedEmployee2.getName());
        assertEquals("Smithson", retrievedEmployee2.getLastName());
        assertEquals(1100.0, retrievedEmployee2.getBasicSalary(), 0.01);
        assertEquals(5.0, retrievedEmployee2.getOvertimeHours(), 0.01);
        assertEquals(1.0, retrievedEmployee2.getAbsentDays(), 0.01);
        assertEquals(50.0, retrievedEmployee2.getBonuses(), 0.01);
        assertEquals(100.0, retrievedEmployee2.getCompanyLoans(), 0.01);
        assertTrue(retrievedEmployee2.getBringOwnFood());

        // Test 3: Actualizar solo el nombre de un empleado
        Employee employee3 = new Employee("Bob", "Johnson", "BJ123458", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, true);
        instance.addEmployee(employee3);
        Employee updatedEmployee3 = new Employee("Robert", "Johnson", "BJ123458", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, true);
        instance.updateEmployee(updatedEmployee3);
        Employee retrievedEmployee3 = instance.getEmployees().stream().filter(e -> "BJ123458".equals(e.getIdNumber())).findFirst().orElse(null);
        assertNotNull(retrievedEmployee3);
        assertEquals("Robert", retrievedEmployee3.getName());

        // Test 4: Actualizar solo el estado de "traer comida" de un empleado
        Employee employee4 = new Employee("Alice", "Brown", "AB123459", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false);
        instance.addEmployee(employee4);
        Employee updatedEmployee4 = new Employee("Alice", "Brown", "AB123459", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, true);
        instance.updateEmployee(updatedEmployee4);
        Employee retrievedEmployee4 = instance.getEmployees().stream().filter(e -> "AB123459".equals(e.getIdNumber())).findFirst().orElse(null);
        assertNotNull(retrievedEmployee4);
        assertTrue(retrievedEmployee4.getBringOwnFood());

        // Test 5: Actualizar un empleado a valores máximos
        Employee employee5 = new Employee("Max", "Update", "MU123460", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false);
        instance.addEmployee(employee5);
        Employee updatedEmployee5 = new Employee("Max", "Update", "MU123460", new Date(), Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, true);
        instance.updateEmployee(updatedEmployee5);
        Employee retrievedEmployee5 = instance.getEmployees().stream().filter(e -> "MU123460".equals(e.getIdNumber())).findFirst().orElse(null);
        assertNotNull(retrievedEmployee5);
        assertEquals(Double.MAX_VALUE, retrievedEmployee5.getBasicSalary(), 0.01);

        // Test 6: Actualizar un empleado a valores mínimos
        Employee employee6 = new Employee("Min", "Update", "MU123461", new Date(), 1000.0, 10.0, 5.0, 100.0, 50.0, 200.0, 25.0, true);
        instance.addEmployee(employee6);
        Employee updatedEmployee6 = new Employee("Min", "Update", "MU123461", new Date(), 0.01, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false);
        instance.updateEmployee(updatedEmployee6);
        Employee retrievedEmployee6 = instance.getEmployees().stream().filter(e -> "MU123461".equals(e.getIdNumber())).findFirst().orElse(null);
        assertNotNull(retrievedEmployee6);
        assertEquals(0.01, retrievedEmployee6.getBasicSalary(), 0.001);
        assertEquals(0.0, retrievedEmployee6.getOvertimeHours(), 0.001);

        // Test 7: Actualizar la fecha de contratación de un empleado
        Date newHireDate = new Date(System.currentTimeMillis() + 86400000); // Mañana
        Employee employee7 = new Employee("Date", "Update", "DU123462", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, true);
        instance.addEmployee(employee7);
        Employee updatedEmployee7 = new Employee("Date", "Update", "DU123462", newHireDate, 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, true);
        instance.updateEmployee(updatedEmployee7);
        Employee retrievedEmployee7 = instance.getEmployees().stream().filter(e -> "DU123462".equals(e.getIdNumber())).findFirst().orElse(null);
        assertNotNull(retrievedEmployee7);
        assertEquals(newHireDate, retrievedEmployee7.getHireDate());

        // Test 8: Actualizar un empleado con un nombre muy largo
        Employee employee8 = new Employee("Long", "Name", "LN123463", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false);
        instance.addEmployee(employee8);
        Employee updatedEmployee8 = new Employee("VeryLongFirstName".repeat(10), "VeryLongLastName".repeat(10), "LN123463", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false);
        instance.updateEmployee(updatedEmployee8);
        Employee retrievedEmployee8 = instance.getEmployees().stream().filter(e -> "LN123463".equals(e.getIdNumber())).findFirst().orElse(null);
        assertNotNull(retrievedEmployee8);
        assertEquals("VeryLongFirstName".repeat(10), retrievedEmployee8.getName());
        assertEquals("VeryLongLastName".repeat(10), retrievedEmployee8.getLastName());

        // Test 9: Actualizar un empleado con caracteres especiales en el nombre
        Employee employee9 = new Employee("Normal", "Name", "NN123464", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, true);
        instance.addEmployee(employee9);
        Employee updatedEmployee9 = new Employee("Sp€cial", "Ch@racters", "NN123464", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, true);
        instance.updateEmployee(updatedEmployee9);
        Employee retrievedEmployee9 = instance.getEmployees().stream().filter(e -> "NN123464".equals(e.getIdNumber())).findFirst().orElse(null);
        assertNotNull(retrievedEmployee9);
        assertEquals("Sp€cial", retrievedEmployee9.getName());
        assertEquals("Ch@racters", retrievedEmployee9.getLastName());

        // Test 10: Intentar actualizar un empleado que no existe
        Employee nonExistentEmployee = new Employee("Non", "Existent", "NE123465", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false);
        instance.updateEmployee(nonExistentEmployee);
        assertFalse(instance.getEmployees().contains(nonExistentEmployee));
    }
    @Test
    public void testRemoveEmployee() {
        int initial;
        // Test 1: Eliminar un empleado existente
        Employee employee1 = new Employee("John", "Doe", "JD123456", new Date(), 1000.0, 10.0, 0.0, 100.0, 50.0, 0.0, 0.0, true);
        instance.addEmployee(employee1);
        int initialSize = instance.getEmployees().size();
        int index = instance.getEmployees().indexOf(employee1);
        instance.removeEmployee(index);
        assertEquals(initialSize - 1, instance.getEmployees().size());
        assertFalse(instance.getEmployees().contains(employee1));

        // Test 2: Intentar eliminar un empleado con índice fuera de rango (mayor)
        Employee employee2 = new Employee("Jane", "Smith", "JS123457", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false);
        instance.addEmployee(employee2);
        initialSize = instance.getEmployees().size();
        instance.removeEmployee(initialSize + 1);
        assertEquals(initialSize, instance.getEmployees().size());
        assertTrue(instance.getEmployees().contains(employee2));

        // Test 3: Intentar eliminar un empleado con índice negativo
        Employee employee3 = new Employee("Bob", "Johnson", "BJ123458", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, true);
        instance.addEmployee(employee3);
        initialSize = instance.getEmployees().size();
        instance.removeEmployee(-1);
        assertEquals(initialSize, instance.getEmployees().size());
        assertTrue(instance.getEmployees().contains(employee3));

        // Test 4: Eliminar el primer empleado de la lista
        Employee employee4 = new Employee("Alice", "Brown", "AB123459", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false);
        instance.addEmployee(employee4);
        initial = instance.getEmployees().size(); // Utilizar 'var' para la declaración
        instance.removeEmployee(initial - 1); // Usar el índice correcto
        assertEquals(initial - 1, instance.getEmployees().size());
        assertFalse(instance.getEmployees().contains(employee4));

        // Test 5: Eliminar el último empleado de la lista
        Employee employee5 = new Employee("Charlie", "Davis", "CD123460", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, true);
        instance.addEmployee(employee5);
        initialSize = instance.getEmployees().size();
        instance.removeEmployee(initialSize - 1);
        assertEquals(initialSize - 1, instance.getEmployees().size());
        assertFalse(instance.getEmployees().contains(employee5));

        // Test 6: Eliminar un empleado del medio de la lista
        Employee employee6 = new Employee("Eve", "Franklin", "EF123461", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false);
        instance.addEmployee(employee6);
        initialSize = instance.getEmployees().size();
        instance.removeEmployee(initialSize / 2);
        assertEquals(initialSize - 1, instance.getEmployees().size());

        // Test 7: Eliminar todos los empleados uno por uno
        while (!instance.getEmployees().isEmpty()) {
            initialSize = instance.getEmployees().size();
            instance.removeEmployee(0);
            assertEquals(initialSize - 1, instance.getEmployees().size());
        }

        // Test 8: Intentar eliminar un empleado de una lista vacía
        initialSize = instance.getEmployees().size();
        instance.removeEmployee(0);
        assertEquals(initialSize, instance.getEmployees().size());

        // Test 9: Añadir varios empleados y eliminar uno específico
        Employee employee9a = new Employee("Grace", "Harris", "GH123462", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, true);
        Employee employee9b = new Employee("Henry", "Irving", "HI123463", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false);
        Employee employee9c = new Employee("Ivy", "Jones", "IJ123464", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, true);
        instance.addEmployee(employee9a);
        instance.addEmployee(employee9b);
        instance.addEmployee(employee9c);
        initialSize = instance.getEmployees().size();
        instance.removeEmployee(instance.getEmployees().indexOf(employee9b));
        assertEquals(initialSize - 1, instance.getEmployees().size());
        assertFalse(instance.getEmployees().contains(employee9b));
        assertTrue(instance.getEmployees().contains(employee9a));
        assertTrue(instance.getEmployees().contains(employee9c));

        // Test 10: Añadir y eliminar empleados con el mismo nombre pero diferente ID
        Employee employee10a = new Employee("John", "Doe", "JD123465", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, true);
        Employee employee10b = new Employee("John", "Doe", "JD123466", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false);
        instance.addEmployee(employee10a);
        instance.addEmployee(employee10b);
        initialSize = instance.getEmployees().size();
        instance.removeEmployee(instance.getEmployees().indexOf(employee10a));
        assertEquals(initialSize - 1, instance.getEmployees().size());
        assertFalse(instance.getEmployees().contains(employee10a));
        assertTrue(instance.getEmployees().contains(employee10b));
    }

    /**
     * Test of getEmployees method, of class EmployeeManager.
     */
@Test
public void testGetEmployees() {
    // Verifica que la lista de empleados comienza vacía
    assertTrue(instance.getEmployees().isEmpty());
    
    // Test 1: Obtener lista de empleados vacía
    List<Employee> emptyList = instance.getEmployees();
    assertNotNull(emptyList);
    assertTrue(emptyList.isEmpty());

    // Test 2: Añadir un empleado y verificar que la lista aumenta
    Employee employee1 = new Employee("John", "Doe", "JD123456", new Date(), 1000.0, 10.0, 0.0, 100.0, 50.0, 0.0, 0.0, true);
    instance.addEmployee(employee1);
    List<Employee> oneEmployeeList = instance.getEmployees();
    assertNotNull(oneEmployeeList);
    assertEquals(1, oneEmployeeList.size());
    assertTrue(oneEmployeeList.contains(employee1));

    // Test 3: Añadir múltiples empleados y verificar que la lista aumenta correctamente
    Employee employee2 = new Employee("Jane", "Smith", "JS123457", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false);
    Employee employee3 = new Employee("Bob", "Johnson", "BJ123458", new Date(), 1000.0, 5.0, 1.0, 50.0, 0.0, 0.0, 0.0, true);
    instance.addEmployee(employee2);
    instance.addEmployee(employee3);
    List<Employee> multipleEmployeesList = instance.getEmployees();
    assertNotNull(multipleEmployeesList);
    assertEquals(3, multipleEmployeesList.size());

 // Test 4: Verificar que un empleado con un ID específico está presente en la lista después de agregarlo
    Employee employee4 = new Employee("Alice", "Johnson", "AJ123459", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false);
    instance.addEmployee(employee4);
    List<Employee> listWithNewEmployee = instance.getEmployees();
    assertNotNull(listWithNewEmployee);
    assertTrue(listWithNewEmployee.stream().anyMatch(e -> "AJ123459".equals(e.getIdNumber())));

    // Test 5: Eliminar un empleado y verificar que la lista se actualiza
    instance.removeEmployee(0);
    List<Employee> listAfterRemoval = instance.getEmployees();
    assertEquals(3, listAfterRemoval.size());
    assertFalse(listAfterRemoval.contains(employee1));

    // Test 6: Actualizar un empleado y verificar que la lista refleja los cambios
    Employee updatedEmployee = new Employee("Jane", "Doe", "JS123457", new Date(), 1200.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, true);
    instance.updateEmployee(updatedEmployee);
    List<Employee> listAfterUpdate = instance.getEmployees();
    Employee retrievedEmployee = listAfterUpdate.stream().filter(e -> "JS123457".equals(e.getIdNumber())).findFirst().orElse(null);
    assertNotNull(retrievedEmployee);
    assertEquals("Doe", retrievedEmployee.getLastName());
    assertEquals(1200.0, retrievedEmployee.getBasicSalary(), 0.01);
    assertTrue(retrievedEmployee.getBringOwnFood());

    // Test 7: Añadir 100 empleados y verificar que todos están en la lista
    for (int i = 0; i < 100; i++) {
        instance.addEmployee(new Employee("Employee" + i, "Last" + i, "EL" + i, new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, i % 2 == 0));
    }
    List<Employee> largeList = instance.getEmployees();
    assertEquals(103, largeList.size());

    // Test 8: Verificar que los empleados se mantienen en el orden en que fueron añadidos
    List<Employee> orderedList = instance.getEmployees();
    assertEquals("JS123457", orderedList.get(0).getIdNumber());
    assertEquals("BJ123458", orderedList.get(1).getIdNumber());
    assertEquals("AJ123459", orderedList.get(2).getIdNumber());
    assertEquals("EL99", orderedList.get(orderedList.size() - 1).getIdNumber());

    // Test 9: Eliminar todos los empleados y verificar que la lista está vacía
    while (!instance.getEmployees().isEmpty()) {
        instance.removeEmployee(0);
    }
    assertTrue(instance.getEmployees().isEmpty());

    // Test 10: Añadir empleados con el mismo nombre pero diferente ID y verificar que ambos están en la lista
    Employee employee10a = new Employee("John", "Doe", "JD123460", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, true);
    Employee employee10b = new Employee("John", "Doe", "JD123461", new Date(), 1000.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false);
    instance.addEmployee(employee10a);
    instance.addEmployee(employee10b);
    List<Employee> sameNameList = instance.getEmployees();
    assertEquals(2, sameNameList.size());
    assertTrue(sameNameList.contains(employee10a));
    assertTrue(sameNameList.contains(employee10b));
}
}
