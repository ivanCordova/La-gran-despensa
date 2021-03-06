/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import Connections.Connectionn;
import java.awt.List;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivan
 */
public class metodoVenta {

    public ArrayList<producto> buscarProducto(String dato, int tipo) {//Método para buscar productos por nombre o id

        ArrayList<producto> listaPro = new ArrayList<producto>();

        try {

            Connection con = Connectionn.getConnection();//Inicializamos la conexión 
            PreparedStatement ps = con.prepareStatement("");//Variable para cargar consulta 
            ResultSet rs; //Variable el resultado de la consulta 
            // Hacemos la consulta dependiendo el tipo, (Nombre = 0 , Id = 1)
            if (tipo == 0) {
                ps = con.prepareStatement("select p.id_producto, p.nombre, m.nombre_marca, p.precioVenta, p.imagen, c.nombre_categoria "
                        + "from Productos as p join Marcas as m on p.id_marca = m.id_marca join Categorias as c on p.id_categoria = c.id_categoria "
                        + "where p.nombre=?");
            } else {

                ps = con.prepareStatement("select p.id_producto, p.nombre, m.nombre_marca, p.precioVenta, p.imagen, c.nombre_categoria "
                        + "from Productos as p join Marcas as m on p.id_marca = m.id_marca join Categorias as c on p.id_categoria = c.id_categoria "
                        + "where p.id_producto=?");

            }

            ps.setString(1, dato);//Insertamos el dato buscando en la consulta 
            rs = ps.executeQuery();//Asignamos el resultado de la consulta 

            if (rs.next()) {
                do {
                    producto p = new producto();//Creamos una clase producto 

                    //Asignamos a cada variable del objeto producto el valor del Result set en su posición correspondiente 
                    p.id_producto = (Integer) rs.getObject(1);
                    p.nombre = (String) rs.getObject(2);
                    p.nombre_marca = (String) rs.getObject(3);
                    p.precioVenta = (double) rs.getObject(4);
                    p.imagen = (String) rs.getObject(5);
                    p.nombre_categoria = (String) rs.getObject(6);

                    listaPro.add(p);
                } while (rs.next());//Recorremos las filas de la consulta 
            } else {
                //En caso de no regresar ningún resultado mostramos un mensaje de advertencia 
                JOptionPane.showMessageDialog(null, "No se encontró ningún producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            return listaPro;//Regresamos el ArrayList
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public boolean agregarVenta(String idVenta, int idUsuario, Date fechaVenta, double sumaFinal ) { //Método para agregar una nueva venta a la tabla ventas 
        try {
            Connection con = Connectionn.getConnection();//Inicializamos la conexión 
            PreparedStatement ps = con.prepareStatement("");//Variable para cargar consulta 
            //ResultSet rs; //Variable el resultado de la consulta 
            
            ps = con.prepareStatement("insert into Ventas (id_venta, id_usuario, fechaVenta, sumaFinalV) values (?,?,?,?)");
            //Insertamos el dato buscando en la consulta
            ps.setString(1, idVenta);
            ps.setInt(2, idUsuario);
            ps.setString(3, ""+fechaVenta);
            ps.setDouble(4, sumaFinal);
            ps.executeUpdate();
            //ps.executeQuery();//Hacemos la consulta
            
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    public boolean agregarProVendido(String idVenta, int idProducto, int cantidad){
        try {
            Connection con = Connectionn.getConnection();//Inicializamos la conexión 
            PreparedStatement ps = con.prepareStatement("");//Variable para cargar consulta 
            //ResultSet rs; //Variable el resultado de la consulta 

            ps = con.prepareStatement("insert into ProductosVendidos (id_venta, id_producto, cantidad ) values (?,?,?)");
            //Insertamos el dato buscando en la consulta
            ps.setString(1, idVenta);
            ps.setInt(2, idProducto);
            ps.setInt(3, cantidad);
            ps.executeUpdate();
            //ps.executeQuery();//Hacemos la consulta 

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    public ArrayList<venta> listaVentas(){ // Método para crear un ArrayList con todas las ventas 
        try {
            ArrayList<venta> lista = new ArrayList<venta>();
            Connection con = Connectionn.getConnection();//Inicializamos la conexión 
            PreparedStatement ps = con.prepareStatement("select v.id_venta, u.nombre, v.fechaVenta, v.sumaFinalV "
                    + "from Ventas as v join Usuarios as u on v.id_usuario = u.id_usuario");//Variable para cargar consulta 
            ResultSet rs = ps.executeQuery(); //Variable el resultado de la consulta 

            if (rs.next()) {
                do {
                    venta nuevaVenta = new venta();//Creamos una clase venta 

                    //Asignamos a cada variable del objeto venta el valor del Result set en su posición correspondiente 
                    nuevaVenta.idVenta = (String) rs.getObject(1);
                    nuevaVenta.nombreUsuario = (String) rs.getObject(2);
                    nuevaVenta.fechaVenta = (Date) rs.getObject(3);
                    nuevaVenta.sumaFinal = (double) rs.getObject(4);

                    lista.add(nuevaVenta);
                } while (rs.next());//Recorremos las filas de la consulta 
            } else {
                //En caso de no regresar ningún resultado mostramos un mensaje de advertencia 
                JOptionPane.showMessageDialog(null, "No se encontró ningún producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            return lista;//Regresamos el ArrayList
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
            return null;
        }


        

    }
    
    public boolean eliminarVenta(String idVenta){ // Método para eliminar una venta con su id
        try {
            Connection con = Connectionn.getConnection();//Inicializamos la conexión 
            PreparedStatement ps = con.prepareStatement("");//Variable para cargar consulta 
            PreparedStatement ps2 = con.prepareStatement("");//Variable para cargar consulta 

            ps = con.prepareStatement("delete from ProductosVendidos where id_venta = ?");// Consulta para eliminar productos de ProductosVendidos 
            ps.setString(1, idVenta);// Sobrecargamos la consulta 
            ps.executeUpdate();
            
            ps2 = con.prepareStatement("delete from Ventas where id_venta = ?"); // // Consulta para eliminar productos de ventas
            ps2.setString(1, idVenta);// Sobrecargamos la consulta 
            ps2.executeUpdate();

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    public ArrayList<producto> listaProducto(String idVenta) { 
        // Método para crear un ArrayList con todas las ventas 
        try {
            ArrayList<producto> lista = new ArrayList<producto>();// Creamos el ArrayList para almacenar las ventas 
            Connection con = Connectionn.getConnection();//Inicializamos la conexión 
            PreparedStatement ps = con.prepareStatement("select pv.id_proventa, p.id_producto, p.nombre, m.nombre_marca, p.precioVenta,pv.cantidad "
                    + "from Ventas as v join ProductosVendidos as pv on v.id_venta = pv.id_venta "
                    + "join Productos as p on pv.id_producto = p.id_producto "
                    + "join Marcas as m on p.id_marca = m.id_marca where pv.id_venta = ?");//Variable para cargar consulta 
            ps.setString(1, idVenta);//Sobrecargamos los valores en la consulta 
            ResultSet rs = ps.executeQuery(); //Variable el resultado de la consulta 

            if (rs.next()) {
                do {
                    producto p = new producto();
                    p.id_proventa = (Integer)rs.getObject(1);
                    p.id_producto = (Integer)rs.getObject(2);
                    p.nombre = (String) rs.getObject(3);
                    p.nombre_marca = (String) rs.getObject(4);
                    p.precioVenta = (double) rs.getObject(5);
                    p.cantidad = (Short) rs.getObject(6);
                    p.subTotal = p.precioVenta * p.cantidad;
                    lista.add(p);
                } while (rs.next());//Recorremos las filas de la consulta 
            } else {
                //En caso de no regresar ningún resultado mostramos un mensaje de advertencia 
                JOptionPane.showMessageDialog(null, "No se encontró ningún producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            return lista;//Regresamos el ArrayList
        } catch (Exception e) {
            //Mensaje de error
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
            return null;
        }

    }
    
    public boolean eliminarProductoV(String idProducto, String subTotal, String idVenta){
        //Método para eliminar un producto de la venta 
        try {
            Connection con = Connectionn.getConnection();//Inicializamos la conexión 
            PreparedStatement ps = con.prepareStatement("");//Variable para cargar consulta 
            PreparedStatement ps2 = con.prepareStatement("");//Variable para cargar consulta 

            // Consulta para eliminar productos de ProductosVendidos 
            ps = con.prepareStatement("delete from ProductosVendidos where id_proventa = ?");
            ps.setString(1, idProducto);// Sobrecargamos la consulta 
            ps.executeUpdate();//Ejecutamos la consulta 
            
            
            // Consulta para actualizar la suma final de la venta 
            ps2 = con.prepareStatement("update Ventas set sumaFinalV = (sumaFinalV - ?) where id_venta = ?");
            ps2.setDouble(1, Double.parseDouble(subTotal));// Sobrecargamos la consulta 
            ps2.setString(2, idVenta);// Sobrecargamos la consulta 
            ps2.executeUpdate();//Ejecutamos la consulta 


            return true;
        } catch (Exception e) {
            //Mensaje de error
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    public boolean modificarProductoV(String idProducto, String subTotal, String idVenta){
        //Método para modificar un producto de la venta 
        try {
            Connection con = Connectionn.getConnection();//Inicializamos la conexión 
            PreparedStatement ps = con.prepareStatement("");//Variable para cargar consulta 
            PreparedStatement ps2 = con.prepareStatement("");//Variable para cargar consulta 

            // Consulta para eliminar productos de ProductosVendidos 
            ps = con.prepareStatement("delete from ProductosVendidos where id_proventa = ?");
            ps.setString(1, idProducto);// Sobrecargamos la consulta 
            ps.executeUpdate();

            // Consulta para actualizar productos de ProductosVendidos 
            ps2 = con.prepareStatement("update Ventas set sumaFinalV = (sumaFinalV - ?) where id_venta = ?");
            ps2.setDouble(1, Double.parseDouble(subTotal));// Sobrecargamos la consulta 
            ps2.setString(2, idVenta);// Sobrecargamos la consulta 
            ps2.executeUpdate();//Ejecutamos la consulta 

            return true;
        } catch (Exception e) {
            //Mensaje de error
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    public boolean modificarCantidadP(int nuevaCantidad, String idProducto, String idVenta){
        //Método para modificar la cantidad de productos vendidos y actualiza la suma final de venta 
        try {
            double nuevaSumaFinal = 0.0;
            Connection con = Connectionn.getConnection();//Inicializamos la conexión 
            PreparedStatement ps = con.prepareStatement("");//Variable para cargar consulta 
            PreparedStatement ps2 = con.prepareStatement("");//Variable para cargar consulta 
            PreparedStatement ps3 = con.prepareStatement("");//Variable para cargar consulta 
            
            // Consulta para actualizar cantidad de ProductosVendidos 
            ps = con.prepareStatement("update ProductosVendidos set cantidad = ? where id_proventa = ?");
            ps.setInt(1, nuevaCantidad);// Sobrecargamos la consulta 
            ps.setInt(2, Integer.parseInt(idProducto));// Sobrecargamos la consulta 
            ps.executeUpdate();

           //Seleccionamos la cantidad que ya se actualizado 
            ps2 = con.prepareStatement("select p.precioVenta, pv.cantidad from Productos as p join ProductosVendidos as pv on "
                    + "p.id_producto = pv.id_producto where pv.id_venta = ?");//Variable para cargar consulta 
            ps2.setString(1, idVenta);
            ResultSet rs = ps2.executeQuery(); //Variable el resultado de la consulta 

            if (rs.next()) {
                do {
                    
                    double precioVenta = (Double)rs.getObject(1);
                    int cantidad = (Short)rs.getObject(2);
                    nuevaSumaFinal += precioVenta * cantidad;

                } while (rs.next());//Recorremos las filas de la consulta 
            } else {
                //En caso de no regresar ningún resultado mostramos un mensaje de advertencia 
                JOptionPane.showMessageDialog(null, "No se encontró ningún producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

            //Actualizamos la suma final de la venta 
            ps3 = con.prepareStatement("update Ventas set sumaFinalV = ? where id_venta = ?");// Consulta para eliminar productos de ProductosVendidos 
            ps3.setDouble(1, nuevaSumaFinal);// Sobrecargamos la consulta 
            ps3.setString(2, idVenta);// Sobrecargamos la consulta 
            ps3.executeUpdate();

            return true;
        } catch (Exception e) {
            //Mensaje de error
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    public int totalVentas() {
        // Método para calcular el número total de ventas que se realizaron durante el día 
        try {
            int total = 0;
            Connection con = Connectionn.getConnection();//Inicializamos la conexión 
            PreparedStatement ps = con.prepareStatement("SELECT count(*) FROM Ventas");//Variable para cargar consulta 
            ResultSet rs = ps.executeQuery(); //Variable el resultado de la consulta 
            //Recorremos todos los resultados 
            if (rs.next()) {
                do {
                    //Asignamos a cada variable del objeto el valor del Result set en su posición correspondiente 
                    total = (Integer) rs.getObject(1);
                } while (rs.next());//Recorremos las filas de la consulta 
            } else {
                //En caso de no regresar ningún resultado mostramos un mensaje de advertencia 
                JOptionPane.showMessageDialog(null, "No se encontró ningún producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            return total;//Regresamos el resultado
        } catch (Exception e) {
            //Mensaje de error
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
            return 0;
        }
    }
    
    public int totalProductosVendidos() {
        //Este método calcula el total de productos que se vendieron durante el día 
        try {
            int total = 0;
            Connection con = Connectionn.getConnection();//Inicializamos la conexión 
            PreparedStatement ps = con.prepareStatement("SELECT count(*) FROM ProductosVendidos");//Variable para cargar consulta 
            ResultSet rs = ps.executeQuery(); //Variable el resultado de la consulta 
            //Recorremos todos los resultados 
            if (rs.next()) {
                do {
                    //Asignamos a cada variable del objeto el valor del Result set en su posición correspondiente
                    total = (Integer) rs.getObject(1);
                } while (rs.next());//Recorremos las filas de la consulta 
            } else {
                //En caso de no regresar ningún resultado mostramos un mensaje de advertencia 
                JOptionPane.showMessageDialog(null, "No se encontró ningún producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            return total;//Regresamos el resultado
        } catch (Exception e) {
            //Mensaje de error
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
            return 0;
        }
    }
    
    public ArrayList<String> productoMasVendidos() {
        //Este método nos regresa el nombre y la cantidad del producto más vendido 
        try {
            ArrayList<String> resultado = new ArrayList<String>();//Creamos el arrayList para guardar los resultados 
            Connection con = Connectionn.getConnection();//Inicializamos la conexión 
            PreparedStatement ps = con.prepareStatement("select top 1 p.nombre, sum(pv.cantidad) as total from ProductosVendidos as pv "
                    + "join Productos as p on "
                    + "pv.id_producto = p.id_producto  group by p.nombre order by total desc");//Variable para cargar consulta 
            ResultSet rs = ps.executeQuery(); //Variable el resultado de la consulta 
            //Recorremos todos los resultados 
            if (rs.next()) {
                do {
                    //Asignamos a cada variable del objeto el valor del Result set en su posición correspondiente
                    String res1 = (String) rs.getObject(1);
                    String res2 = ""+(Integer) rs.getObject(2);
                    resultado.add(res1);
                    resultado.add(res2);
                } while (rs.next());//Recorremos las filas de la consulta 
            } else {
                //En caso de no regresar ningún resultado mostramos un mensaje de advertencia 
                JOptionPane.showMessageDialog(null, "No se encontró ningún producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            return resultado;//Regresamos el ArrayList
        } catch (Exception e) {
            //Mensaje de error
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public ArrayList<String> mejorVendedor() {
        //Este método nos regresa el nombre y la cantidad de ventas que realizo el mejor vendedor 
        try {
            ArrayList<String> resultado = new ArrayList<String>();//Creamos el arrayList para guardar los resultados 
            Connection con = Connectionn.getConnection();//Inicializamos la conexión 
            PreparedStatement ps = con.prepareStatement("select top 1 u.nombre, count(u.nombre) as total from Ventas as v join Usuarios as u "
                    + "on v.id_usuario = u.id_usuario group by u.nombre order by total desc");//Variable para cargar consulta 
            ResultSet rs = ps.executeQuery(); //Variable el resultado de la consulta
            //Recorremos todos los resultados 
            if (rs.next()) {
                do {
                    //Asignamos a cada variable del objeto el valor del Result set en su posición correspondiente
                    String res1 = (String) rs.getObject(1);
                    String res2 = "" + (Integer) rs.getObject(2);
                    resultado.add(res1);
                    resultado.add(res2);
                } while (rs.next());//Recorremos las filas de la consulta 
            } else {
                //En caso de no regresar ningún resultado mostramos un mensaje de advertencia 
                JOptionPane.showMessageDialog(null, "No se encontró ningún producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            return resultado;//Regresamos el ArrayList
        } catch (Exception e) {
            //Mensaje de error
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public double totalVentasDia() {
        //Este método devuelve la ganancia total del día 
        try {
            double total = 0;//Variable para guardar el total
            Connection con = Connectionn.getConnection();//Inicializamos la conexión 
            PreparedStatement ps = con.prepareStatement("select sum(sumaFinalV) from Ventas");//Variable para cargar consulta 
            ResultSet rs = ps.executeQuery(); //Variable el resultado de la consulta 
            //Recorremos todos los resultados
            if (rs.next()) {
                do {
                    //Asignamos a cada variable del objeto el valor del Result set en su posición correspondiente
                    total = (double) rs.getObject(1);
                } while (rs.next());//Recorremos las filas de la consulta 
            } else {
                //En caso de no regresar ningún resultado mostramos un mensaje de advertencia 
                JOptionPane.showMessageDialog(null, "No se encontró ningún producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            return total;//Regresamos el resultado
        } catch (Exception e) {
             //Mensaje de error
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
            return 0;
        }
    }
    
    public String idRolUsuario(String id_Usuarios) {
        //Este método devuelve la ganancia total del día 
        try {
            String id_Rol = "";//Variable para guardar el total
            Connection con = Connectionn.getConnection();//Inicializamos la conexión 
            PreparedStatement ps = con.prepareStatement("select id_rol from Usuarios where id_usuario = ?");//Variable para cargar consulta 
            ps.setString(1, id_Usuarios);// Sobrecargamos la consulta 
            ResultSet rs = ps.executeQuery(); //Variable el resultado de la consulta 
            //Recorremos todos los resultados
            if (rs.next()) {
                do {
                    //Asignamos a cada variable del objeto el valor del Result set en su posición correspondiente
                    id_Rol = (String)rs.getObject(1);
                } while (rs.next());//Recorremos las filas de la consulta 
            } else {
                //En caso de no regresar ningún resultado mostramos un mensaje de advertencia 
                JOptionPane.showMessageDialog(null, "No se encontró ningún producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            return id_Rol;//Regresamos el resultado
        } catch (Exception e) {
            //Mensaje de error
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
            return "";
        }
    }
}
