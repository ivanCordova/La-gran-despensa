/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luisi
 */
public class ReporteMensual extends javax.swing.JDialog {

    /**
     * Creates new form ReporteMensual
     */
        DefaultTableModel modeloTabla = new DefaultTableModel(); //Modelo de la tabla 
    public ReporteMensual(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Variables para la consulta por mes
        int mesini=Reportes.mes+1;
        int mesfin= Reportes.mes+2;
        String mesinit= ""+mesini;
        String mesfini=""+mesfin;
        //Se le agregamos un cero al mes en caso dee que solo contenga un digito
        if(mesini<10){
            mesinit= "0"+mesini;
        }
        if(mesfin<10){
            mesfini= "0"+mesfin;
        }
        //Colocamos el encabezado de la ventana con respecto a la fecha indicada
        Titulo.setText("Reporte del día: "+mesinit+" - "+Reportes.anio);
        //-----------------------------------------Llenado de la tabla---------------------------------------------------------------
        //Realizamos una consulta para obtener los productos vendidos
        ResultSet res = Connections.Connectionn.consultation(""+
        "Select p.nombre,pv.cantidad,m.nombre_marca,c.nombre_categoria,pr.nombre,p.precioVenta,p.imagen from Ventas as v \n" +
        "	inner join ProductosVendidos as pv  on pv.id_venta = v.id_venta \n" +
        "	inner join Productos as p on p.id_producto = pv.id_producto\n" +
        "	inner join Categorias as c on p.id_categoria = c.id_categoria\n" +
        "	inner join Marcas as m on p.id_marca= m.id_marca\n" +
        "	inner join Proveedores as pr on pr.id_proveedor = p.id_proveedor\n" +
        "WHERE v.fechaVenta BETWEEN '"+Reportes.anio+""+mesinit+"01' AND '"+Reportes.anio+""+mesfini+"01'");
        try{
            //Modelo de nueestra tabla
            modeloTabla.addColumn("Nombre");
            modeloTabla.addColumn("Cantidad");
            modeloTabla.addColumn("Marca");
            modeloTabla.addColumn("Categoria");
            modeloTabla.addColumn("Proveedor");
            modeloTabla.addColumn("Precio Venta");
            modeloTabla.addColumn("Imagen");
            this.tProductos.setModel(modeloTabla);//Agregamos el modelo a la tabla
            String []datos = new String[7]; //Arreglo para obtener los datos de la consulta
            //Recorremos la respuesta
            while (res.next()) {   
                int count=0;//variable para controlar productos repetidos
                //Agregamos al arreglo los datos correspondientes
                datos[0] = res.getString(1);
                datos[1] = res.getString(2);
                datos[2] = res.getString(3);
                datos[3] = res.getString(4);
                datos[4] = res.getString(5);
                datos[5] = res.getString(6);
                datos[6] = res.getString(7);
                //Si la tabla esta vacia agregamos el primer registro
                if (tProductos.getRowCount()==0) {
                    modeloTabla.addRow(datos);//Agregamos el registro al modelo
                    tProductos.setModel(modeloTabla);//Agregamos el modelo a la tabla
                }else{
                    //Se reecorre la tabla en busca de productos repetidos
                    for (int i = 0; i < tProductos.getRowCount(); i++) {
                        //Verificamos si el producto a ingresar es igual a uno existente
                        if (tProductos.getValueAt(i, 0).equals(datos[0])) {
                            //Si existe el producto solo se suma la cantidad vendida al registro existente
                            int suma=Integer.parseInt(tProductos.getValueAt(i, 1).toString())+Integer.parseInt(datos[1]);
                            tProductos.setValueAt(suma, i, 1);
                            count=1;//Cambiamos el contador a uno para no volcer a agregar el producto
                            tProductos.setModel(modeloTabla);//agregamos el modelo a la tabla
                            break;
                        }
                    }
                    //Si el producto aun no esta en la tabla, se agrega
                    if (count!=1) {
                        modeloTabla.addRow(datos);//Agregamos el registro al modelo
                        tProductos.setModel(modeloTabla);//agregamos el modelo a la tabla
                    }
                }
            }
            
        }catch(Exception e){
            //En caso de error se le informa al usuario con el respectivo mensaje de error
            JOptionPane.showMessageDialog(this, "SE HA PRODUCIDO UN ERROR INESPERADO"+ e.getMessage(), "INFORMACION!", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tProductos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Cantidad", "Marca", "Categoría", "Proveedor", "Precio Venta", "Imagen"
            }
        ));
        jScrollPane2.setViewportView(tProductos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));

        Titulo.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        Titulo.setText("Reporte del mes: 05-2021");

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Elements/Logo_x32.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(Titulo)
                .addContainerGap(226, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(Titulo)
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ReporteMensual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteMensual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteMensual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteMensual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReporteMensual dialog = new ReporteMensual(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tProductos;
    // End of variables declaration//GEN-END:variables
}
