/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.rolepaymentsystem.controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author Code Master
 */
public class FileEmployeeStorage implements IEmployeeStorage {
    @Override
    public Reader getReader(String filePath) throws IOException {
        return new FileReader(filePath);
    }
    @Override
    public Writer getWriter(String filePath) throws IOException {
        return new FileWriter(filePath);
    }
}
