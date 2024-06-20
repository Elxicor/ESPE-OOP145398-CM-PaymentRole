
package ec.edu.espe.rolepaymentsystem.controller;
import java.util.Scanner;
/**
 *
 * @author Code Masters
 */

public class LoginScreen {
    private final String password = "admin";

    public void checkPassword() {
        boolean checker = true;
        int attemptCount = 0;
        Scanner scanner = new Scanner(System.in);

        while (checker) {
            System.out.print("Ingrese la contrasenia: ");
            String enteredPassword = scanner.nextLine();

            if (enteredPassword.equals(password)) {
                System.out.println("Contrasenia correcta");
                checker = false;
            } else {
                attemptCount++;
                System.out.println("Contrasenia incorrecta");
            }
        }
    }
}
