package com.proyecto.nuevoproyecto;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.annotation.Resource;

import javax.sql.DataSource;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion extends HttpServlet {

    private static final long serialVersionUID = 1L;

    //establecer el datasource
    @Resource(name = "jdbc/proyectojsp")
    private DataSource miPool;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        //Crear la conexion de BBDD
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = miPool.getConnection();
            st = cn.createStatement();
            String sql = "select * from usuarios";

            rs = st.executeQuery(sql);

            while (rs.next()) {

                String nombre = rs.getString("nombre");
                out.println("<h2>" + nombre + "</h2>");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
