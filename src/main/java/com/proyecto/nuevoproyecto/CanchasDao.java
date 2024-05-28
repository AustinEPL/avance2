package com.proyecto.nuevoproyecto;

import com.mysql.cj.x.protobuf.MysqlxPrepare;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CanchasDao {

    private DataSource origen;

    public CanchasDao(DataSource origen) {
        this.origen = origen;

    }

    //Listado de todas las canchas disponibles
    public List<Canchas> getCanchas() {
        List<Canchas> canchas = new ArrayList<Canchas>();
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            //Conectar a la bbdd
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = origen.getConnection();
            //Crear mi query
            String sql = "select * from canchas";
            //Crear el statement
            st = cn.createStatement();
            //Ejecutar el query y almacenar el resultSet
            rs = st.executeQuery(sql);
            //Recorrer los resultados

            while (rs.next()) {

                int id = rs.getInt("id_cancha");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String horario = rs.getString("horario");
                double precio = rs.getDouble("precio");
                int longitud = rs.getInt("longitud");
                int ancho = rs.getInt("ancho");
                String descripcion = rs.getString("descripcion");
                int capacidad = rs.getInt("capacidad");
                String imagen = rs.getString("imagen");

                Canchas temp = new Canchas(id, nombre, direccion, horario, precio, longitud, ancho, descripcion, capacidad, imagen);
                canchas.add(temp);
            }

            return canchas;
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    //metodo para añadir una cancha a la bbdd
    public void addCancha(Canchas nueva) {
        Connection cn = null;
        PreparedStatement ps = null;

        try {
            //obtener la conexion
            Class.forName("com.mysql.cj.jdbc.Driver");

            cn = origen.getConnection();
            String sql = "INSERT INTO canchas (nombre,direccion,horario,precio,longitud,ancho,descripcion,capacidad,imagen) VALUES (?,?,?,?,?,?,?,?,?)";
            //crear la query para insertar
            ps = cn.prepareStatement(sql);

            //establecer los parametros para la cancha
            ps.setString(1, nueva.getNombre());
            ps.setString(2, nueva.getDireccion());
            ps.setString(3, nueva.getHorario());
            ps.setDouble(4, nueva.getPrecio());
            ps.setInt(5, nueva.getLongitud());
            ps.setInt(6, nueva.getAncho());
            ps.setString(7, nueva.getDescripcion());
            ps.setInt(8, nueva.getCapacidad());
            ps.setString(9, nueva.getImagen());
            //ejecutar la query
            ps.execute();
        } catch (Exception e) {
            System.out.println("error " + e);
        } finally {
            try {

                if (ps != null) ps.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        //Conectar a la bbdd


    }

    public void eliminar(int id) {
        Connection cn = null;
        PreparedStatement ps = null;
        try {

            cn = origen.getConnection();
            String sql = "DELETE FROM canchas WHERE id_cancha = ?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            System.out.println("eliminando el id " + id);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public Canchas obtenerCancha(int id) {

        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = origen.getConnection();
            String sql = "select * from canchas where id_cancha = ?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                int idc = rs.getInt("id_cancha");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String horario = rs.getString("horario");
                double precio = rs.getDouble("precio");
                int longitud = rs.getInt("longitud");
                int ancho = rs.getInt("ancho");
                String descripcion = rs.getString("descripcion");
                int capacidad = rs.getInt("capacidad");
                String imagen = rs.getString("imagen");

                Canchas temp = new Canchas(idc, nombre, direccion, horario, precio, longitud, ancho, descripcion, capacidad, imagen);
                return temp;

            } else {
                throw new Exception("Nose ha encontrado el articulo " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public void actualizarSinImagen(Canchas actu) {

        Connection cn = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = origen.getConnection();
            String sql = "UPDATE canchas SET nombre=?, direccion=?,horario=?,precio=?,longitud=?,ancho=?,descripcion=?,capacidad=? where id_cancha = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, actu.getNombre());
            ps.setString(2, actu.getDireccion());
            ps.setString(3, actu.getHorario());
            ps.setDouble(4, actu.getPrecio());
            ps.setInt(5, actu.getLongitud());
            ps.setInt(6, actu.getAncho());
            ps.setString(7, actu.getDescripcion());
            ps.setInt(8, actu.getCapacidad());
            ps.setInt(9, actu.getId());

            ps.execute();

        } catch (Exception e) {
            System.out.println(e);

        } finally {

            try {

                if (ps != null) ps.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void actualizarConImagen(Canchas actu) {

        Connection cn = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = origen.getConnection();
            String sql = "UPDATE canchas SET nombre=?, direccion=?,horario=?,precio=?,longitud=?,ancho=?,descripcion=?,capacidad=?,imagen=? where id_cancha = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, actu.getNombre());
            ps.setString(2, actu.getDireccion());
            ps.setString(3, actu.getHorario());
            ps.setDouble(4, actu.getPrecio());
            ps.setInt(5, actu.getLongitud());
            ps.setInt(6, actu.getAncho());
            ps.setString(7, actu.getDescripcion());
            ps.setInt(8, actu.getCapacidad());
            ps.setString(9, actu.getImagen());
            ps.setInt(10, actu.getId());

            ps.execute();

        } catch (Exception e) {
            System.out.println(e);

        } finally {

            try {

                if (ps != null) ps.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
