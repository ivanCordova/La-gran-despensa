//JFrame Login
package Frames;

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

    public Login() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Elements/Logo_x32.png")).getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PContenido = new javax.swing.JPanel();
        btnMinimize = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tfUser = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        tfPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INICIA SESIÖN");
        setMaximumSize(new java.awt.Dimension(450, 575));
        setMinimumSize(new java.awt.Dimension(450, 575));
        setUndecorated(true);
        setResizable(false);

        PContenido.setBackground(new java.awt.Color(255, 255, 255));
        PContenido.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PContenidoMouseDragged(evt);
            }
        });
        PContenido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PContenidoMousePressed(evt);
            }
        });
        PContenido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        PContenido.add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 30, 30));

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
        PContenido.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 30, 30));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setText("Contraseña:");
        PContenido.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/Logo.png"))); // NOI18N
        PContenido.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/Password_x40N.png"))); // NOI18N
        PContenido.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel4.setText("Usuario:");
        PContenido.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/User_x40N.png"))); // NOI18N
        PContenido.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));
        PContenido.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 310, 10));

        tfUser.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tfUser.setText("EmmanuelMiranda");
        tfUser.setBorder(null);
        tfUser.setOpaque(false);
        PContenido.add(tfUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 260, 40));
        PContenido.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 310, 10));

        tfPassword.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tfPassword.setText("12345");
        tfPassword.setBorder(null);
        tfPassword.setOpaque(false);
        PContenido.add(tfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 260, 40));

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/BtnInput1.png"))); // NOI18N
        btnLogin.setBorder(null);
        btnLogin.setBorderPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setFocusPainted(false);
        btnLogin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/BtnInput2.png"))); // NOI18N
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });
        PContenido.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 260, 40));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/BackgroundLogin.jpg"))); // NOI18N
        PContenido.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PContenido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void PContenidoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PContenidoMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - moveX, y - moveY);
    }//GEN-LAST:event_PContenidoMouseDragged

    private void PContenidoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PContenidoMousePressed
        moveX = evt.getX();
        moveY = evt.getY();
    }//GEN-LAST:event_PContenidoMousePressed

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        if (String.valueOf(tfUser.getText()).compareTo("") == 0 && String.valueOf(tfPassword.getPassword()).compareTo("") == 0) {
            sound.warning();
            JOptionPane.showMessageDialog(this, "INGRESE SU USUARIO Y CONTRASEÑA", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            if (String.valueOf(tfUser.getText()).compareTo(tfUser.getText()) == 0 && String.valueOf(tfPassword.getPassword()).compareTo("") == 0) {
                sound.warning();
                JOptionPane.showMessageDialog(this, "POR FAVOR INGRESE SU CONTRASEÑA", "WARNING", JOptionPane.WARNING_MESSAGE);
            } else {
                if (String.valueOf(tfUser.getText()).compareTo("") == 0 && String.valueOf(tfPassword.getPassword()).compareTo(tfPassword.getText()) == 0) {
                    sound.warning();
                    JOptionPane.showMessageDialog(this, "POR FAVOR INGRESE SU USUARIO", "WARNING", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (String.valueOf(tfUser.getText()).compareTo("G0000001") == 0 && String.valueOf(tfPassword.getPassword()).compareTo("gerente") == 0) {
                        Connections.Connectionn.enter("ivan", "ivan");
                        Connections.Connectionn.getConnection();
                        if (Connections.Connectionn.status()) {
                            this.dispose();
                            sound.login();
                            proveedores.setVisible(true);
                        }
                    }
                    if (String.valueOf(tfUser.getText()).compareTo("C0000001") == 0 && String.valueOf(tfPassword.getPassword()).compareTo("cajero") == 0) {
                        Connections.Connectionn.enter("ivan", "ivan");
                        Connections.Connectionn.getConnection();
                        if (Connections.Connectionn.status()) {
                            this.dispose();
                            sound.login();
                            ventas.setVisible(true);
                        }
                    }
                     if (String.valueOf(tfUser.getText()).compareTo("A0000001") == 0 && String.valueOf(tfPassword.getPassword()).compareTo("admin") == 0) {
                         Connections.Connectionn.enter("sa", "123");
                        Connections.Connectionn.getConnection();
                        if (Connections.Connectionn.status()) {
                            this.dispose();
                            sound.login();
                            usuarios.setVisible(true);
                        }
                    }

                }
            }
        }
    }//GEN-LAST:event_btnLoginMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JPanel PContenido;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables
}
