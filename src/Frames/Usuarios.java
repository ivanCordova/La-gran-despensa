//JFrame Users
package Frames;

import AppPackage.AnimationClass;
import Connections.Connectionn;
import Connections.Procedure;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Usuarios extends javax.swing.JFrame {

    //OBJECTS
    AnimationClass animation = new AnimationClass();
    Methods.General general = new Methods.General();
    Methods.Sound sound = new Methods.Sound();
    
    //VARIABLES
    int moveX, moveY;
    int ancho = 320;
    static ResultSet res;
    int alto = 210;
    String id;
    Dimension dimension = new Dimension(ancho, alto);
    Dimension dimension1 = WebcamResolution.VGA.getSize();
    Webcam webcam = Webcam.getDefault();
    WebcamPanel webcamPanel = new WebcamPanel(webcam, dimension, false);
    BufferedImage ruta;
    int counter = 0;

    public Usuarios() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("")).getImage());
        webcam.setViewSize(dimension1);
        webcamPanel.setFillArea(true);
        PCamera.setLayout(new FlowLayout());
        PCamera.add(webcamPanel);
        lbStatusCamera.setText(webcam.toString());
        id = Login.id;
        lbIdEncabezado.setText("INICIO DE SESION CON ID: " + id);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SCamera = new javax.swing.JScrollPane();
        PCameraSystem = new javax.swing.JPanel();
        PCamera = new javax.swing.JPanel();
        PControllers = new javax.swing.JPanel();
        btnOnOff = new javax.swing.JButton();
        lbOnOff = new javax.swing.JLabel();
        btnCapture = new javax.swing.JButton();
        lbCapture = new javax.swing.JLabel();
        btnSaveC = new javax.swing.JButton();
        lbSave = new javax.swing.JLabel();
        PStorage = new javax.swing.JPanel();
        lbStatusCamera = new javax.swing.JLabel();
        STable = new javax.swing.JScrollPane();
        tUsuarios = new javax.swing.JTable();
        PHome = new javax.swing.JPanel();
        PAcciones = new javax.swing.JPanel();
        btnRefresh = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
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
        tfContrasena = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        lbPhoto = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        lbTitulo = new javax.swing.JLabel();
        lbIdEncabezado = new javax.swing.JLabel();
        lbTitulo2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnGuie = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 700, 700));
        setMaximumSize(new java.awt.Dimension(700, 700));
        setMinimumSize(new java.awt.Dimension(700, 700));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(700, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SCamera.setBackground(new java.awt.Color(255, 255, 255));
        SCamera.setBorder(null);
        SCamera.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        SCamera.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        PCameraSystem.setBackground(new java.awt.Color(255, 255, 255));
        PCameraSystem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SISTEMA DE CAMARA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        PCameraSystem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PCamera.setBackground(new java.awt.Color(0, 0, 0));
        PCameraSystem.add(PCamera, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 320, 210));

        PControllers.setBackground(new java.awt.Color(255, 255, 255));
        PControllers.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONTROLADORES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        PControllers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOnOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/Off_x40N.png"))); // NOI18N
        btnOnOff.setBorder(null);
        btnOnOff.setBorderPainted(false);
        btnOnOff.setContentAreaFilled(false);
        btnOnOff.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnOnOff.setFocusPainted(false);
        btnOnOff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOnOffMouseClicked(evt);
            }
        });
        PControllers.add(btnOnOff, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 40, -1));

        lbOnOff.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbOnOff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbOnOff.setText("On / Off");
        PControllers.add(lbOnOff, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 80, -1));

        btnCapture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/CaptureOff_x40N.png"))); // NOI18N
        btnCapture.setBorder(null);
        btnCapture.setBorderPainted(false);
        btnCapture.setContentAreaFilled(false);
        btnCapture.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCapture.setEnabled(false);
        btnCapture.setFocusPainted(false);
        btnCapture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaptureActionPerformed(evt);
            }
        });
        PControllers.add(btnCapture, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 40, -1));

        lbCapture.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbCapture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCapture.setText("Tomar foto");
        PControllers.add(lbCapture, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 80, -1));

        btnSaveC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/Save_x40N.png"))); // NOI18N
        btnSaveC.setBorder(null);
        btnSaveC.setBorderPainted(false);
        btnSaveC.setContentAreaFilled(false);
        btnSaveC.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSaveC.setEnabled(false);
        btnSaveC.setFocusPainted(false);
        btnSaveC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveCActionPerformed(evt);
            }
        });
        PControllers.add(btnSaveC, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 40, -1));

        lbSave.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSave.setText("Guardar");
        PControllers.add(lbSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 80, -1));

        PCameraSystem.add(PControllers, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 280, 110));

        PStorage.setBackground(new java.awt.Color(255, 255, 255));
        PStorage.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ALMACENAMIENTO", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        PStorage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbStatusCamera.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lbStatusCamera.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbStatusCamera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/Off_x32R.png"))); // NOI18N
        lbStatusCamera.setToolTipText("");
        PStorage.add(lbStatusCamera, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 260, 30));

        PCameraSystem.add(PStorage, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 280, 100));

        SCamera.setViewportView(PCameraSystem);

        getContentPane().add(SCamera, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 340, 640, 260));

        tUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
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
        STable.setViewportView(tUsuarios);

        getContentPane().add(STable, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 640, 260));

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
        PAcciones.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

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
        PAcciones.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        btnFotografia.setBackground(new java.awt.Color(255, 255, 255));
        btnFotografia.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnFotografia.setForeground(new java.awt.Color(255, 255, 255));
        btnFotografia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/btnFotografia1.jpg"))); // NOI18N
        btnFotografia.setBorder(null);
        btnFotografia.setBorderPainted(false);
        btnFotografia.setContentAreaFilled(false);
        btnFotografia.setFocusPainted(false);
        btnFotografia.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/btnFotografia2.jpg"))); // NOI18N
        btnFotografia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotografiaActionPerformed(evt);
            }
        });
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
        PDatos.add(lbAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 80, -1));

        lbDireccion.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lbDireccion.setText("Dirección:");
        PDatos.add(lbDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        lbId.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lbId.setText("ID:");
        PDatos.add(lbId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        cbSexo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        cbSexo.setBorder(null);
        cbSexo.setOpaque(false);
        PDatos.add(cbSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 100, 20));
        PDatos.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 140, 10));
        PDatos.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 70, 10));
        PDatos.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 150, 10));
        PDatos.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 80, 10));
        PDatos.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 140, 10));
        PDatos.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 360, 10));

        cbIdRol.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cbIdRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Gerente", "Cajero" }));
        cbIdRol.setBorder(null);
        cbIdRol.setOpaque(false);
        PDatos.add(cbIdRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, 20));

        tfAM.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tfAM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfAM.setBorder(null);
        tfAM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfAMKeyTyped(evt);
            }
        });
        PDatos.add(tfAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 140, -1));

        tfNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tfNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfNombre.setBorder(null);
        tfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNombreKeyTyped(evt);
            }
        });
        PDatos.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 150, -1));

        tfId.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tfId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfId.setBorder(null);
        tfId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfIdKeyTyped(evt);
            }
        });
        PDatos.add(tfId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 70, -1));

        tfTelefono.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tfTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfTelefono.setBorder(null);
        tfTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfTelefonoKeyTyped(evt);
            }
        });
        PDatos.add(tfTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 80, -1));

        tfAP.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tfAP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfAP.setBorder(null);
        tfAP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfAPKeyTyped(evt);
            }
        });
        PDatos.add(tfAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 140, -1));

        tfDireccion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tfDireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfDireccion.setBorder(null);
        tfDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfDireccionKeyTyped(evt);
            }
        });
        PDatos.add(tfDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 360, -1));

        lbTelefono1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lbTelefono1.setText("Telefono:");
        PDatos.add(lbTelefono1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        tfContrasena.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tfContrasena.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfContrasena.setBorder(null);
        tfContrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfContrasenaKeyTyped(evt);
            }
        });
        PDatos.add(tfContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 80, -1));
        PDatos.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 80, 10));

        lbPhoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbPhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPhotoMouseClicked(evt);
            }
        });
        PDatos.add(lbPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 170, 140));

        PHome.add(PDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 640, 160));

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

        lbIdEncabezado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbIdEncabezado.setForeground(new java.awt.Color(255, 255, 255));
        lbIdEncabezado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIdEncabezado.setText("INICIO DE SESION CON ID:");
        PHome.add(lbIdEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 650, -1));

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

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/Usuarios.jpg"))); // NOI18N
        PHome.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 700));

        getContentPane().add(PHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, -1));

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
        //Agregar Usuario
        //Asignación de variables que recolectaran la información del formulario
        int rolcb, sexocb, validacion = 0;
        String id, name, ap, am, address, phone, pass, rolstring = "", sexostring = "";
        id = tfId.getText().trim();
        name = tfNombre.getText().trim();
        ap = tfAP.getText().trim();
        am = tfAM.getText().trim();
        address = tfDireccion.getText().trim();
        phone = tfTelefono.getText().trim();
        pass = tfContrasena.getText().trim();
        rolcb = cbIdRol.getSelectedIndex() + 1;
        sexocb = cbSexo.getSelectedIndex() + 1;
        //Evitar que algun campo este vacio
        if (id.equals("") || name.equals("") || ap.equals("") || am.equals("") || address.equals("") || phone.equals("")
                || phone.equals("") || pass.equals("")) {
            validacion++;
            JOptionPane.showMessageDialog(null, "Inserte datos en los campos vacios", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
        //Convertir lo que se obtenga del Rol y convertirlo a una cadena aceptada en la BD
        switch (rolcb) {
            case 1:
                rolstring = "A0000001";
                break;
            case 2:
                rolstring = "G0000001";
                break;
            case 3:
                rolstring = "C0000001";
                break;
            default:
                break;
        }
        //Convertir lo que se obtenga del Sexo y convertirlo a una cadena aceptada en la BD
        if (sexocb == 1) {
            sexostring = "M";
        } else if (sexocb == 2) {
            sexostring = "F";
        }
        //Verificar si existe ya un usuario con la id que se desea ingresar
        try {
            Connection cn = Connectionn.getConnection();
            PreparedStatement pst = cn.prepareStatement("select id_usuario from Usuarios where id_usuario = '"
                    + id + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "ID en uso", "ERROR", JOptionPane.ERROR_MESSAGE); //Mensaje de error si el id esta en uso
                cn.close();
            } else {
                cn.close();
                if (validacion == 0) {
                    try { //Guardar los datos si el id no esta en uso
                        Connection cn2 = Connectionn.getConnection();
                        PreparedStatement pst2 = cn2.prepareStatement("insert into Usuarios values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                        pst2.setString(1, id);
                        pst2.setString(2, rolstring);
                        pst2.setString(3, name);
                        pst2.setString(4, ap);
                        pst2.setString(5, am);
                        pst2.setString(6, address);
                        pst2.setString(7, phone);
                        pst2.setString(8, sexostring);
                        pst2.setString(9, "x");
                        pst2.setString(10, pass);
                        pst2.executeUpdate();
                        cn2.close();
                        JOptionPane.showMessageDialog(null, "Usuario creado correctamente", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                        refresh();
                    } catch (SQLException e) { //Error en dado de suceder un error desconocido
                        System.err.println("Error al registrar usuario" + e);
                        JOptionPane.showMessageDialog(null, "Error al registrar usuario, contacte al administrador", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (SQLException e) { //Error al validar el id por un error desconocido
            System.err.println("Error en la validacion del usuario" + e);
            JOptionPane.showMessageDialog(null, "Errores al comparar usuarios, contacte al administrador", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        int row1 = tUsuarios.getSelectedRow(); //Se obtiene el numero de la fila
        if (row1 == -1) { //Si no se ha seleccionado una fila se le avisa al usuario a través de un mensaje
            sound.warning();
            JOptionPane.showMessageDialog(null, "SELECCIONE UN REGISTRO", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            int row = tUsuarios.getSelectedRow(); //Se envia un mensaje de confirmación
            sound.warning();
            int opc = JOptionPane.showConfirmDialog(this, "¿DESEA ELIMINAR EL USUARIO?", "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opc == JOptionPane.YES_OPTION) { //si la respuesta es correcta, se llama al procedimiento almacenado "Eliminar Usuario"
                try {
                    sound.executed();
                    Procedure.EliminarUsuarios(Integer.parseInt(tUsuarios.getValueAt(row, 0).toString()));
                    refresh();
                } catch (SQLException e) {
                }
            }
        }
    }//GEN-LAST:event_btnDeleteMouseClicked
/*EMMANUEL MIRANDA DIAZ, 18TE0559, Evento: Modificar*/
    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        //Se verifica que ningun campo este vacio
        if (tfId.getText().isEmpty() || cbIdRol.getSelectedItem() == "" || tfNombre.getText().isEmpty() || tfAP.getText().isEmpty() || tfAM.getText().isEmpty()
                || tfDireccion.getText().isEmpty() || tfTelefono.getText().isEmpty() || cbSexo.getSelectedItem() == "" || tfContrasena.getText().isEmpty()) {
            sound.warning();
            JOptionPane.showMessageDialog(this, "CAMPOS VACIOS", "WARNING", JOptionPane.WARNING_MESSAGE); //Mensaje de error
        } else {
            try { //Se convierte la información que se obtenga del ComboBox "Rol" para que coincida con la tabla "rol" de la bd
                String x = cbIdRol.getSelectedItem().toString();
                if (x == "Gerente") {
                    x = "G0000001";
                }
                if (x == "Cajero") {
                    x = "C0000001";
                }
                if (x == "Administrador") {
                    x = "A0000001";
                } //Se actualizan los datos; NOTA: la variable x se ingresa al id_rol (previamente se realizo la conversión)
                PreparedStatement pss = Connections.Connectionn.getConnection().prepareStatement("update Usuarios set id_rol='" + x
                        + "', nombre='" + tfNombre.getText() + "', ape_paterno='" + tfAP.getText() + "', ape_materno='" + tfAM.getText()
                        + "', direccion='" + tfDireccion.getText() + "', telefono='" + tfTelefono.getText() + "', contraseña='" + tfContrasena.getText()
                        + "' where id_usuario='" + tfId.getText() + "'");
                pss.executeUpdate();
                sound.executed();
                JOptionPane.showMessageDialog(this, "DATOS MODIFICADOS", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);  //Se confirma la actualización
                general.clear(tfId, cbIdRol, tfNombre, tfAP, tfAM, tfDireccion, tfTelefono, cbSexo, tfContrasena);
                refresh();
            } catch (SQLException e) {
            }
        }
    }//GEN-LAST:event_btnSaveMouseClicked
/*  Emmanuel Miranda Diaz - Modulo Usuario - Evento: Buscar*/
    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        if (tfId.getText().isEmpty()) { //Si el txt del id esta vacio, entonces enviara una advertencia
            sound.warning();
            JOptionPane.showMessageDialog(this, "INSERTA ID", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                String b;
                Procedure.BuscarUsuarios(Integer.parseInt(tfId.getText())); //Se le envia al procedimiento almacenado el id deseado
                b = tfId.getText();
                //Se limpian los espacios de texto por si hay algun campo con texto previo
                general.clear(tfId, cbIdRol, tfNombre, tfAP, tfAM, tfDireccion, tfTelefono, cbSexo, tfContrasena);
                res = Connections.Connectionn.consultation("select * from Usuarios"); //Sea crea un objeto de tipo Resulset, el cual aloja la consulta
                while (res.next()) { //Recorremos la bd
                    if (res.getString(1).equals(b)) { //Se busca en todos los id algun coincidente
                        sound.executed();
                        JOptionPane.showMessageDialog(this, "DATOS ENCONTRADOS", "INFORMATION", JOptionPane.INFORMATION_MESSAGE); //Mensaje de busqueda exitosa
                        tfId.setText(res.getString(1)); //Se envia el ID al espacio correspondiente
                        String x = res.getString(2); //Se hace la conversión del ID de Rol encontrado para mostrarlo como es nombrado
                        if (x == "G0000001") {
                            cbIdRol.setSelectedItem("Gerente");
                        }
                        if (x == "C0000001") {
                            cbIdRol.setSelectedItem("Cajero");
                        }
                        if (x == "A0000001") {
                            cbIdRol.setSelectedItem("Administrador");
                        }
                        //Se envian los datos restantes a los espacios correspondientes
                        tfNombre.setText(res.getString(3));
                        tfAP.setText(res.getString(4));
                        tfAM.setText(res.getString(5));
                        tfDireccion.setText(res.getString(6));
                        tfTelefono.setText(res.getString(7));
                        cbSexo.setSelectedItem(res.getString(8));
                        tfContrasena.setText(res.getString(10));
                    }
                }//Si no coincide con ningun id registrado, se muestra el siguiente mensaje
                JOptionPane.showMessageDialog(this, "DATOS NO ENCONTRADOS", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
            }
        }
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseClicked
        refresh();
        sound.clic();
        general.clear(tfId, cbIdRol, tfNombre, tfAP, tfAM, tfDireccion, tfTelefono, cbSexo, tfContrasena);
    }//GEN-LAST:event_btnRefreshMouseClicked

    boolean change = false;
    private void btnOnOffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOnOffMouseClicked
        if (!change) {
            btnOnOff.setIcon(new ImageIcon(getClass().getResource("/Elements/On_x40N.png")));
            btnCapture.setEnabled(true);
            btnCapture.setIcon(new ImageIcon(getClass().getResource("/Elements/CaptureOn_x40N.png")));
            btnSaveC.setEnabled(true);
            lbStatusCamera.setIcon(new ImageIcon(getClass().getResource("/Elements/On_x32V.png")));
            Thread t = new Thread() {
                @Override
                public void run() {
                    webcamPanel.start();
                }
            };
            t.setDaemon(true);
            t.start();
            change = true;
        } else {
            btnOnOff.setIcon(new ImageIcon(getClass().getResource("/Elements/Off_x40N.png")));
            btnCapture.setEnabled(false);
            btnCapture.setIcon(new ImageIcon(getClass().getResource("/Elements/CaptureOff_x40N.png")));
            btnSaveC.setEnabled(false);
            lbStatusCamera.setIcon(new ImageIcon(getClass().getResource("/Elements/Off_x32R.png")));
            webcamPanel.stop();
            change = false;
        }
    }//GEN-LAST:event_btnOnOffMouseClicked

    private void btnCaptureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaptureActionPerformed
        ImageIcon photo;
        photo = new ImageIcon(webcam.getImage());
        Icon icon = new ImageIcon(photo.getImage().getScaledInstance(lbPhoto.getWidth(), lbPhoto.getHeight(), Image.SCALE_SMOOTH));
        lbPhoto.setIcon(icon);
        ruta = webcam.getImage();
    }//GEN-LAST:event_btnCaptureActionPerformed

    private void btnSaveCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveCActionPerformed
        int x = JOptionPane.showConfirmDialog(this, "Confirmar para guardar", "INFORMACIÓN", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (x == 0) {
//            File outputFilwe = new File(set);
            counter++;
            try {
//                ImageIO.write(ruta, "jpg", outputFile);
                JOptionPane.showMessageDialog(this, "FOTO GUARDADA CORRECTAMETE", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSaveCActionPerformed

    private void btnFotografiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotografiaActionPerformed
        animation.jTextAreaXLeft(30, -700, 10, 10, STable);
        animation.jTextAreaXRight(-700, 30, 10, 10, STable);
        animation.jTextAreaXLeft(710, 30, 10, 10, SCamera);
        animation.jTextAreaXRight(30, 710, 10, 10, SCamera);
    }//GEN-LAST:event_btnFotografiaActionPerformed

    private void tfIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfIdKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
        if (tfId.getText().length() >= 8) {
            evt.consume();
            sound.warning();
        }
    }//GEN-LAST:event_tfIdKeyTyped

    private void tfNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombreKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
            evt.consume();
        }
        if (tfNombre.getText().length() >= 50) {
            evt.consume();
            sound.warning();
        }
    }//GEN-LAST:event_tfNombreKeyTyped

    private void tfAPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAPKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
            evt.consume();
        }
        if (tfAP.getText().length() >= 100) {
            evt.consume();
            sound.warning();
        }
    }//GEN-LAST:event_tfAPKeyTyped

    private void tfAMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAMKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
            evt.consume();
        }
        if (tfAM.getText().length() >= 100) {
            evt.consume();
            sound.warning();
        }
    }//GEN-LAST:event_tfAMKeyTyped

    private void tfDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDireccionKeyTyped
        if (tfDireccion.getText().length() >= 100) {
            evt.consume();
            sound.warning();
        }

    }//GEN-LAST:event_tfDireccionKeyTyped

    private void tfTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTelefonoKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
        if (tfTelefono.getText().length() >= 10) {
            evt.consume();
            sound.warning();
        }
    }//GEN-LAST:event_tfTelefonoKeyTyped

    private void tfContrasenaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfContrasenaKeyTyped
        char c = evt.getKeyChar();
        if (tfContrasena.getText().length() >= 20) {
            evt.consume();
            sound.warning();
        }
    }//GEN-LAST:event_tfContrasenaKeyTyped

    private void lbPhotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPhotoMouseClicked
        lbPhoto.setIcon(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(lbPhoto.getWidth(), lbPhoto.getHeight(), Image.SCALE_DEFAULT);
                lbPhoto.setIcon(new ImageIcon(icono));
                lbPhoto.updateUI();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, "imagen: " + ex);
            }
        }
    }//GEN-LAST:event_lbPhotoMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        refresh();
        sound.login();
    }//GEN-LAST:event_formWindowOpened

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
                v.add(res.getString(10));
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
            java.util.logging.Logger.getLogger(Usuarios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JPanel PCamera;
    private javax.swing.JPanel PCameraSystem;
    private javax.swing.JPanel PControllers;
    private javax.swing.JPanel PDatos;
    private javax.swing.JPanel PHome;
    private javax.swing.JPanel PStorage;
    private javax.swing.JScrollPane SCamera;
    private javax.swing.JScrollPane STable;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCapture;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFotografia;
    private javax.swing.JButton btnGuie;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnOnOff;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveC;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbIdRol;
    private javax.swing.JComboBox<String> cbSexo;
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
    private javax.swing.JLabel lbCapture;
    private javax.swing.JLabel lbDireccion;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbIdEncabezado;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbOnOff;
    private javax.swing.JLabel lbPhoto;
    private javax.swing.JLabel lbSave;
    private javax.swing.JLabel lbStatusCamera;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JLabel lbTelefono1;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbTitulo2;
    private javax.swing.JTable tUsuarios;
    private javax.swing.JTextField tfAM;
    private javax.swing.JTextField tfAP;
    private javax.swing.JTextField tfContrasena;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfTelefono;
    // End of variables declaration//GEN-END:variables
}
