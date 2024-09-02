
package ec.espe.edu.rolepaymentsystem.util;

/**
 *
 * @author Erick Tufiño
 */
public class EmployeeRepositoryFactoryImpl implements EmployeeRepositoryFactory {
    @Override
    public IEmployeeRepository createRepository(String type) {
        if (type.equalsIgnoreCase("MongoDB")) {
            return new EmployeeRepository(MongoDBClient.getInstance().getDatabase());
        }
        return null;
    }
}
