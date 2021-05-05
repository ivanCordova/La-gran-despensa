package Frames;

public class Presentation extends javax.swing.JFrame {

    public Presentation() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbCargando = new javax.swing.JLabel();
        lbPorcentaje = new javax.swing.JLabel();
        bProgreso = new javax.swing.JProgressBar();
        bgPresentation = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cargando...");
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 450, 264));
        setMaximumSize(new java.awt.Dimension(450, 264));
        setMinimumSize(new java.awt.Dimension(450, 264));
        setName("Presentation"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbCargando.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        lbCargando.setForeground(new java.awt.Color(255, 255, 255));
        lbCargando.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbCargando.setText("Cargando");
        getContentPane().add(lbCargando, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 80, 20));

        lbPorcentaje.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        lbPorcentaje.setForeground(new java.awt.Color(255, 255, 255));
        lbPorcentaje.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbPorcentaje.setText("0%");
        getContentPane().add(lbPorcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 40, 20));

        bProgreso.setBackground(new java.awt.Color(66, 108, 180));
        bProgreso.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(bProgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 410, 5));

        bgPresentation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/Presentation.jpg"))); // NOI18N
        getContentPane().add(bgPresentation, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 264));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JProgressBar bProgreso;
    private javax.swing.JLabel bgPresentation;
    public javax.swing.JLabel lbCargando;
    public javax.swing.JLabel lbPorcentaje;
    // End of variables declaration//GEN-END:variables
}
