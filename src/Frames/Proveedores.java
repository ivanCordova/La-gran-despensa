/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Connections.Procedure;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Miran
 */
public class Proveedores extends javax.swing.JFrame {

    /**
     * Creates new form Proveedores
     */
    public Proveedores() {
        initComponents();
    }
    int moveX, moveY;
    static ResultSet res;
    int cont;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PHome = new javax.swing.JPanel();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        PDatos = new javax.swing.JPanel();
        lbNombre = new javax.swing.JLabel();
        lbDireccion = new javax.swing.JLabel();
        lbId = new javax.swing.JLabel();
        lbTelefono1 = new javax.swing.JLabel();
        lbDireccion1 = new javax.swing.JLabel();
        lbTelefono2 = new javax.swing.JLabel();
        Direccion_Alta = new javax.swing.JTextField();
        Id_alta = new javax.swing.JTextField();
        Name_alta = new javax.swing.JTextField();
        Empresa_alta = new javax.swing.JTextField();
        Telefono_Alta = new javax.swing.JTextField();
        Fcha_Alta = new javax.swing.JTextField();
        jButtonAlta = new javax.swing.JButton();
        PDatos1 = new javax.swing.JPanel();
        lbId1 = new javax.swing.JLabel();
        BuscarBaja = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableBajas = new javax.swing.JTable();
        jButtonBuscarBaja = new javax.swing.JButton();
        jButtonDardeBaja = new javax.swing.JButton();
        PDatos3 = new javax.swing.JPanel();
        jButton_Inicio = new javax.swing.JButton();
        Id_ConsultaBuscar = new javax.swing.JTextField();
        lbId5 = new javax.swing.JLabel();
        BuscarProvee = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableConsulta = new javax.swing.JTable();
        PDatos2 = new javax.swing.JPanel();
        lbNombre2 = new javax.swing.JLabel();
        lbDireccion4 = new javax.swing.JLabel();
        lbId2 = new javax.swing.JLabel();
        lbTelefono5 = new javax.swing.JLabel();
        lbDireccion5 = new javax.swing.JLabel();
        lbTelefono6 = new javax.swing.JLabel();
        Direccion_Modificar = new javax.swing.JTextField();
        ID_modificar = new javax.swing.JTextField();
        Nombre_Modificar = new javax.swing.JTextField();
        Empresa_Modificar = new javax.swing.JTextField();
        Telefono_Modificar = new javax.swing.JTextField();
        Fecha_Modificar = new javax.swing.JTextField();
        jButton_Modificar = new javax.swing.JButton();
        Buscar_Modificar = new javax.swing.JTextField();
        lbId3 = new javax.swing.JLabel();
        jButtonB_Modificar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableModificar = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PHome.setBackground(new java.awt.Color(255, 255, 255));

