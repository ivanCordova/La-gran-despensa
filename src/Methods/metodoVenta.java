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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivan
 */
public class metodoVenta {

    public ArrayList<producto> buscarProducto(String dato, int tipo) {//Método para buscar productos por nombre

        ArrayList<producto> listaPro = new ArrayList<producto>();

        try {
//            Connections.Connectionn.enter("ivan", "ivan");//Ingresamos las credenciales de conexión 
            Connection con = Connectionn.getConnection();//Inicializamos la conexión 
            PreparedStatement ps = con.prepareStatement("");//Variable para cargar consulta 
            ResultSet rs; //Variable el resultado de la consulta 
//            ps = con.prepareStatement("select p.id_producto, p.nombre, m.nombre_marca, p.precioVenta, p.imagen \n"
//                    + "from Productos as p join Marcas as m on p.id_marca = m.id_marca where p.nombre=?"); //Cargamos la consulta 

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

    public void agregarCarrito() {

    }
}
