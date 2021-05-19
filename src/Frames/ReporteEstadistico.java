/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author luisi
 */
public class ReporteEstadistico extends javax.swing.JDialog {

    /**
     * Creates new form ReporteEstadistico
     */
    
   //Luis Eduardo Hernandez Gil 16/05/2021
    DefaultTableModel modeloTabla = new DefaultTableModel(); //Modelo de la tabla 
    public ReporteEstadistico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //-----------------------------------------Llenado de la tabla---------------------------------------------------------------
        //Realizamos una consulta para obtener los productos vendidos
        ResultSet res = Connections.Connectionn.consultation(""+
        "Select p.nombre,pv.cantidad,m.nombre_marca,c.nombre_categoria,pr.nombre,p.precioVenta,p.imagen from Ventas as v"+
	" inner join ProductosVendidos as pv on pv.id_venta = v.id_venta and v.fechaVenta ='"+Reportes.fecha2+"'"+
	" inner join Productos as p on p.id_producto = pv.id_producto"+
	" inner join Categorias as c on p.id_categoria = c.id_categoria"+
	" inner join Marcas as m on p.id_marca= m.id_marca"+
	" inner join Proveedores as pr on pr.id_proveedor = p.id_proveedor");
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
            JOptionPane.showMessageDialog(this, "SE HA PRODUCIDO UN ERROR INESPERADO" , "INFORMACION!", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
        //-------------------------------------------Grafica de pastel-----------------------------------------------------------------
        try{
            DefaultPieDataset dato = new DefaultPieDataset();
            ResultSet productos = Connections.Connectionn.consultation("Select * from Productos");
            while (productos.next()) {
                int contador=0; 
                for (int i = 0; i < tProductos.getRowCount(); i++) {
                        //Verificamos si el producto a ingresar es igual a uno existente
                        if (tProductos.getValueAt(i, 0).equals(productos.getString(6))) {
                            //Si existe el producto en la tabla se toma el registro de cantidad
                            dato.setValue(productos.getString(6),Integer.parseInt(tProductos.getValueAt(i, 1).toString()));
                            contador=1;//Hace referencia a que el producto existe n la tabla
                            break;
                        }
                }
                if(contador!=1){
                    //En caso de no estar en la tabla se le asigna un 0
                    dato.setValue(productos.getString(6),0);
                }
            }
            //Creamos el grafico de pastel
            JFreeChart grafico_pastel = ChartFactory.createPieChart(
                "Productos Vendidos",   //Nombre del grafico
                dato,                  //datos
                true,                   //nombre de las categorias
                true,                   //herramientas
                false                   //generacion de url
            );
            //creamos un panel de tipo grafico, asignandole nuestra grafica y mostrandolo
            ChartPanel panel = new ChartPanel(grafico_pastel);
            panel.setMouseWheelEnabled(true);
            panel.setPreferredSize(new Dimension(500,320));
            //Al panel existente agregamos el panel con el grafico de pastel
            PanelPastel.setLayout(new BorderLayout());
            PanelPastel.add(panel,BorderLayout.NORTH);
        }catch(Exception e){
            //En caso de error se le informa al usuario con el respectivo mensaje de error
            JOptionPane.showMessageDialog(this, "SE HA PRODUCIDO UN ERROR INESPERADO" , "INFORMACION!", JOptionPane.INFORMATION_MESSAGE);
        }
        //-------------------------------------------Grafica de barras-----------------------------------------------------------------
        try{
            DefaultCategoryDataset datos = new DefaultCategoryDataset();
            ResultSet productos = Connections.Connectionn.consultation("Select * from Productos");
            while (productos.next()) {
                int contador=0; 
                for (int i = 0; i < tProductos.getRowCount(); i++) {
                        //Verificamos si la categoria a ingresar es igual a una existente
                        if (tProductos.getValueAt(i, 0).equals(productos.getString(6))) {
                            //Si existe la categoria en la tabla se toma el registro de cantidad
                            datos.setValue(Integer.parseInt(tProductos.getValueAt(i, 1).toString()),productos.getString(6),tProductos.getValueAt(i, 3).toString());
                            contador=1;//Hace referencia a que el producto existe n la tabla
                            break;
                        }
                }
                if(contador!=1){
                    //Se obtiene la categoria del producto quee no esta
                    ResultSet categoria = Connections.Connectionn.consultation(""+
                    "select c.nombre_categoria from categorias as c \n" +
                    "	inner join Productos as p on p.nombre='"+productos.getString(0)+"' and p.id_categoria=c.id_categoria");
                    //En caso de no estar en la tabla se le asigna un 0
                    datos.setValue(0,productos.getString(6),categoria.getString(0));
                }
            }
            //Creamos el grafico de barras
            JFreeChart grafico_barras = ChartFactory.createBarChart3D(
                "Ventas por categorias",    //Nombre del grafico
                "Productos",                //nombre de las barras
                "Cantidad",                 //nombre de la numeracion
                datos,                      //datos
                PlotOrientation.VERTICAL,   //orientacion
                true,                       //nombre de las categorias
                true,                       //herramientas
                false                       //generacion de url
            );
             //creamos un panel de tipo grafico, asignandole nuestra grafica y mostrandolo
            ChartPanel panel2 = new ChartPanel(grafico_barras);
            panel2.setMouseWheelEnabled(true);
            panel2.setPreferredSize(new Dimension(500,320));
            //Al panel existente agregamos el panel con el grafico de barras
            PanelBarras.setLayout(new BorderLayout());
            PanelBarras.add(panel2,BorderLayout.NORTH);
        }catch(Exception e){
            //En caso de error se le informa al usuario con el respectivo mensaje de error
            JOptionPane.showMessageDialog(this, "SE HA PRODUCIDO UN ERROR INESPERADO AL GENERAR EL GRAFICO DE BARRAS" , "INFORMACION!", JOptionPane.INFORMATION_MESSAGE);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tProductos = new javax.swing.JTable();
        PanelPastel = new javax.swing.JPanel();
        PanelBarras = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setText("Reportes");

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
                .addComponent(jLabel1)
                .addContainerGap(843, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        PanelPastel.setBackground(new java.awt.Color(239, 236, 238));
        PanelPastel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout PanelPastelLayout = new javax.swing.GroupLayout(PanelPastel);
        PanelPastel.setLayout(PanelPastelLayout);
        PanelPastelLayout.setHorizontalGroup(
            PanelPastelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        PanelPastelLayout.setVerticalGroup(
            PanelPastelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        PanelBarras.setBackground(new java.awt.Color(239, 236, 238));
        PanelBarras.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout PanelBarrasLayout = new javax.swing.GroupLayout(PanelBarras);
        PanelBarras.setLayout(PanelBarrasLayout);
        PanelBarrasLayout.setHorizontalGroup(
            PanelBarrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );
        PanelBarrasLayout.setVerticalGroup(
            PanelBarrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1034, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PanelPastel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelPastel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelBarras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            java.util.logging.Logger.getLogger(ReporteEstadistico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteEstadistico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteEstadistico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteEstadistico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReporteEstadistico dialog = new ReporteEstadistico(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel PanelBarras;
    private javax.swing.JPanel PanelPastel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tProductos;
    // End of variables declaration//GEN-END:variables
}
