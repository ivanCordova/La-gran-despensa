/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import java.math.BigDecimal;


/**
 *
 * @author Ivan
 */
public class producto { //Clase productos para cargar en Nueva venta 
//    int id_producto;
//    int id_marca;
//    int id_categoria;
//    int id_medida;
//    int id_proveedor;
//    int nombre;
//    int precioVenta;
//    String imagen;
    
    public int id_proventa;
    public int id_producto;
    public String nombre;
    public String nombre_marca;
    public double precioVenta;
    public String imagen;
    public String nombre_categoria;
    public Short cantidad;
    public double subTotal;

    public producto() {
        id_proventa = 0;
        id_producto = 0;
        cantidad = 1;
        subTotal = 0;
    }
    
    
}
