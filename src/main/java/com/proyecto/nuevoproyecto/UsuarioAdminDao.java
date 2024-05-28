package com.proyecto.nuevoproyecto;

import services.PasswordHasher;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioAdminDao {
    //creamos objeto para manejar la conexion
    private DataSource miPool;

    public UsuarioAdminDao(DataSource miPool) {
        this.miPool = miPool;
    }

    public UsuarioAdmin auth(UsuarioAdmin usuarioA) {
        //creamoos el objeto UsuarioAdmin
        UsuarioAdmin usuarioAdmin = usuarioA;
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = miPool.getConnection();
            //Preparamos la consulta
            ps = cn.prepareStatement("Select * from trabajadores where email=? and password=?");
            ps.setString(1, usuarioAdmin.getCorreo());
            ps.setString(2, usuarioAdmin.getPassword());
            rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(rs);
                return new UsuarioAdmin(rs.getInt("id_trabajador"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("email"), rs.getString("password"), rs.getInt("dni"), rs.getInt("celular"), rs.getString("cargo"));

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public void aniadirTrabajador(UsuarioAdmin temp) throws SQLException {
        UsuarioAdmin usuarioAdmin = temp;

        //cremoas la conexion
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            cn=miPool.getConnection();
            String sql="insert into trabajadores(nombre,apellidos,email,password,dni,celular,cargo) values(?,?,?,?,?,?,?)";
            ps=cn.prepareStatement(sql);
            ps.setString(1,temp.getNombre());
            ps.setString(2,temp.getApellido());
            ps.setString(3,temp.getCorreo());
            ps.setString(4,temp.getPassword());
            ps.setInt(5,temp.getDni());
            ps.setInt(6,temp.getCelular());
            ps.setString(7,temp.getCargo());

            ps.execute();

        }catch (Exception e){
            System.out.println(e.getMessage());

        }finally {
            if (ps != null) ps.close();
            if (cn != null) cn.close();
        }

    }

    //Autenticar


}