        PDatos.setBackground(new java.awt.Color(255, 255, 255));
        PDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DEL USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        PDatos.setForeground(new java.awt.Color(0, 0, 0));
        PDatos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        PDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbNombre.setBackground(new java.awt.Color(0, 0, 0));
        lbNombre.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbNombre.setForeground(new java.awt.Color(0, 0, 0));
        lbNombre.setText("Nombre:");
        PDatos.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        lbDireccion.setBackground(new java.awt.Color(0, 0, 0));
        lbDireccion.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbDireccion.setForeground(new java.awt.Color(0, 0, 0));
        lbDireccion.setText("Fecha de Registro:");
        PDatos.add(lbDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        lbId.setBackground(new java.awt.Color(0, 0, 0));
        lbId.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbId.setForeground(new java.awt.Color(0, 0, 0));
        lbId.setText("ID:");
        PDatos.add(lbId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        lbTelefono1.setBackground(new java.awt.Color(0, 0, 0));
        lbTelefono1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbTelefono1.setForeground(new java.awt.Color(0, 0, 0));
        lbTelefono1.setText("Empresa:");
        lbTelefono1.setToolTipText("");
        PDatos.add(lbTelefono1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        lbDireccion1.setBackground(new java.awt.Color(0, 0, 0));
        lbDireccion1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbDireccion1.setForeground(new java.awt.Color(0, 0, 0));
        lbDireccion1.setText("Dirección:");
        PDatos.add(lbDireccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));

        lbTelefono2.setBackground(new java.awt.Color(0, 0, 0));
        lbTelefono2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbTelefono2.setForeground(new java.awt.Color(0, 0, 0));
        lbTelefono2.setText("Telefono:");
        PDatos.add(lbTelefono2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));
        PDatos.add(Direccion_Alta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 250, -1));
        PDatos.add(Id_alta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 250, -1));
        PDatos.add(Name_alta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 250, -1));
        PDatos.add(Empresa_alta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 250, -1));
        PDatos.add(Telefono_Alta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 250, -1));
        PDatos.add(Fcha_Alta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 250, -1));

        jButtonAlta.setText("DAR DE ALTA");
        jButtonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAltaActionPerformed(evt);
            }
        });
        PDatos.add(jButtonAlta, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, -1, -1));

        jTabbedPane7.addTab("ALTA", PDatos);

        PDatos1.setBackground(new java.awt.Color(255, 255, 255));
        PDatos1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DEL USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        PDatos1.setForeground(new java.awt.Color(0, 0, 0));
        PDatos1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        PDatos1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbId1.setBackground(new java.awt.Color(0, 0, 0));
        lbId1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbId1.setForeground(new java.awt.Color(0, 0, 0));
        lbId1.setText("ID:");
        PDatos1.add(lbId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));
        PDatos1.add(BuscarBaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 250, -1));

        jTableBajas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID PROVEEDOR", "NOMBRE", "EMPRESA", "TELEFONO", "FECHA REGISTRO", "DIRECCION"
            }
        ));
        jScrollPane2.setViewportView(jTableBajas);

        PDatos1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 570, 260));

        jButtonBuscarBaja.setText("BUSCAR");
        jButtonBuscarBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarBajaActionPerformed(evt);
            }
        });
        PDatos1.add(jButtonBuscarBaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));

        jButtonDardeBaja.setText("ELIMINAR");
        jButtonDardeBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDardeBajaActionPerformed(evt);
            }
        });
        PDatos1.add(jButtonDardeBaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, -1, -1));

        jTabbedPane7.addTab("BAJA", PDatos1);

        PDatos3.setBackground(new java.awt.Color(255, 255, 255));
        PDatos3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DEL USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        PDatos3.setForeground(new java.awt.Color(0, 0, 0));
        PDatos3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        PDatos3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_Inicio.setText("INICIO");
        PDatos3.add(jButton_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, -1, -1));
        PDatos3.add(Id_ConsultaBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 250, -1));

        lbId5.setBackground(new java.awt.Color(0, 0, 0));
        lbId5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbId5.setForeground(new java.awt.Color(0, 0, 0));
        lbId5.setText("ID:");
        PDatos3.add(lbId5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        BuscarProvee.setText("BUSCAR");
        PDatos3.add(BuscarProvee, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, -1, -1));

        jTableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID PROVEEDOR", "NOMBRE", "EMPRESA", "TELEFONO", "FECHA REGISTRO", "DIRECCION"
            }
        ));
        jScrollPane5.setViewportView(jTableConsulta);

        PDatos3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 570, 130));

        jTabbedPane7.addTab("CONSULTAR", PDatos3);

        PDatos2.setBackground(new java.awt.Color(255, 255, 255));
        PDatos2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DEL USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        PDatos2.setForeground(new java.awt.Color(0, 0, 0));
        PDatos2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        PDatos2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbNombre2.setBackground(new java.awt.Color(0, 0, 0));
        lbNombre2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbNombre2.setForeground(new java.awt.Color(0, 0, 0));
        lbNombre2.setText("Nombre:");
        PDatos2.add(lbNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, -1));

        lbDireccion4.setBackground(new java.awt.Color(0, 0, 0));
        lbDireccion4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbDireccion4.setForeground(new java.awt.Color(0, 0, 0));
        lbDireccion4.setText("Fecha de Registro:");
        PDatos2.add(lbDireccion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        lbId2.setBackground(new java.awt.Color(0, 0, 0));
        lbId2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbId2.setForeground(new java.awt.Color(0, 0, 0));
        lbId2.setText("ID:");
        PDatos2.add(lbId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, -1, -1));

        lbTelefono5.setBackground(new java.awt.Color(0, 0, 0));
        lbTelefono5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbTelefono5.setForeground(new java.awt.Color(0, 0, 0));
        lbTelefono5.setText("Empresa:");
        lbTelefono5.setToolTipText("");
        PDatos2.add(lbTelefono5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, -1));

        lbDireccion5.setBackground(new java.awt.Color(0, 0, 0));
        lbDireccion5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbDireccion5.setForeground(new java.awt.Color(0, 0, 0));
        lbDireccion5.setText("Dirección:");
        PDatos2.add(lbDireccion5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, -1, -1));

        lbTelefono6.setBackground(new java.awt.Color(0, 0, 0));
        lbTelefono6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbTelefono6.setForeground(new java.awt.Color(0, 0, 0));
        lbTelefono6.setText("Telefono:");
        PDatos2.add(lbTelefono6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, -1, -1));
        PDatos2.add(Direccion_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 250, -1));
        PDatos2.add(ID_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 250, -1));
        PDatos2.add(Nombre_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 250, -1));
        PDatos2.add(Empresa_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 250, -1));
        PDatos2.add(Telefono_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 250, -1));
        PDatos2.add(Fecha_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 250, -1));

        jButton_Modificar.setText("MODIFICAR");
        PDatos2.add(jButton_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, -1, -1));
        PDatos2.add(Buscar_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 250, -1));

        lbId3.setBackground(new java.awt.Color(0, 0, 0));
        lbId3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbId3.setForeground(new java.awt.Color(0, 0, 0));
        lbId3.setText("ID:");
        PDatos2.add(lbId3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jButtonB_Modificar.setText("BUSCAR");
        PDatos2.add(jButtonB_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

        jTableModificar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID PROVEEDOR", "NOMBRE", "EMPRESA", "TELEFONO", "FECHA REGISTRO", "DIRECCION"
            }
        ));
        jScrollPane4.setViewportView(jTableModificar);

        PDatos2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 570, 130));

        jTabbedPane7.addTab("MODIFICAR", PDatos2);

        javax.swing.GroupLayout PHomeLayout = new javax.swing.GroupLayout(PHome);
        PHome.setLayout(PHomeLayout);
        PHomeLayout.setHorizontalGroup(
            PHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PHomeLayout.setVerticalGroup(
            PHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PHomeLayout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(jTabbedPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAltaActionPerformed

        if (Id_alta.getText().isEmpty() || Name_alta.getText().isEmpty() || Direccion_Alta.getText().isEmpty()
                || Empresa_alta.getText().isEmpty() || Telefono_Alta.getText().isEmpty() || Fcha_Alta.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "INGRESE SUS DATOS CORRECTAMENTE", "INFORMACION!", JOptionPane.INFORMATION_MESSAGE);

            Id_alta.setText("");
            Name_alta.setText("");
            Direccion_Alta.setText("");
            Empresa_alta.setText("");
            Telefono_Alta.setText("");
            Fcha_Alta.setText("");

        } else {
            try {
                res = Connections.Connectionn.consultation("Select COUNT(id_proveedor)from Proveedores where id_Proveedor ='" + Id_alta.getText() + "'");
                try {
                    while (res.next()) {
                        cont = res.getInt(1);
                    }
                } catch (Exception e) {
                }
                if (cont >= 1) {
                    JOptionPane.showMessageDialog(this, "PROVEEDOR EXISTENTE", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    Procedure.AgregarProveedor(Integer.parseInt(Id_alta.getText()), Name_alta.getText(), Empresa_alta.getText(), Telefono_Alta.getText(),
                            Fcha_Alta.getText(), Direccion_Alta.getText());

                    Id_alta.setText("");
                    Name_alta.setText("");
                    Direccion_Alta.setText("");
                    Empresa_alta.setText("");
                    Telefono_Alta.setText("");
                    Fcha_Alta.setText("");

                    JOptionPane.showMessageDialog(this, "PROVEEDOR CREADO", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (Exception e) {
            }
    }//GEN-LAST:event_jButtonAltaActionPerformed
    }
    private void jButtonBuscarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarBajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBuscarBajaActionPerformed

    private void jButtonDardeBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDardeBajaActionPerformed
        int row1 = jTableBajas.getSelectedRow();
        if (row1 == -1) {

            JOptionPane.showMessageDialog(null, "SELECCIONE UN REGISTRO", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            int row = jTableBajas.getSelectedRow();

            int opc = JOptionPane.showConfirmDialog(this, "¿DESEA ELIMINAR EL PROVEEDOR?", "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opc == JOptionPane.YES_OPTION) {
                try {

                    Procedure.EliminarUsuarios(Integer.parseInt(jTableBajas.getValueAt(row, 0).toString()));

                } catch (SQLException e) {
                }
            }
        }
    }//GEN-LAST:event_jButtonDardeBajaActionPerformed

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
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BuscarBaja;
    private javax.swing.JButton BuscarProvee;
    private javax.swing.JTextField Buscar_Modificar;
    private javax.swing.JTextField Direccion_Alta;
    private javax.swing.JTextField Direccion_Modificar;
    private javax.swing.JTextField Empresa_Modificar;
    private javax.swing.JTextField Empresa_alta;
    private javax.swing.JTextField Fcha_Alta;
    private javax.swing.JTextField Fecha_Modificar;
    private javax.swing.JTextField ID_modificar;
    private javax.swing.JTextField Id_ConsultaBuscar;
    private javax.swing.JTextField Id_alta;
    private javax.swing.JTextField Name_alta;
    private javax.swing.JTextField Nombre_Modificar;
    private javax.swing.JPanel PDatos;
    private javax.swing.JPanel PDatos1;
    private javax.swing.JPanel PDatos2;
    private javax.swing.JPanel PDatos3;
    private javax.swing.JPanel PHome;
    private javax.swing.JTextField Telefono_Alta;
    private javax.swing.JTextField Telefono_Modificar;
    private javax.swing.JButton jButtonAlta;
    private javax.swing.JButton jButtonB_Modificar;
    private javax.swing.JButton jButtonBuscarBaja;
    private javax.swing.JButton jButtonDardeBaja;
    private javax.swing.JButton jButton_Inicio;
    private javax.swing.JButton jButton_Modificar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTable jTableBajas;
    private javax.swing.JTable jTableConsulta;
    private javax.swing.JTable jTableModificar;
    private javax.swing.JLabel lbDireccion;
    private javax.swing.JLabel lbDireccion1;
    private javax.swing.JLabel lbDireccion4;
    private javax.swing.JLabel lbDireccion5;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbId1;
    private javax.swing.JLabel lbId2;
    private javax.swing.JLabel lbId3;
    private javax.swing.JLabel lbId5;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbNombre2;
    private javax.swing.JLabel lbTelefono1;
    private javax.swing.JLabel lbTelefono2;
    private javax.swing.JLabel lbTelefono5;
    private javax.swing.JLabel lbTelefono6;
    // End of variables declaration//GEN-END:variables
}
