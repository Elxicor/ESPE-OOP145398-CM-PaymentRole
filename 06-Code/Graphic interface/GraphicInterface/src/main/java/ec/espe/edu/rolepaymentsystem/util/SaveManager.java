package ec.espe.edu.rolepaymentsystem.util;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import ec.espe.edu.rolepaymentsystem.model.Employee;
import java.io.FileOutputStream;
import java.util.List;
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
//            Image logo = Image.getInstance(logoPath);
//            logo.scaleToFit(200, 100); // Ajusta el tamaño del logo (ancho x alto)
//            logo.setAlignment(Image.ALIGN_CENTER);
//            document.add(logo);
           PdfWriter.getInstance(document, new FileOutputStream(employeesFile));
            document.open();
            document.add(new Paragraph("Lista de Empleados", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLUE)));
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(12); 
            table.setWidthPercentage(100);
            document.add(new Paragraph("Lista de Empleados"));
            document.add(new Paragraph("-------------------------------------------------"));

            String[] headers = {"Nombre", "Apellido", "ID", "Fecha Contratación", "Salario Básico", "Horas Extras", 
                                "Días Ausencia", "Bonificaciones", "Préstamos IESS", "Préstamos Empresa", "Multas", "Trae Comida"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(header, FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                table.addCell(cell);
            }
            for (Employee employee : employees) {
                table.addCell(employee.getName());
                table.addCell(employee.getLastName());
                table.addCell(employee.getIdNumber());
                table.addCell(employee.getHireDate().toString());
                table.addCell(String.valueOf(employee.getBasicSalary()));
                table.addCell(String.valueOf(employee.getOvertimeHours()));
                table.addCell(String.valueOf(employee.getAbsentDays()));
                table.addCell(String.valueOf(employee.getBonuses()));
                table.addCell(String.valueOf(employee.getIessLoans()));
                table.addCell(String.valueOf(employee.getCompanyLoans()));
                table.addCell(String.valueOf(employee.getFines()));
                table.addCell(employee.getBringOwnFood() ? "Sí" : "No");
            }

            document.add(table);
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
        document.open();

        // Añadir el logo si es necesario
//        Image logo = Image.getInstance(logoPath);
//        logo.scaleToFit(200, 100); // Ajusta el tamaño del logo (ancho x alto)
//        logo.setAlignment(Image.ALIGN_CENTER);
//        document.add(logo);

        Paragraph title = new Paragraph("Detalles del Empleado", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLUE));
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        document.add(Chunk.NEWLINE);
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);
        addEmployeeDetail(table, "Nombre", employee.getName());
        addEmployeeDetail(table, "Apellido", employee.getLastName());
        addEmployeeDetail(table, "ID", employee.getIdNumber());
        addEmployeeDetail(table, "Fecha de Contratación", employee.getHireDate().toString());
        addEmployeeDetail(table, "Salario Básico", String.format("$ %.2f", employee.getBasicSalary()));
        addEmployeeDetail(table, "Horas Extras", String.valueOf(employee.getOvertimeHours()));
        addEmployeeDetail(table, "Días de Ausencia", String.valueOf(employee.getAbsentDays()));
        addEmployeeDetail(table, "Bonificaciones", String.format("$ %.2f", employee.getBonuses()));
        addEmployeeDetail(table, "Préstamos IESS", String.format("$ %.2f", employee.getIessLoans()));
        addEmployeeDetail(table, "Préstamos Empresa", String.format("$ %.2f", employee.getCompanyLoans()));
        addEmployeeDetail(table, "Multas", String.format("$ %.2f", employee.getFines()));
        addEmployeeDetail(table, "Trae Comida", employee.getBringOwnFood() ? "Sí" : "No");

        document.add(table);
        System.out.println("Empleado guardado en: " + fileName);
    } catch (DocumentException | IOException e) {
        System.out.println("Error al guardar el empleado individual en el PDF: " + e.getMessage());
    } finally {
        closeConnection();
    }
}
     private void addEmployeeDetail(PdfPTable table, String label, String value) {
        PdfPCell labelCell = new PdfPCell(new Phrase(label, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK)));
        labelCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        labelCell.setBorder(Rectangle.NO_BORDER);
        table.addCell(labelCell);

        PdfPCell valueCell = new PdfPCell(new Phrase(value, FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.DARK_GRAY)));
        valueCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        valueCell.setBorder(Rectangle.NO_BORDER);
        table.addCell(valueCell);
    }
         public void closeConnection() {
        if (document != null) {
            document.close();
        }
    }
}
