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
}
