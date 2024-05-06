package project.quintocrud;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author emi
 */
public class jfrmEstudiante extends javax.swing.JFrame {

    /**
     * Creates new form jfrmEstudiante
     */
    private StudentApiConsumer apiConsumer;
    private final String[] columnas = {"Cedula","Nombre","Apellido","Direccion","Telefono"};
    private DefaultTableModel modelTable ;
    public jfrmEstudiante() {
        initComponents();
        setLocationRelativeTo(null);
        this.apiConsumer =  new StudentApiConsumer();
        this.modelTable = new DefaultTableModel(columnas, 0);
        this.jtbEstudiantes.setModel(modelTable);
        cargarEstudinates();
        selectEstudiante();
    }
    
    private void selectEstudiante(){
        jtbEstudiantes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row= jtbEstudiantes.getSelectedRow();
                if(row != -1){
                    limpiarLabels();
                    limpiarLabels();
                    jtxCedula.setText(jtbEstudiantes.getValueAt(row, 0).toString());
                    jtxNombre.setText(jtbEstudiantes.getValueAt(row, 1).toString());
                    jtxApellido.setText(jtbEstudiantes.getValueAt(row, 2).toString());
                    jtxDireccion.setText(jtbEstudiantes.getValueAt(row, 3).toString());
                    jtxTelefono.setText(jtbEstudiantes.getValueAt(row, 4).toString());
                }
            }
        });
    }
    
    private void cargarEstudinates(){
        this.modelTable.setNumRows(0);
        apiConsumer.getAll().forEach(student -> {this.modelTable.addRow(new Object[]
                {student.getID(), student.getFirstName(), student.getLastName(), 
                student.getAddress(),student.getPhone()});
        });
    }
    
    private void nuevoEstudiante(){
        String cedula = jtxCedula.getText();
        String nombre= jtxNombre.getText();
        String apellido = jtxApellido.getText();
        String direccion = jtxDireccion.getText();
        String telefono = jtxCedula.getText();
        
        if(!validarCampos(cedula, nombre, apellido, direccion, telefono))return;
        Student student= new Student (cedula, nombre, apellido, direccion, telefono);
        if(apiConsumer.create(student)){
            JOptionPane.showMessageDialog(rootPane, "Estudiante creado");
            cargarEstudinates();
            limpiarCampos();
        }
    }
    
    private boolean validarCampos(String... campos){
        limpiarLabels();
        String [] mensajesError = {"Cedula requerida", "Nombre requerido",
                                    "Apellido requerido", "Direccion reuqerida", "Telefono reuqerido"}; 
        boolean isValid= true;
        JLabel[] labels =  {jlbAlert1,jlbAlert2, jlbAlert3, jlbAlert4, jlbAlert5 };
        
        for (int i=0; i<campos.length; i++) {
            if(campos[i].isEmpty() || campos[i].isBlank()){
                labels[i].setText(mensajesError[i]);
                labels[i].setForeground(Color.red);
                isValid= false;
            }   
        }
        return isValid;
        
    }
    
    private void eliminarEstudiante(){
        int row = jtbEstudiantes.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un estudiante");
            return;
        }
        String cedula = jtbEstudiantes.getValueAt(row, 0).toString();
        if (apiConsumer.delete(cedula)) {
            JOptionPane.showMessageDialog(rootPane, "Se ha eliminado el estudiante");
            cargarEstudinates();
        } 
    }
    
    public void editarEstudiante(){
        String cedula = jtxCedula.getText();
        String nombre= jtxNombre.getText();
        String apellido = jtxApellido.getText();
        String direccion = jtxDireccion.getText();
        String telefono = jtxCedula.getText();
        if(!validarCampos(cedula, nombre, apellido, direccion, telefono))return;
        Student student = new Student(cedula, nombre, apellido, direccion, telefono);
        if (apiConsumer.update(student)) {
            JOptionPane.showMessageDialog(rootPane, "Estudiante actualizado");
            cargarEstudinates();
            limpiarCampos();
            limpiarLabels();
        }
    }
    
    private void limpiarCampos(){
        jtxCedula.setText("");
        jtxNombre.setText("");
        jtxApellido.setText("");
        jtxDireccion.setText("");
        jtxTelefono.setText("");
    }
    
    private void limpiarLabels(){
        jlbAlert1.setText("");
        jlbAlert2.setText("");
        jlbAlert3.setText("");
        jlbAlert4.setText("");
        jlbAlert5.setText("");
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxCedula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxNombre = new javax.swing.JTextField();
        jlbAlert1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxApellido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtxDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtxTelefono = new javax.swing.JTextField();
        jbtNuevo = new javax.swing.JButton();
        jbtEditar = new javax.swing.JButton();
        jbtEliminar = new javax.swing.JButton();
        jbtLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbEstudiantes = new javax.swing.JTable();
        jlbAlert2 = new javax.swing.JLabel();
        jlbAlert3 = new javax.swing.JLabel();
        jlbAlert4 = new javax.swing.JLabel();
        jlbAlert5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FORMULARIO ESTUDIANTES");

        jLabel2.setText("Cedula");

        jtxCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxCedulaActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre");

        jLabel5.setText("Apellidos");

        jLabel6.setText("Dirección");

        jLabel7.setText("Telefono");

        jbtNuevo.setBackground(new java.awt.Color(0, 204, 51));
        jbtNuevo.setForeground(new java.awt.Color(255, 255, 255));
        jbtNuevo.setText("Nuevo");
        jbtNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtNuevoActionPerformed(evt);
            }
        });

        jbtEditar.setBackground(new java.awt.Color(51, 51, 255));
        jbtEditar.setForeground(new java.awt.Color(255, 255, 255));
        jbtEditar.setText("Editar");
        jbtEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEditarActionPerformed(evt);
            }
        });

        jbtEliminar.setBackground(new java.awt.Color(255, 0, 0));
        jbtEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jbtEliminar.setText("Eliminar");
        jbtEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEliminarActionPerformed(evt);
            }
        });

        jbtLimpiar.setBackground(new java.awt.Color(255, 204, 51));
        jbtLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        jbtLimpiar.setText("Limpiar");
        jbtLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtLimpiarActionPerformed(evt);
            }
        });

        jtbEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cedula", "Nombre", "Apellido", "Direccion", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtbEstudiantes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbAlert1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jtxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jlbAlert2, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jlbAlert3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jtxApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlbAlert4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtxTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtxDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 6, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jlbAlert5, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jbtNuevo)
                        .addGap(35, 35, 35)
                        .addComponent(jbtEditar)
                        .addGap(31, 31, 31)
                        .addComponent(jbtEliminar)
                        .addGap(38, 38, 38)
                        .addComponent(jbtLimpiar)))
                .addGap(76, 76, 76))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbAlert1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbAlert2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(5, 5, 5)
                .addComponent(jlbAlert3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtxDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jlbAlert4, javax.swing.GroupLayout.DEFAULT_SIZE, 7, Short.MAX_VALUE)
                        .addGap(36, 36, 36))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jtxTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(jlbAlert5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtNuevo)
                    .addComponent(jbtEditar)
                    .addComponent(jbtEliminar)
                    .addComponent(jbtLimpiar))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxCedulaActionPerformed

    private void jbtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEditarActionPerformed
        // TODO add your handling code here:
        editarEstudiante();
        
    }//GEN-LAST:event_jbtEditarActionPerformed

    private void jbtNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNuevoActionPerformed
        // TODO add your handling code here:
        nuevoEstudiante();
        
    }//GEN-LAST:event_jbtNuevoActionPerformed

    private void jbtLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
    }//GEN-LAST:event_jbtLimpiarActionPerformed

    private void jbtEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEliminarActionPerformed
        // TODO add your handling code here:
        eliminarEstudiante();
    }//GEN-LAST:event_jbtEliminarActionPerformed

    
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
            java.util.logging.Logger.getLogger(jfrmEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrmEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrmEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrmEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrmEstudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtEditar;
    private javax.swing.JButton jbtEliminar;
    private javax.swing.JButton jbtLimpiar;
    private javax.swing.JButton jbtNuevo;
    private javax.swing.JLabel jlbAlert1;
    private javax.swing.JLabel jlbAlert2;
    private javax.swing.JLabel jlbAlert3;
    private javax.swing.JLabel jlbAlert4;
    private javax.swing.JLabel jlbAlert5;
    private javax.swing.JTable jtbEstudiantes;
    private javax.swing.JTextField jtxApellido;
    private javax.swing.JTextField jtxCedula;
    private javax.swing.JTextField jtxDireccion;
    private javax.swing.JTextField jtxNombre;
    private javax.swing.JTextField jtxTelefono;
    // End of variables declaration//GEN-END:variables
}
