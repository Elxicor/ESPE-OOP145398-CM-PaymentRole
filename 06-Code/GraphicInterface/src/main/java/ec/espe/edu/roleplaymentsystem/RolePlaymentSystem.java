/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.espe.edu.roleplaymentsystem;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author PAOLA-SSD
 */
public class RolePlaymentSystem {

    public void escalarlabel(JLabel label,String rutaImagen){
        label.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(rutaImagen)).getImage().getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_DEFAULT)));
    }
}
