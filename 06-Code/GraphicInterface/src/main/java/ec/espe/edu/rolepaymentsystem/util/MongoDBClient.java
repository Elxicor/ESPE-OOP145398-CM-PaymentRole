
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.rolepaymentsystem.util;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Code Master
 */
public class MongoDBClient implements IMongoDBClient{
    private static final String CONNECTION_STRING = "mongodb+srv://yasisalema:yasisalema@cluster0.51fic9g.mongodb.net/";
    private static final String DATABASE_NAME = "RolePaymentSystem";
    
    private static MongoDBClient instance;
    private final MongoClient mongoClient;
    private final MongoDatabase database;

    private MongoDBClient() {
        this.mongoClient = createMongoClient();
        this.database = mongoClient.getDatabase(DATABASE_NAME);
    }

    private MongoClient createMongoClient() {
        ServerApi serverApi = ServerApi.builder().version(ServerApiVersion.V1).build();
        
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(CONNECTION_STRING))
                .serverApi(serverApi)
                .build();
     
        return MongoClients.create(settings);
    }
    
    public static MongoDBClient getInstance() {
        if (instance == null) {
            instance = new MongoDBClient();
        }
        return instance;
    }

    @Override
    public MongoDatabase getDatabase() {
        return database;
    }

    @Override
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
