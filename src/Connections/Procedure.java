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
        CallableStatement input = Connectionn.getConnection().prepareCall("{call BuscarUsuario(?)}");
        input.setInt(1, a);
        input.execute();
    }
}
