package Connections;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class Procedure {

    public static void entradaUsuarios(int a, String b, String c, String d, String e, String f, String g, String h, String i) throws SQLException {
        CallableStatement input = Connectionn.getConnection().prepareCall("{call EntradaUsuario(?,?,?,?,?,?,?,?,?)}");
        input.setInt(1, a);
        input.setString(2, b);
        input.setString(3, c);
        input.setString(4, d);
        input.setString(5, e);
        input.setString(6, f);
        input.setString(7, g);
        input.setString(8, h);
        input.setString(9, i);
        input.execute();
    }

    public static void EliminarUsuarios(int a) throws SQLException {
        CallableStatement input = Connectionn.getConnection().prepareCall("{call EliminarUsuario(?)}");
        input.setInt(1, a);
        input.execute();
    }

    public static void BuscarUsuarios(int a) throws SQLException {
        CallableStatement input = Connectionn.getConnection().prepareCall("{call BuscarUsuario(?)}"); //Llamado del procedimiento almacenado BuscarUsuario
        input.setInt(1, a); //A nuestro parametro se le asigna una posición en la bd de tipo INT
        input.execute(); //Finalizar
    }
    
    public static void AgregarProveedor(int id_Provee, String nombre_Provee, String empresa_Provee
            , String telefono_Provee, String fecha_Provee, String direccion_Provee) throws SQLException {
        CallableStatement input = Connectionn.getConnection().prepareCall("{call EntradaUsuario(?,?,?,?,?,?,?,?,?)}");
        input.setInt(1, id_Provee);
        input.setString(2, nombre_Provee);
        input.setString(3, empresa_Provee);
        input.setString(4, telefono_Provee);
        input.setString(5, fecha_Provee);
        input.setString(6, direccion_Provee);
        input.execute();
    }
    
     public static void ConsultarProveedor(int id_Provee) throws SQLException {
        CallableStatement input = Connectionn.getConnection().prepareCall("{call EliminarUsuario(?)}");
        input.setInt(1, id_Provee);
        input.execute();
    }

    public static void ModificarProveedor(int id_Provee) throws SQLException {
        CallableStatement input = Connectionn.getConnection().prepareCall("{call ModificarProvee(?)}"); 
        input.setInt(1, id_Provee); 
        input.execute(); 
    }
}
