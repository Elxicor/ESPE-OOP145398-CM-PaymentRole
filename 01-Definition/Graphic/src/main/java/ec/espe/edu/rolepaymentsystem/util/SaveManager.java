package ec.espe.edu.rolepaymentsystem.util;
import ec.espe.edu.rolepaymentsystem.model.Employee;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Image;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


/**
 *
 * @author Code Master
 */
public class SaveManager {
   private final  Document document = new Document();
   private final String employeesFile = "employees.pdf";
   private final String logoPath = "path/to/logo.png"; 

   public void saveEmployees(List<Employee> employees) {
        try {
            PdfWriter.getInstance(document, new FileOutputStream(employeesFile));
            document.open();
//            Image logo = Image.getInstance(logoPath);
//            logo.scaleToFit(200, 100); // Ajusta el tamaño del logo (ancho x alto)
//            logo.setAlignment(Image.ALIGN_CENTER);
//            document.add(logo);
            document.add(new Paragraph("Lista de Empleados"));
            document.add(new Paragraph("-------------------------------------------------"));

            for (Employee employee : employees) {
                document.add(new Paragraph("Nombre: " + employee.getName()));
                document.add(new Paragraph("Apellido: " + employee.getLastName()));
                document.add(new Paragraph("ID: " + employee.getIdNumber()));
                document.add(new Paragraph("Fecha de Contratación: " + employee.getHireDate()));
                document.add(new Paragraph("Salario Básico: " + employee.getBasicSalary()));
                document.add(new Paragraph("Horas Extras: " + employee.getOvertimeHours()));
                document.add(new Paragraph("Días de Ausencia: " + employee.getAbsentDays()));
                document.add(new Paragraph("Bonificaciones: " + employee.getBonuses()));
                document.add(new Paragraph("Préstamos IESS: " + employee.getIessLoans()));
                document.add(new Paragraph("Préstamos Empresa: " + employee.getCompanyLoans()));
                document.add(new Paragraph("Multas: " + employee.getFines()));
                document.add(new Paragraph("Trae Comida: " + (employee.getBringOwnFood() ? "Sí" : "No")));
                document.add(new Paragraph("-------------------------------------------------"));
            }
            System.out.println("Empleados guardados exitosamente en el archivo: " + employeesFile);
        } catch (DocumentException | IOException e) {
            System.out.println("Error al guardar los empleados en el PDF: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }
    public void saveIndividualEmployee(Employee employee) {
        String fileName = employee.getIdNumber() + "_employee.pdf";
        try {
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
//            Image logo = Image.getInstance(logoPath);
//            logo.scaleToFit(200, 100); // Ajusta el tamaño del logo (ancho x alto)
//            logo.setAlignment(Image.ALIGN_CENTER);
//            document.add(logo);
            document.open();
            document.add(new Paragraph("Nombre: " + employee.getName()));
            document.add(new Paragraph("Apellido: " + employee.getLastName()));
            document.add(new Paragraph("ID: " + employee.getIdNumber()));
            document.add(new Paragraph("Fecha de Contratación: " + employee.getHireDate()));
            document.add(new Paragraph("Salario Básico: " + employee.getBasicSalary()));
            document.add(new Paragraph("Horas Extras: " + employee.getOvertimeHours()));
            document.add(new Paragraph("Días de Ausencia: " + employee.getAbsentDays()));
            document.add(new Paragraph("Bonificaciones: " + employee.getBonuses()));
            document.add(new Paragraph("Préstamos IESS: " + employee.getIessLoans()));
            document.add(new Paragraph("Préstamos Empresa: " + employee.getCompanyLoans()));
            document.add(new Paragraph("Multas: " + employee.getFines()));
            document.add(new Paragraph("Trae Comida: " + (employee.getBringOwnFood() ? "Sí" : "No")));
            System.out.println("Empleado guardado en: " + fileName);
        } catch (DocumentException | IOException e) {
            System.out.println("Error al guardar el empleado individual en el PDF: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }
    public void closeConnection() {
        if (document != null) {
            document.close();
        }
    }
}
