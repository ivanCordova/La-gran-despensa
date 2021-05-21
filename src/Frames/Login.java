package Frames;

import Connections.Connectionn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    //OBJECTS
    Methods.General general = new Methods.General();
    Methods.Sound sound = new Methods.Sound();
    Usuarios usuarios = new Usuarios();
    Proveedores proveedores = new Proveedores();
    Ventas ventas = new Ventas();
    //VARIABLES
    int moveX, moveY;
    public static String id = "";
    String pass = "";

    public Login() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Elements/Logo_x32.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMinimize = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        bgLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicia sesion");
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 350, 550));
        setMaximumSize(new java.awt.Dimension(350, 550));
        setMinimumSize(new java.awt.Dimension(350, 550));
        setName("Login"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(350, 550));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 30, 30));

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
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 30, 30));

        txtId.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtId.setForeground(new java.awt.Color(255, 255, 255));
        txtId.setBorder(null);
        txtId.setOpaque(false);
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 170, 40));

        txtPassword.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setBorder(null);
        txtPassword.setOpaque(false);
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 170, 40));

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/btnLogin1.jpg"))); // NOI18N
        btnLogin.setBorder(null);
        btnLogin.setBorderPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setFocusPainted(false);
        btnLogin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/btnLogin.png"))); // NOI18N
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 210, 40));

        bgLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/Login.jpg"))); // NOI18N
        bgLogin.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bgLoginMouseDragged(evt);
            }
        });
        bgLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bgLoginMousePressed(evt);
            }
        });
        getContentPane().add(bgLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 550));

        getAccessibleContext().setAccessibleName("");

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

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        id = txtId.getText().trim();
        pass = txtPassword.getText().trim();

        if (String.valueOf(txtId.getText()).compareTo("") == 0 && String.valueOf(txtPassword.getPassword()).compareTo("") == 0) {
            JOptionPane.showMessageDialog(this, "Ingrese su id y contraseña", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        } else {
            if (String.valueOf(txtId.getText()).compareTo(txtId.getText()) == 0 && String.valueOf(txtPassword.getPassword()).compareTo("") == 0) {
                JOptionPane.showMessageDialog(this, "Ingrese su contraseña", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            } else {
                if (String.valueOf(txtId.getText()).compareTo("") == 0 && String.valueOf(txtPassword.getPassword()).compareTo(txtPassword.getText()) == 0) {
                    JOptionPane.showMessageDialog(this, "Ingrese su id", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        Connection cn = Connectionn.getConnection();
                        PreparedStatement pst = cn.prepareStatement("select id_rol from Usuarios where id_usuario = '" + id
                                + "' and contrasena = '" + pass + "'");
                        ResultSet rs = pst.executeQuery();
                        if (rs.next()) {
//                          String id_rol = rs.getString("id_rol");
                            inicio n = new inicio(id);
                            this.setVisible(false);
                            n.setVisible(true);
//                            if (id_rol.equals("A0000001")) {
//                                dispose();
//                                new Usuarios().setVisible(true);
//                            } else if (id_rol.equals("G0000001")) {
//                                dispose();
//                                new Proveedores().setVisible(true);
//                            } else if (id_rol.equals("C0000001")) {
//                                dispose();
//                                new Ventas().setVisible(true);
//                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Datos de acceso incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
                            txtId.setText("");
                            txtPassword.setText("");
                        }
                    } catch (SQLException e) {
                        System.err.print("Error en el boton Ingresar" + e);
                        JOptionPane.showMessageDialog(this, "Contacte al administrador", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnLoginMouseClicked

    private void bgLoginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgLoginMousePressed
        moveX = evt.getX();
        moveY = evt.getY();
    }//GEN-LAST:event_bgLoginMousePressed

    private void bgLoginMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgLoginMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - moveX, y - moveY);
    }//GEN-LAST:event_bgLoginMouseDragged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        sound.input();
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgLogin;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JTextField txtId;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
