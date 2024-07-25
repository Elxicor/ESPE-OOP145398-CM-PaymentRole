/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.espe.edu.rolepaymentsystem.view;

import ec.espe.edu.rolepaymentsystem.controller.EmployeeManager;
import ec.espe.edu.rolepaymentsystem.model.Employee;
import ec.espe.edu.rolepaymentsystem.util.EmployeeToMongo;
import ec.espe.edu.rolepaymentsystem.util.SaveManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Code Master
 */
public class FrmGeneratePaymentRoles extends javax.swing.JFrame {
    private final EmployeeManager employeeManager;
    private final FrmAllEmployee frmAllEmployee;
    private DefaultTableModel tableModel;
    private EmployeeToMongo employeeToMongo;
    SaveManager saveManager;
    /**
     * Creates new form FrmGenerarPayroll
     * @param frmAllEmployee
     */
    public FrmGeneratePaymentRoles(FrmAllEmployee frmAllEmployee) {
        initComponents();
        this.employeeManager = frmAllEmployee.getEmployeeManager();
        this.frmAllEmployee = frmAllEmployee;
        this.saveManager = new SaveManager();
        this.employeeToMongo = new EmployeeToMongo();
        initializeTable();
        setupTableSelectionListener();
        cmbMonth.addPropertyChangeListener("month", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                setPeriod();
            }
        });
        cmbYears.addPropertyChangeListener("year", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                setPeriod();
            }
        });
        setPeriod();
    }
    private void initializeTable() {
        tableModel = frmAllEmployee.getTableModel();
        tableAllEmployee.setModel(tableModel);
    }
    private void populateEmployeeComboBox(int selectedMonth, int selectedYear) {
        cmbAddEmployee.removeAllItems();
        cmbAddEmployee.addItem("Seleccione un empleado");
        List<Employee> employees = employeeManager.getEmployees();
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

        for (Employee emp : employees) {
            Date hireDate = emp.getHireDate();
            int empMonth = Integer.parseInt(monthFormat.format(hireDate));
            int empYear = Integer.parseInt(yearFormat.format(hireDate));

            if (empMonth == selectedMonth && empYear == selectedYear) {
                cmbAddEmployee.addItem(emp.getName() + " " + emp.getLastName());
            }
        }
    }
    private void setPeriod() {
    int selectedMonth = cmbMonth.getMonth() + 1; 
    int selectedYear = cmbYears.getYear();
    populateEmployeeComboBox(selectedMonth, selectedYear);
    }
    private void setupTableSelectionListener() {
    tableAllEmployee.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tableAllEmployee.getSelectedRow();
                if (selectedRow != -1) {
                    Employee selectedEmployee = employeeManager.getEmployees().get(selectedRow);
                    showEmployeeDetails(selectedEmployee);
                }
            }
        }
    });
    }
    private void showEmployeeDetails(Employee employee) {
    FrmEmployeeDetails frmEmployeeDetails = new FrmEmployeeDetails(employee, this);
    this.setVisible(false);
    frmEmployeeDetails.setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbAddEmployee = new javax.swing.JComboBox<>();
        btnGeneratePayroll = new javax.swing.JButton();
        btnGenerateIndividually = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAllEmployee = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtIniciarSesion = new javax.swing.JLabel();
        cmbMonth = new com.toedter.calendar.JMonthChooser();
        cmbYears = new com.toedter.calendar.JYearChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Periodo:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Generar rol de pago individual:");

        jLabel3.setText("Empleado:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Generar rol de pago individual:");

        cmbAddEmployee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "adsasdadsa" }));
        cmbAddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAddEmployeeActionPerformed(evt);
            }
        });

        btnGeneratePayroll.setBackground(new java.awt.Color(0, 255, 204));
        btnGeneratePayroll.setText("Generar");
        btnGeneratePayroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneratePayrollActionPerformed(evt);
            }
        });

        btnGenerateIndividually.setBackground(new java.awt.Color(0, 255, 204));
        btnGenerateIndividually.setText("Generar");
        btnGenerateIndividually.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateIndividuallyActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 255, 204));
        btnBack.setText("Atrás");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tableAllEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Ulloa", "Flores",  new Integer(17536989), "12/02/2004"},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.", "Nombre", "Apellido", "Numero de identificacion:", "Date of hire:"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableAllEmployee);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        txtIniciarSesion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtIniciarSesion.setText("Generar roles de pago");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(txtIniciarSesion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtIniciarSesion)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbYears, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGenerateIndividually, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGeneratePayroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(183, 183, 183))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbMonth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmbYears, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerateIndividually))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnGeneratePayroll)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBack)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGeneratePayrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneratePayrollActionPerformed
    List<Employee> employees = employeeManager.getEmployees();
    if(!employees.isEmpty()){
        saveManager.saveEmployees(employees); 
        for (Employee employee : employees) {
                employeeToMongo.uploadEmployeeData(employee);
            }
        JOptionPane.showMessageDialog(this, "Se generó el rol de pagos", "Generación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        }else{
        JOptionPane.showMessageDialog(this, "Debe generar la lista de empleados ", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnGeneratePayrollActionPerformed

    private void btnGenerateIndividuallyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateIndividuallyActionPerformed
    int selected = cmbAddEmployee.getSelectedIndex();
    if(selected != -1){ 
        Employee selectedEmployee = employeeManager.getEmployees().get(selected);
        boolean savedLocally = false;
        boolean savedToMongo = false;

        try {
            saveManager.saveIndividualEmployee(selectedEmployee);
            savedLocally = true;
        } catch (Exception e) {
            System.err.println("Error al guardar localmente: " + e.getMessage());
        }

        try {
            employeeToMongo.uploadEmployeeData(selectedEmployee);
            savedToMongo = true;
        } catch (Exception e) {
            System.err.println("Error al guardar en MongoDB: " + e.getMessage());
        }

        if (savedLocally && savedToMongo) {
            JOptionPane.showMessageDialog(this, 
                "Se guardaron los datos del empleado: " + selectedEmployee.getName() + " " + selectedEmployee.getLastName() + 
                " localmente y en la base de datos MongoDB", 
                "Generación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else if (savedLocally) {
            JOptionPane.showMessageDialog(this, 
                "Se guardaron los datos del empleado localmente, pero hubo un error al guardar en MongoDB", 
                "Generación Parcial", JOptionPane.WARNING_MESSAGE);
        } else if (savedToMongo) {
            JOptionPane.showMessageDialog(this, 
                "Se guardaron los datos del empleado en MongoDB, pero hubo un error al guardar localmente", 
                "Generación Parcial", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, 
                "Hubo un error al guardar los datos del empleado tanto localmente como en MongoDB", 
                "Error de Generación", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione el empleado que desea generar ", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnGenerateIndividuallyActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        if(true){//read users from database and compare used nameand 
        FrmRolePaymentSystem frmRolePlaymentSystem=new FrmRolePaymentSystem(); 
        this.setVisible(false); 
        frmRolePlaymentSystem.setVisible(true);
        }
    }//GEN-LAST:event_btnBackActionPerformed
    @Override
    public void dispose() {
        if (employeeToMongo != null) {
            employeeToMongo.closeConnection();
        }
        super.dispose();
    }
    private void cmbAddEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAddEmployeeActionPerformed
    }//GEN-LAST:event_cmbAddEmployeeActionPerformed

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
            java.util.logging.Logger.getLogger(FrmGeneratePaymentRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGeneratePaymentRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGeneratePaymentRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGeneratePaymentRoles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmAllEmployee frmAllEmployee=new FrmAllEmployee();
                FrmGeneratePaymentRoles frmGeneratePaymentRoles = new FrmGeneratePaymentRoles(frmAllEmployee);
                frmAllEmployee.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnGenerateIndividually;
    private javax.swing.JButton btnGeneratePayroll;
    private javax.swing.JComboBox<String> cmbAddEmployee;
    private com.toedter.calendar.JMonthChooser cmbMonth;
    private com.toedter.calendar.JYearChooser cmbYears;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAllEmployee;
    private javax.swing.JLabel txtIniciarSesion;
    // End of variables declaration//GEN-END:variables
}
