/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.rolepaymentsystem.util;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import ec.espe.edu.rolepaymentsystem.model.Employee;
import ec.espe.edu.rolepaymentsystem.model.EmployeePaymentDetails;
import ec.espe.edu.rolepaymentsystem.model.Password;
import ec.espe.edu.rolepaymentsystem.model.SalaryUpdate;
import java.util.Date;
import org.bson.Document;
import org.bson.conversions.Bson;
/**
 *
 * @author Code Master
 */
public class EmployeeToMongo  {
//    private static final String CONNECTION_STRING = "mongodb+srv://yasisalema:yasisalema@cluster0.51fic9g.mongodb.net/";
//    private static final String DATABASE_NAME = "RolePaymentSystem";
//    private static final String COLLECTION_EMPLOYEES = "employees";
//    private static final String COLLECTION_PASSWORD="password";
//    private static final String COLLECTION_CALCULATOR="calculator";
//    private static final String COLLECTION_AMOUNT="amount";
//    private static final String COLLECTION_SALARY_UPDATES = "salary_updates";
//    private static final String COLLECTION_PDF = "pdf_reports";
//    
//    private MongoClient mongoClient;
//    private MongoDatabase database;
//
//    public EmployeeToMongo() {
//        this.mongoClient = createMongoClient();
//        this.database = mongoClient.getDatabase(DATABASE_NAME);
//    }
//
//    private static MongoClient createMongoClient() {
//        ServerApi serverApi = ServerApi.builder().version(ServerApiVersion.V1).build();
//        
//        MongoClientSettings settings = MongoClientSettings.builder()
//                .applyConnectionString(new ConnectionString(CONNECTION_STRING))
//                .serverApi(serverApi)
//                .build();
//     
//        return MongoClients.create(settings);
//    }
//    
//    public void uploadEmployeeData(Employee employee,EmployeePaymentDetails paymentDetails) {
//        try {
//            saveEmployeeToDatabase(employee, database);
//            savePaymentDetailsToDatabase(paymentDetails,database);
//            saveAmountToDatabase(employee,database);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    
//    private void saveEmployeeToDatabase(Employee employee, MongoDatabase database) {
//        MongoCollection<Document> collection = database.getCollection(COLLECTION_EMPLOYEES);
//        Document employeeDocument = new Document("id", employee.getIdNumber())
//                .append("nombre", employee.getName())
//                .append("apellido", employee.getLastName())
//                .append("fechaContratacion", employee.getHireDate());
//                
//        try {
//            collection.insertOne(employeeDocument);
//            System.out.println("Empleado guardado exitosamente!");
//        } catch (MongoException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void savePaymentDetailsToDatabase(EmployeePaymentDetails paymentDetails, MongoDatabase database) {
//        MongoCollection<Document> collection = database.getCollection(COLLECTION_CALCULATOR); 
//        Document paymentDetailsDocument = new Document("overtimePayment", paymentDetails.getOvertimePayment())
//                .append("reserveFunds", paymentDetails.getReserveFunds())
//                .append("totalIncome", paymentDetails.getTotalIncome())
//                .append("iessContribution", paymentDetails.getIessContribution())
//                .append("biweeklyAdvance", paymentDetails.getBiweeklyAdvance())
//                .append("foodDeduction", paymentDetails.getFoodDeduction())
//                .append("totalExpenses", paymentDetails.getTotalExpenses())
//                .append("netPayment", paymentDetails.getNetPayment())
//                .append("employerContribution", paymentDetails.getEmployerContribution())
//                .append("totalEmployeeCost", paymentDetails.getTotalEmployeeCost());
//
//        try {
//            collection.insertOne(paymentDetailsDocument);
//            System.out.println("Detalles de pago guardados exitosamente!");
//        } catch (MongoException e) {
//            e.printStackTrace();
//        }
//    }
//    private void saveAmountToDatabase(Employee employee, MongoDatabase database) {
//        Calculator calculator=new Calculator();
//        MongoCollection<Document> collection = database.getCollection(COLLECTION_AMOUNT); 
//        Document paymentDetailsDocument = new Document("Id", employee.getIdNumber())
//                .append("Nombre", employee.getName())
//                .append("Monto", calculator.calculateTotalAmount(employee))
//                .append("Estado", "Pagado");
//        try {
//            collection.insertOne(paymentDetailsDocument);
//            System.out.println("Detalles de pago guardados exitosamente!");
//        } catch (MongoException e) {
//            e.printStackTrace();
//        }
//    }    
//
//
//   public void uploadPasswordData(Password password) {
//        try {
//            savePasswordToDatabase(password, database);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//   private void savePasswordToDatabase( Password password,MongoDatabase database) {
//        MongoCollection<Document> collection = database.getCollection(COLLECTION_PASSWORD);
//        Document passwordDocument = new Document("usuario", password.getUser())
//                .append("contraseña", password.getPassword());
//                
//        try {
//            collection.insertOne(passwordDocument);
//            System.out.println("Contraseña guardado exitosamente!");
//        } catch (MongoException e) {
//            e.printStackTrace();
//        }
//    }
//    public void saveSalaryUpdate(SalaryUpdate salaryUpdate) {
//        MongoCollection<Document> collection = database.getCollection(COLLECTION_SALARY_UPDATES);
//        Document document = new Document("oldSalary", salaryUpdate.getOldSalary())
//                .append("newSalary", salaryUpdate.getNewSalary())
//                .append("updateDate", salaryUpdate.getUpdateDate());
//        try {
//            collection.insertOne(document);
//            System.out.println("Actualización de salario guardada exitosamente!");
//        } catch (MongoException e) {
//            e.printStackTrace();
//        }
//    }
//    public void savePDFMetadata(String employeeId, Date startDate, Date endDate) {
//        MongoCollection<Document> collection = database.getCollection(COLLECTION_PDF);
//        Document metadata = new Document()
//            .append("employeeId", employeeId)
//            .append("startDate", startDate)
//            .append("endDate", endDate)
//            .append("generationDate", new Date())
//            .append("type", "payroll");
//        try {
//            collection.insertOne(metadata);
//            System.out.println("Metadatos del PDF guardados exitosamente!");
//        } catch (MongoException e) {
//            e.printStackTrace();
//        }
//    }
//    public void updateEmployeeSalary(String employeeId, double newSalary) {
//        try {
//            MongoCollection<Document> collection = database.getCollection(COLLECTION_EMPLOYEES);
//            Bson filter = eq("id", employeeId);
//            Bson update = set("basicSalary", newSalary);
//            UpdateResult result = collection.updateOne(filter, update);
//            if (result.getMatchedCount() > 0) {
//                System.out.println("Salario del empleado actualizado exitosamente!");
//            } else {
//                System.out.println("Empleado no encontrado.");
//            }
//        } catch (MongoException e) {
//            e.printStackTrace();
//        }
//    }
//    public void updateEmployeeData(Employee employee) {
//        try {
//            MongoCollection<Document> collection = database.getCollection(COLLECTION_EMPLOYEES);
//            Bson filter = eq("id", employee.getIdNumber());
//            Bson updates = combine(
//                    set("nombre", employee.getName()),
//                    set("apellido", employee.getLastName()),
//                    set("fechaContratacion", employee.getHireDate())
//            );
//            UpdateResult result = collection.updateOne(filter, updates);
//            if (result.getMatchedCount() > 0) {
//                System.out.println("Empleado actualizado exitosamente!");
//            } else {
//                System.out.println("Empleado no encontrado.");
//            }
//        } catch (MongoException e) {
//            e.printStackTrace();
//        }
//    }
//    public MongoCollection<Document> getCollection() {
//        return database.getCollection(COLLECTION_EMPLOYEES);
//    }
//    public void deleteEmployeeData(String employeeId) {
//        try {
//            MongoCollection<Document> collection = database.getCollection(COLLECTION_EMPLOYEES);
//            Bson filter = eq("id", employeeId);
//            DeleteResult result = collection.deleteOne(filter);
//            if (result.getDeletedCount() > 0) {
//                System.out.println("Empleado eliminado exitosamente!");
//            } else {
//                System.out.println("Empleado no encontrado.");
//            }
//        } catch (MongoException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public MongoDatabase getDatabase() {
//        return database;
//    }
//
//    public void closeConnection() {
//        if (mongoClient != null) {
//            mongoClient.close();
//        }
//    }
    private final MongoDBClient mongoDBClient;
    private final EmployeeRepository employeeRepository;

    public EmployeeToMongo(MongoDBClient mongoDBClient) {
        this.mongoDBClient = mongoDBClient;
        this.employeeRepository = new EmployeeRepository(mongoDBClient.getDatabase());
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

    public void closeConnection() {
        mongoDBClient.close();
    }
}

