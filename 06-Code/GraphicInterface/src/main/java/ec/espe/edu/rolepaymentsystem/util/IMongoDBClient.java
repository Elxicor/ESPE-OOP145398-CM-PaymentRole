/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.rolepaymentsystem.util;

import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Code Master
 */
public interface IMongoDBClient {
    MongoDatabase getDatabase();
    void close();
}

