/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Images;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Code Master
 */
public class Images {
    public void escalarlabel(JLabel label, String rutaImagen) {
        try {
            java.net.URL imageURL = getClass().getResource(rutaImagen);
            if (imageURL != null) {
                ImageIcon icon = new ImageIcon(imageURL);
                Image image = icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(image));
            } else {
                System.out.println("Error: No se pudo encontrar la imagen en la ruta " + rutaImagen);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
