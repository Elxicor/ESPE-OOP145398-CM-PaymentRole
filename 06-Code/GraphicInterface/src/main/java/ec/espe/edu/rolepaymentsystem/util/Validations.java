/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.rolepaymentsystem.util;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
/**
 *
 * @author Code Masters
 */
public class Validations {
    public boolean isValidId(String value) {
        String regex = "^[LOlo][a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    public boolean getDoubleInput(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public boolean getStringInput(String value){
    return value.matches("[a-zA-Z]+");
    }
    public void validateField(JTextField field, boolean isValid) {
        if (!isValid) {
            field.setForeground(Color.RED);
        } else {
            field.setForeground(Color.BLACK);
            field.setBackground(Color.WHITE);
        }
    }
    public void addKeyListener(JTextField field, final boolean isString) {
        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String input = field.getText();
                if (isString) {
                    validateField(field, getStringInput(input));
                } else {
                    validateField(field, getDoubleInput(input));
                }
            }
        });
    }
}
