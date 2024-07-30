/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.espe.edu.rolepaymentsystem.view;

import ec.espe.edu.rolepaymentsystem.controller.EmployeeManager;
import ec.espe.edu.rolepaymentsystem.model.Employee;
import ec.espe.edu.rolepaymentsystem.util.Calculator;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author PAOLA-SSD
 */
public class FrmPayrollPeriodReport extends javax.swing.JFrame {
    private final EmployeeManager employeeManager;
    private final XYSeries series;
    private final XYDataset dataset;
    private JFreeChart chart;
    private ChartPanel chartPanel;

    public FrmPayrollPeriodReport(EmployeeManager employeeManager) {
        initComponents();
        this.employeeManager = employeeManager;
        series = new XYSeries("Beneficios");
        dataset = new XYSeriesCollection(series);
        initializeChart();
        JMonth.addPropertyChangeListener("month", evt -> updateChart());
        updateChart();
    }
    private void initializeChart() {
        chart = ChartFactory.createXYLineChart(
                "Reporte Mensual de Nómina",
                "Empleado",
                "Beneficio",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(300, 200));
        PanelGrafich.setLayout(new BorderLayout());
        PanelGrafich.removeAll();
        PanelGrafich.add(chartPanel, BorderLayout.CENTER);
        PanelGrafich.revalidate();
        PanelGrafich.repaint();

        // Configurar los ejes del gráfico
        XYPlot plot = (XYPlot) chart.getPlot();
        ValueAxis xAxis = plot.getDomainAxis(); 
        xAxis.setLabel("Empleado"); 
    }
    private void updateChart() {
    Calculator calculator = new Calculator();
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.MONTH, JMonth.getMonth());
    cal.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
    int selectedMonth = cal.get(Calendar.MONTH);
    int selectedYear = cal.get(Calendar.YEAR);
    List<Employee> employees = employeeManager.getEmployees();
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    
    Map<String, Double> employeeBenefits = new HashMap<>();
    for (Employee emp : employees) {
        Calendar empCal = Calendar.getInstance();
        empCal.setTime(emp.getHireDate());
        int hireMonth = empCal.get(Calendar.MONTH);
        int hireYear = empCal.get(Calendar.YEAR);

        if (hireMonth == selectedMonth && hireYear == selectedYear) {
            double totalAmount = calculator.calculateTotalAmount(emp);
            employeeBenefits.put(emp.getIdNumber(), totalAmount);
        }
    }
    List<Map.Entry<String, Double>> sortedEntries = new ArrayList<>(employeeBenefits.entrySet());
    sortedEntries.sort((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()));
    for (Map.Entry<String, Double> entry : sortedEntries) {
        dataset.addValue(entry.getValue(), "", entry.getKey()); 
    }
      chart = ChartFactory.createLineChart(
            "Reporte Mensual de Nómina",
            "Empleado",
            "Beneficio",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
    );
    chartPanel.setPreferredSize(new Dimension(600, 400));
    chartPanel.setChart(chart);
    chartPanel.repaint();
    CategoryPlot plot = chart.getCategoryPlot();
    NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
    double maxValue = getMaxValue(dataset);
    double upperBound = maxValue + 20; // Aumenta el límite superior en un 10%
    rangeAxis.setUpperBound(upperBound);
}
    private double getMaxValue(DefaultCategoryDataset dataset) {
    double max = Double.MIN_VALUE;
    for (int i = 0; i < dataset.getRowCount(); i++) {
        for (int j = 0; j < dataset.getColumnCount(); j++) {
            Number value = dataset.getValue(i, j);
            if (value != null) {
                max = Math.max(max, value.doubleValue());
            }
        }
    }
    return max;
}
    private String getMonthYearString(Calendar cal) {
        String[] monthNames = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        return monthNames[cal.get(Calendar.MONTH)] + " " + cal.get(Calendar.YEAR);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        PanelGrafich = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtIniciarSesion = new javax.swing.JLabel();
        JMonth = new com.toedter.calendar.JMonthChooser();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnBack.setBackground(new java.awt.Color(0, 153, 153));
        btnBack.setText("Atrás");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelGrafichLayout = new javax.swing.GroupLayout(PanelGrafich);
        PanelGrafich.setLayout(PanelGrafichLayout);
        PanelGrafichLayout.setHorizontalGroup(
            PanelGrafichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );
        PanelGrafichLayout.setVerticalGroup(
            PanelGrafichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        txtIniciarSesion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtIniciarSesion.setText("Informe del período de nómina");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtIniciarSesion)
                .addGap(153, 153, 153))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txtIniciarSesion)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Meses:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)
                        .addGap(44, 44, 44)
                        .addComponent(JMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PanelGrafich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(btnBack)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(JMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelGrafich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(13, 13, 13)
                .addComponent(btnBack)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        if(true){//read users from database and compare used nameand
            FrmRolePaymentSystem frmRolePaymentSystem=new FrmRolePaymentSystem();
            this.setVisible(false);
            frmRolePaymentSystem.setVisible(true);
        }
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPayrollPeriodReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPayrollPeriodReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPayrollPeriodReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPayrollPeriodReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EmployeeManager employeeManager=new EmployeeManager();
                FrmPayrollPeriodReport frmPayrollPeriodReport= new FrmPayrollPeriodReport(employeeManager);
                frmPayrollPeriodReport.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JMonthChooser JMonth;
    private javax.swing.JPanel PanelGrafich;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel txtIniciarSesion;
    // End of variables declaration//GEN-END:variables
}
