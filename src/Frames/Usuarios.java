//JFrame Users
package Frames;

import Connections.Procedure;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Usuarios extends javax.swing.JFrame {
    //OBJECTS

    Methods.General general = new Methods.General();
    Methods.Sound sound = new Methods.Sound();
//EDITADO PRUEBA CHEMA
    //VARIABLES
    int moveX, moveY;
    static ResultSet res;
    int cont;

    public Usuarios() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PHome = new javax.swing.JPanel();
        PAcciones = new javax.swing.JPanel();
        btnRefresh = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnFotografia = new javax.swing.JButton();
        PDatos = new javax.swing.JPanel();
        lbTelefono = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbAP = new javax.swing.JLabel();
        lbAM = new javax.swing.JLabel();
        lbDireccion = new javax.swing.JLabel();
        lbId = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        cbIdRol = new javax.swing.JComboBox<>();
        tfAM = new javax.swing.JTextField();
        tfNombre = new javax.swing.JTextField();
        tfId = new javax.swing.JTextField();
        tfTelefono = new javax.swing.JTextField();
        tfAP = new javax.swing.JTextField();
        tfDireccion = new javax.swing.JTextField();
        lbTelefono1 = new javax.swing.JLabel();
        tfContraseña = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        tfFoto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tUsuarios = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        lbTitulo = new javax.swing.JLabel();
        lbTitulo1 = new javax.swing.JLabel();
        lbTitulo2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnGuie = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 700, 700));
        setMaximumSize(new java.awt.Dimension(700, 700));
        setMinimumSize(new java.awt.Dimension(700, 700));
        setUndecorated(true);
        setResizable(false);

        PHome.setBackground(new java.awt.Color(255, 255, 255));
        PHome.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PHomeMouseDragged(evt);
            }
        });
        PHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PHomeMousePressed(evt);
            }
        });
        PHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PAcciones.setBackground(new java.awt.Color(255, 255, 255));
        PAcciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ACCIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        PAcciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/BtnUpdate1.png"))); // NOI18N
        btnRefresh.setBorder(null);
        btnRefresh.setBorderPainted(false);
        btnRefresh.setContentAreaFilled(false);
        btnRefresh.setFocusPainted(false);
        btnRefresh.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/BtnUpdate2.png"))); // NOI18N
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefreshMouseClicked(evt);
            }
        });
        PAcciones.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 150, 30));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/Add_x32A.png"))); // NOI18N
        btnAdd.setBorder(null);
        btnAdd.setBorderPainted(false);
        btnAdd.setContentAreaFilled(false);
        btnAdd.setFocusPainted(false);
        btnAdd.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/Add_x32N.png"))); // NOI18N
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        PAcciones.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/Delete_x32A.png"))); // NOI18N
        btnDelete.setBorder(null);
        btnDelete.setBorderPainted(false);
        btnDelete.setContentAreaFilled(false);
        btnDelete.setFocusPainted(false);
        btnDelete.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/Delete_x32N.png"))); // NOI18N
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        PAcciones.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/Edit_x32A.png"))); // NOI18N
        btnEdit.setBorder(null);
        btnEdit.setBorderPainted(false);
        btnEdit.setContentAreaFilled(false);
        btnEdit.setFocusPainted(false);
        btnEdit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/Edit_x32N.png"))); // NOI18N
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });
        PAcciones.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/Save_x32A.png"))); // NOI18N
        btnSave.setBorder(null);
        btnSave.setBorderPainted(false);
        btnSave.setContentAreaFilled(false);
        btnSave.setFocusPainted(false);
        btnSave.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/Save_x32N.png"))); // NOI18N
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });
        PAcciones.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/Search_x32A.png"))); // NOI18N
        btnSearch.setBorder(null);
        btnSearch.setBorderPainted(false);
        btnSearch.setContentAreaFilled(false);
        btnSearch.setFocusPainted(false);
        btnSearch.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/Search_x32N.png"))); // NOI18N
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        PAcciones.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        btnFotografia.setBackground(new java.awt.Color(255, 255, 255));
        btnFotografia.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnFotografia.setForeground(new java.awt.Color(255, 255, 255));
        btnFotografia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/btnFotografia1.jpg"))); // NOI18N
        btnFotografia.setBorder(null);
        btnFotografia.setBorderPainted(false);
        btnFotografia.setContentAreaFilled(false);
        btnFotografia.setEnabled(false);
        btnFotografia.setFocusPainted(false);
        btnFotografia.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/btnFotografia2.jpg"))); // NOI18N
        PAcciones.add(btnFotografia, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 150, 30));

        PHome.add(PAcciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 640, 70));

        PDatos.setBackground(new java.awt.Color(255, 255, 255));
        PDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DEL USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        PDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTelefono.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lbTelefono.setText("Contraseña:");
        PDatos.add(lbTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        lbNombre.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lbNombre.setText("Nombre:");
        PDatos.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        lbAP.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lbAP.setText("ApellidoP:");
        PDatos.add(lbAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        lbAM.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lbAM.setText("ApellidoM:");
        PDatos.add(lbAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        lbDireccion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lbDireccion.setText("Dirección:");
        PDatos.add(lbDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        lbId.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lbId.setText("ID:");
        PDatos.add(lbId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        cbSexo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        cbSexo.setBorder(null);
        cbSexo.setOpaque(false);
        PDatos.add(cbSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 70, 20));
        PDatos.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 160, 10));
        PDatos.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 70, 10));
        PDatos.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 180, 10));
        PDatos.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 80, 10));
        PDatos.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 150, 10));
        PDatos.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 390, 10));

        cbIdRol.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cbIdRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Gerente", "Cajero" }));
        cbIdRol.setBorder(null);
        cbIdRol.setOpaque(false);
        PDatos.add(cbIdRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, 20));

        tfAM.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tfAM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfAM.setText("Diaz");
        tfAM.setBorder(null);
        PDatos.add(tfAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 160, -1));

        tfNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tfNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfNombre.setText("Emmanuel");
        tfNombre.setBorder(null);
        PDatos.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 180, -1));

        tfId.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tfId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfId.setText("12345678");
        tfId.setBorder(null);
        PDatos.add(tfId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 70, -1));

        tfTelefono.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tfTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfTelefono.setText("2321164170");
        tfTelefono.setBorder(null);
        PDatos.add(tfTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 80, -1));

        tfAP.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tfAP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfAP.setText("Miranda");
        tfAP.setBorder(null);
        PDatos.add(tfAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 150, -1));

        tfDireccion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tfDireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfDireccion.setText("Col. San Vicente, Mtz de la Torre, Veracruz");
        tfDireccion.setBorder(null);
        PDatos.add(tfDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 390, -1));

        lbTelefono1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lbTelefono1.setText("Telefono:");
        PDatos.add(lbTelefono1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        tfContraseña.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tfContraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfContraseña.setText("12345");
        tfContraseña.setBorder(null);
        PDatos.add(tfContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 140, -1));
        PDatos.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 140, 10));
        PDatos.add(tfFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 140, 130));

        PHome.add(PDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 640, 160));

        tUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "ID_ROL", "NOMBRE", "APELLIDOP", "APELLIDOM", "DIRECCION", "TELEFONO", "SEXO", "CONTRASEÑA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tUsuarios);

        PHome.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 640, 260));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/Close_x32N.png"))); // NOI18N
        btnClose.setBorder(null);
        btnClose.setBorderPainted(false);
        btnClose.setContentAreaFilled(false);
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.setFocusPainted(false);
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        PHome.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 30, 30));

        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/Minimize_x32N.png"))); // NOI18N
        btnMinimize.setBorder(null);
        btnMinimize.setBorderPainted(false);
        btnMinimize.setContentAreaFilled(false);
        btnMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimize.setFocusPainted(false);
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
        });
        PHome.add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 30, 30));

        lbTitulo.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("USUARIOS");
        PHome.add(lbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 650, -1));

        lbTitulo1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo1.setText("NOMBRE:");
        PHome.add(lbTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 650, -1));

        lbTitulo2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbTitulo2.setForeground(new java.awt.Color(255, 255, 255));
        lbTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo2.setText("LISTA DE USUARIOS REGISTRADOS");
        PHome.add(lbTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 650, -1));
        PHome.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 290, 10));

        btnGuie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/Manual_x32A.png"))); // NOI18N
        btnGuie.setBorder(null);
        btnGuie.setBorderPainted(false);
        btnGuie.setContentAreaFilled(false);
        btnGuie.setFocusPainted(false);
        btnGuie.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/Manual_x32N.png"))); // NOI18N
        PHome.add(btnGuie, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, -1, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/BackgroundUsers.jpg"))); // NOI18N
        PHome.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        general.close();
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        sound.minimize();
        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void PHomeMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PHomeMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - moveX, y - moveY);
    }//GEN-LAST:event_PHomeMouseDragged

    private void PHomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PHomeMousePressed
        moveX = evt.getX();
        moveY = evt.getY();
    }//GEN-LAST:event_PHomeMousePressed

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        if (tfId.getText().isEmpty() || cbIdRol.getSelectedItem() == "" || tfNombre.getText().isEmpty() || tfAP.getText().isEmpty() || tfAM.getText().isEmpty()
                || tfDireccion.getText().isEmpty() || tfTelefono.getText().isEmpty() || cbSexo.getSelectedItem() == "" || tfContraseña.getText().isEmpty()) {
            sound.warning();
            JOptionPane.showMessageDialog(this, "INSERTA LOS DATOS CORRECTAMENTE", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                res = Connections.Connectionn.consultation("Select COUNT(id_usuario)from Usuarios where id_usuario='" + tfId.getText() + "'");
                try {
                    while (res.next()) {
                        cont = res.getInt(1);
                    }
                } catch (SQLException e) {
                }
                if (cont >= 1) {
                    sound.error();
                    JOptionPane.showMessageDialog(this, "USUARIO EXISTENTE", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    String x = cbIdRol.getSelectedItem().toString();
                    if (x == "Gerente") {
                        x = "G0000001";
                    }
                    if (x == "Cajero") {
                        x = "C0000001";
                    }
                    if (x == "Administrador") {
                        x = "A0000001";
                    }
                    Procedure.entradaUsuarios(Integer.parseInt(tfId.getText()), x, tfNombre.getText(), tfAP.getText(), tfAM.getText(), tfDireccion.getText(), tfTelefono.getText(), cbSexo.getSelectedItem().toString(), tfContraseña.getText());
                    general.clear(tfId, cbIdRol, tfNombre, tfAP, tfAM, tfDireccion, tfTelefono, cbSexo, tfContraseña);
                    sound.executed();
                    JOptionPane.showMessageDialog(this, "USUARIO CREADO", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    refresh();
                }
            } catch (SQLException e) {
            }
        }
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        int row1 = tUsuarios.getSelectedRow();
        if (row1 == -1) {
            sound.warning();
            JOptionPane.showMessageDialog(null, "SELECCIONE UN REGISTRO", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            int row = tUsuarios.getSelectedRow();
            sound.warning();
            int opc = JOptionPane.showConfirmDialog(this, "¿DESEA ELIMINAR EL USUARIO?", "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opc == JOptionPane.YES_OPTION) {
                try {
                    sound.executed();
                    Procedure.EliminarUsuarios(Integer.parseInt(tUsuarios.getValueAt(row, 0).toString()));
                    refresh();
                } catch (SQLException e) {
                }
            }
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        sound.clic();
        tfId.setEnabled(true);
        cbIdRol.setEnabled(true);
        tfNombre.setEnabled(true);
        tfAP.setEnabled(true);
        tfAM.setEnabled(true);
        tfDireccion.setEnabled(true);
        tfTelefono.setEnabled(true);
        cbSexo.setEnabled(true);
        tfContraseña.setEnabled(true);
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        if (tfId.getText().isEmpty() || cbIdRol.getSelectedItem() == "" || tfNombre.getText().isEmpty() || tfAP.getText().isEmpty() || tfAM.getText().isEmpty()
                || tfDireccion.getText().isEmpty() || tfTelefono.getText().isEmpty() || cbSexo.getSelectedItem() == "" || tfContraseña.getText().isEmpty()) {
            sound.warning();
            JOptionPane.showMessageDialog(this, "CAMPOS VACIOS", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                String x = cbIdRol.getSelectedItem().toString();
                if (x == "Gerente") {
                    x = "G0000001";
                }
                if (x == "Cajero") {
                    x = "C0000001";
                }
                if (x == "Administrador") {
                    x = "A0000001";
                }
                PreparedStatement pss = Connections.Connectionn.getConnection().prepareStatement("update Usuarios set id_rol='" + x
                        + "', nombre='" + tfNombre.getText() + "', ape_paterno='" + tfAP.getText() + "', ape_materno='" + tfAM.getText()
                        + "', direccion='" + tfDireccion.getText() + "', telefono='" + tfTelefono.getText() + "', contraseña='" + tfContraseña.getText()
                        + "' where id_usuario='" + tfId.getText() + "'");
                pss.executeUpdate();
                sound.executed();
                JOptionPane.showMessageDialog(this, "DATOS MODIFICADOS", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                general.clear(tfId, cbIdRol, tfNombre, tfAP, tfAM, tfDireccion, tfTelefono, cbSexo, tfContraseña);
                refresh();
            } catch (SQLException e) {
            }
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        if (tfId.getText().isEmpty()) {
            sound.warning();
            JOptionPane.showMessageDialog(this, "INSERTA ID", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                String b;
                Procedure.BuscarUsuarios(Integer.parseInt(tfId.getText()));
                b = tfId.getText();
                general.clear(tfId, cbIdRol, tfNombre, tfAP, tfAM, tfDireccion, tfTelefono, cbSexo, tfContraseña);
                res = Connections.Connectionn.consultation("select * from Usuarios");
                while (res.next()) {
                    if (res.getString(1).equals(b)) {
                        sound.executed();
                        JOptionPane.showMessageDialog(this, "DATOS ENCONTRADOS", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                        tfId.setText(res.getString(1));
                        String x = res.getString(2);
                        if (x == "G0000001") {
                            cbIdRol.setSelectedItem("Gerente");
                        }
                        if (x == "C0000001") {
                            cbIdRol.setSelectedItem("Cajero");
                        }
                        if (x == "A0000001") {
                            cbIdRol.setSelectedItem("Administrador");
                        }
                        tfNombre.setText(res.getString(3));
                        tfAP.setText(res.getString(4));
                        tfAM.setText(res.getString(5));
                        tfDireccion.setText(res.getString(6));
                        tfTelefono.setText(res.getString(7));
                        cbSexo.setSelectedItem(res.getString(8));
                        tfContraseña.setText(res.getString(9));
                    }
                }
                JOptionPane.showMessageDialog(this, "DATOS NO ENCONTRADOS", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
            }
        }
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseClicked
        refresh();
        sound.clic();
        tfId.setEnabled(false);
        cbIdRol.setEnabled(false);
        tfNombre.setEnabled(false);
        tfAP.setEnabled(false);
        tfAM.setEnabled(false);
        tfDireccion.setEnabled(false);
        tfTelefono.setEnabled(false);
        cbSexo.setEnabled(false);
        tfContraseña.setEnabled(false);
        general.clear(tfId, cbIdRol, tfNombre, tfAP, tfAM, tfDireccion, tfTelefono, cbSexo, tfContraseña);
    }//GEN-LAST:event_btnRefreshMouseClicked

    public void refresh() {
        DefaultTableModel model = (DefaultTableModel) tUsuarios.getModel();
        model.setRowCount(0);
        res = Connections.Connectionn.consultation("select * from Usuarios");
        try {
            while (res.next()) {
                Vector v = new Vector();
                v.add(res.getInt(1));
                v.add(res.getString(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                v.add(res.getString(5));
                v.add(res.getString(6));
                v.add(res.getString(7));
                v.add(res.getString(8));
                v.add(res.getString(9));
                model.addRow(v);
                tUsuarios.setModel(model);
            }
        } catch (SQLException e) {
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JPanel PAcciones;
    private javax.swing.JPanel PDatos;
    private javax.swing.JPanel PHome;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFotografia;
    private javax.swing.JButton btnGuie;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbIdRol;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lbAM;
    private javax.swing.JLabel lbAP;
    private javax.swing.JLabel lbDireccion;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JLabel lbTelefono1;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbTitulo1;
    private javax.swing.JLabel lbTitulo2;
    private javax.swing.JTable tUsuarios;
    private javax.swing.JTextField tfAM;
    private javax.swing.JTextField tfAP;
    private javax.swing.JTextField tfContraseña;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfFoto;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfTelefono;
    // End of variables declaration//GEN-END:variables
}
