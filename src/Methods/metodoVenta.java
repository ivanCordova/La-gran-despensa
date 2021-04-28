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

/**
 *
 * @author Ivan
 */
public class metodoVenta {
    
    public ArrayList<producto>  buscarProducto(String dato){

        
         ArrayList<producto> listaPro = new ArrayList<producto>();
         
         PreparedStatement ps;
         ResultSet rs;
         
         try {
            Connections.Connectionn.enter("ivan", "ivan");
            Connection con = Connectionn.getConnection();
            ps = con.prepareStatement("select p.id_producto, p.nombre, m.nombre_marca, p.precioVenta, p.imagen \n" +
                                        "from Productos as p join Marcas as m on p.id_marca = m.id_marca where p.nombre=?");
            ps.setString(1, dato);
            rs = ps.executeQuery();
             while (rs.next()) {
                 producto p = new producto();
                 p.id_producto = (Integer)rs.getObject(1);
                 p.nombre = (String)rs.getObject(2);
                 p.nombre_marca = (String)rs.getObject(3);
                 p.precioVenta = (BigDecimal)rs.getObject(4);
                 p.imagen = (String)rs.getObject(5);       
                 
                 listaPro.add(p);
             }
            
            
            
            return listaPro;
        } catch (Exception e) {
             System.err.println(e.toString());
            return null;
        }
    }
    
    public void agregarCarrito(){
        
    }
}
