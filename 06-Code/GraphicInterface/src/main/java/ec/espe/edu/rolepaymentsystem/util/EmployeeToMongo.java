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
import ec.espe.edu.rolepaymentsystem.model.Employee;
import org.bson.Document;
/**
 *
 * @author PAOLA-SSD
 */
public class EmployeeToMongo {
    private static final String CONNECTION_STRING = "mongodb+srv://yasisalema:yasisalema@cluster0.51fic9g.mongodb.net/";
    private static final String DATABASE_NAME = "RolePaymentSystem";
    private static final String COLLECTION_NAME = "employees";

    private MongoClient mongoClient;
    private MongoDatabase database;

    public EmployeeToMongo() {
        this.mongoClient = createMongoClient();
        this.database = mongoClient.getDatabase(DATABASE_NAME);
    }

    private static MongoClient createMongoClient() {
        ServerApi serverApi = ServerApi.builder().version(ServerApiVersion.V1).build();
        
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(CONNECTION_STRING))
                .serverApi(serverApi)
                .build();
     
        return MongoClients.create(settings);
    }
    
    public void uploadEmployeeData(Employee employee) {
        try {
            saveEmployeeToDatabase(employee, database);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void saveEmployeeToDatabase(Employee employee, MongoDatabase database) {
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
        Document employeeDocument = new Document("id", employee.getIdNumber())
                .append("nombre", employee.getName())
                .append("apellido", employee.getLastName())
                .append("fechaContratacion", employee.getHireDate());
                
        try {
            collection.insertOne(employeeDocument);
            System.out.println("Empleado guardado exitosamente!");
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    public MongoCollection<Document> getCollection() {
        return database.getCollection(COLLECTION_NAME);
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
