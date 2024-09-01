
package ec.espe.edu.rolepaymentsystem.util;
import ec.espe.edu.rolepaymentsystem.model.Employee;
import ec.espe.edu.rolepaymentsystem.model.EmployeePaymentDetails;
import ec.espe.edu.rolepaymentsystem.model.Password;
import ec.espe.edu.rolepaymentsystem.model.RatesParametersUpdate;
import ec.espe.edu.rolepaymentsystem.model.SalaryUpdate;
import java.util.Date;

/**
 *
 * @author Code Master
 */
public class EmployeeToMongo  {  
    private final MongoDBClient mongoDBClient;
    private final IEmployeeRepository employeeRepository;

    public EmployeeToMongo(MongoDBClient mongoDBClient) {
        this.mongoDBClient = mongoDBClient;
        EmployeeRepositoryFactory factory = new EmployeeRepositoryFactoryImpl();
    this.employeeRepository = factory.createRepository("MongoDB");
    }
        public void uploadEmployeeData(Employee employee, EmployeePaymentDetails paymentDetails) {
        employeeRepository.saveEmployee(employee);
        employeeRepository.savePaymentDetails(paymentDetails);
        employeeRepository.saveAmount(employee);
    }
    public void uploadPasswordData(Password password) {
        employeeRepository.savePassword(password);
    }
    public void saveSalaryUpdate(SalaryUpdate salaryUpdate) {
        employeeRepository.saveSalaryUpdate(salaryUpdate);
    }
    public void savePDFMetadata(String employeeId, Date startDate, Date endDate) {
        employeeRepository.savePDFMetadata(employeeId, startDate, endDate);
    }
    public void updateEmployeeSalary(String employeeId, double newSalary) {
        employeeRepository.updateEmployeeSalary(employeeId, newSalary);
    }
    public void updateEmployeeData(Employee employee) {
        employeeRepository.updateEmployeeData(employee);
    }
    public void deleteEmployeeData(String employeeId) {
        employeeRepository.deleteEmployeeData(employeeId);
    }
    public void updateAllEmployeesSalary(double newSalary) {
        employeeRepository.updateAllEmployeesSalary(newSalary);
    }
    public void saveRatesParametersUpdate(RatesParametersUpdate update) {
        employeeRepository.saveRatesParametersUpdate(update);
    }
    public void closeConnection() {
        mongoDBClient.close();
    }
}