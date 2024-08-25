package ec.espe.edu.rolepaymentsystem.controller;

import ec.espe.edu.rolepaymentsystem.model.Employee;
import java.util.List;

/**
 *
 * @author Code Master
 */

public interface IEmployeeStorage {
    List<Employee> load();
    void save(List<Employee> employees);
}