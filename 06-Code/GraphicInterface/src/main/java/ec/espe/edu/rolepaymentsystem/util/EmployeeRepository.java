/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.rolepaymentsystem.util;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import ec.espe.edu.rolepaymentsystem.model.Employee;
import ec.espe.edu.rolepaymentsystem.model.EmployeePaymentDetails;
import ec.espe.edu.rolepaymentsystem.model.Password;
import ec.espe.edu.rolepaymentsystem.model.RatesParametersUpdate;
import ec.espe.edu.rolepaymentsystem.model.SalaryUpdate;
import java.util.Date;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author PAOLA-SSD
 */
public class EmployeeRepository implements IEmployeeRepository {
    private final MongoDatabase database;
    private static final String COLLECTION_EMPLOYEES = "employees";
    private static final String COLLECTION_PASSWORD="password";
    private static final String COLLECTION_CALCULATOR="calculator";
    private static final String COLLECTION_AMOUNT="amount";
    private static final String COLLECTION_SALARY_UPDATES = "salary_updates";
    private static final String COLLECTION_PDF = "pdf_reports";
    private static final String COLLECTION_RATES_PARAMETERS = "rates_parameters";

    public EmployeeRepository(MongoDatabase database) {
        this.database = database;
    }

    @Override
    public void saveEmployee(Employee employee) {
        MongoCollection<Document> collection = database.getCollection(COLLECTION_EMPLOYEES);
        Document employeeDocument = new Document("id", employee.getIdNumber())
                .append("nombre", employee.getName())
                .append("apellido", employee.getLastName())
                .append("fechaContratacion", employee.getHireDate());
        collection.insertOne(employeeDocument);
    }

    @Override
    public void savePaymentDetails(EmployeePaymentDetails paymentDetails) {
        MongoCollection<Document> collection = database.getCollection(COLLECTION_CALCULATOR);
        Document paymentDetailsDocument = new Document("overtimePayment", paymentDetails.getOvertimePayment())
                .append("reserveFunds", paymentDetails.getReserveFunds())
                .append("totalIncome", paymentDetails.getTotalIncome())
                .append("iessContribution", paymentDetails.getIessContribution())
                .append("biweeklyAdvance", paymentDetails.getBiweeklyAdvance())
                .append("foodDeduction", paymentDetails.getFoodDeduction())
                .append("totalExpenses", paymentDetails.getTotalExpenses())
                .append("netPayment", paymentDetails.getNetPayment())
                .append("employerContribution", paymentDetails.getEmployerContribution())
                .append("totalEmployeeCost", paymentDetails.getTotalEmployeeCost());
        collection.insertOne(paymentDetailsDocument);
    }

    @Override
    public void saveAmount(Employee employee) {
        Calculator calculator = new Calculator();
        MongoCollection<Document> collection = database.getCollection(COLLECTION_AMOUNT);
        Document paymentDetailsDocument = new Document("Id", employee.getIdNumber())
                .append("Nombre", employee.getName())
                .append("Monto", calculator.calculateTotalAmount(employee))
                .append("Estado", "Pagado");
        collection.insertOne(paymentDetailsDocument);
    }

    @Override
    public void savePassword(Password password) {
        MongoCollection<Document> collection = database.getCollection(COLLECTION_PASSWORD);
        Document passwordDocument = new Document("usuario", password.getUser())
                .append("contraseña", password.getPassword());
        collection.insertOne(passwordDocument);
    }

    @Override
    public void saveSalaryUpdate(SalaryUpdate salaryUpdate) {
        MongoCollection<Document> collection = database.getCollection(COLLECTION_SALARY_UPDATES);
        Document document = new Document("oldSalary", salaryUpdate.getOldSalary())
                .append("newSalary", salaryUpdate.getNewSalary())
                .append("updateDate", salaryUpdate.getUpdateDate());
        collection.insertOne(document);
    }

    @Override
    public void savePDFMetadata(String employeeId, Date startDate, Date endDate) {
        MongoCollection<Document> collection = database.getCollection(COLLECTION_PDF);
        Document metadata = new Document()
            .append("employeeId", employeeId)
            .append("startDate", startDate)
            .append("endDate", endDate)
            .append("generationDate", new Date())
            .append("type", "payroll");
        collection.insertOne(metadata);
    }

    @Override
    public void updateEmployeeSalary(String employeeId, double newSalary) {
        MongoCollection<Document> collection = database.getCollection(COLLECTION_EMPLOYEES);
        Bson filter = eq("id", employeeId);
        Bson update = set("basicSalary", newSalary);
        collection.updateOne(filter, update);
    }

    @Override
    public void updateEmployeeData(Employee employee) {
        MongoCollection<Document> collection = database.getCollection(COLLECTION_EMPLOYEES);
        Bson filter = eq("id", employee.getIdNumber());
        Bson updates = combine(
                set("nombre", employee.getName()),
                set("apellido", employee.getLastName()),
                set("fechaContratacion", employee.getHireDate())
        );
        collection.updateOne(filter, updates);
    }
    
    @Override
    public void updateAllEmployeesSalary(double newSalary) {
        MongoCollection<Document> collection = database.getCollection(COLLECTION_EMPLOYEES);
        collection.updateMany(new Document(), new Document("$set", new Document("basicSalary", newSalary)));
    }
    @Override
    public void saveRatesParametersUpdate(RatesParametersUpdate update) {
        MongoCollection<Document> collection = database.getCollection(COLLECTION_RATES_PARAMETERS);
        
        Document updateDocument = new Document()
            .append("oldIessPercentage", update.getOldIessPercentage())
            .append("newIessPercentage", update.getNewIessPercentage())
            .append("oldReserveFundsPercentage", update.getOldReserveFundsPercentage())
            .append("newReserveFundsPercentage", update.getNewReserveFundsPercentage())
            .append("oldOvertimeHourIncrease", update.getOldOvertimeHourIncrease())
            .append("newOvertimeHourIncrease", update.getNewOvertimeHourIncrease())
            .append("oldEmployerContributionPercentage", update.getOldEmployerContributionPercentage())
            .append("newEmployerContributionPercentage", update.getNewEmployerContributionPercentage())
            .append("oldRegularHoursPerMonth", update.getOldRegularHoursPerMonth())
            .append("newRegularHoursPerMonth", update.getNewRegularHoursPerMonth())
            .append("updateDate", update.getUpdateDate());

        collection.insertOne(updateDocument);
    }

    @Override
    public void deleteEmployeeData(String employeeId) {
        MongoCollection<Document> collection = database.getCollection(COLLECTION_EMPLOYEES);
        Bson filter = eq("id", employeeId);
        collection.deleteOne(filter);
    }
}
