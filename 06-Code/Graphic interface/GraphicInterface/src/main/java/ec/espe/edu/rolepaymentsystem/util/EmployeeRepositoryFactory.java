
package ec.espe.edu.rolepaymentsystem.util;

/**
 *
 * @author Erick Tufiño
 */
public interface EmployeeRepositoryFactory {
    IEmployeeRepository createRepository(String type);
}
