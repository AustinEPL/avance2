package Controllers;

import com.proyecto.nuevoproyecto.*;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.PasswordHasher;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class LoginController extends HttpServlet {
    //Para comunicarnos con el Modelo debemos crear su objeto
    private UsuarioAdminDao admin;

    //Para conectar a la bbdd
    @Resource(name = "jdbc/futbol")
    private DataSource miPool;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            //Pasamos los parametros de configuracion para la conexion a la bbdd
            admin = new UsuarioAdminDao(miPool);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parametro = req.getParameter("instruccion");

        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("existe") != null) {

            // RequestDispatcher rd = req.getRequestDispatcher("/gestionCanchas.jsp");
            // rd.forward(req, resp);

            resp.sendRedirect("panel");
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
            rd.forward(req, resp);
        }


        if (parametro == null) {
            parametro = "listar";
        }

        switch (parametro) {

            case "listar":
                listarAdmins(req, resp);
                break;
            case "insertar":
                insertarAdmin(req, resp);
                break;
            case "autenticar":
                auth(req, resp);
            case "mostrarLogin":
                mostrarLogin(req, resp);
                break;
            case "cerrar_sesion":
                cerrarSesion(req, resp);
                break;
        }

    }

    private void cerrarSesion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        session.invalidate();
        //Lo redireccionamos a la pantalla de login
        resp.sendRedirect("/nuevoProyecto/login");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String parametro = req.getParameter("instruccion");

        if (parametro == null) {
            parametro = "mostrarLogin";
        }

        switch (parametro) {
            case "mostrarLogin":
                mostrarLogin(req, resp);
                break;
            case "autenticar":
                auth(req, resp);
                break;
            case "gestionarCancha":
                mostrarPanel(req, resp);
                break;
            case "cerrar_sesion":
                cerrarSesion(req, resp);
                break;
        }


    }

    private void mostrarPanel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("gestionando", "hola");
        //enviar al jsp
        RequestDispatcher rd = req.getRequestDispatcher("/vistaAniadirCancha.jsp");
        rd.forward(req, resp);
    }

    //Realizamos la autenticacion del amdinistrador
    private void auth(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        // String password= PasswordHasher.Hashing(req.getParameter("password"));
        String password = req.getParameter("password");
        //Creamos el objeto
        UsuarioAdmin ua = new UsuarioAdmin(email, password);
        //recibimos la respuesta
        UsuarioAdmin uAdmin = admin.auth(ua);
        //Enviar al momelo mi us y pass
        if (uAdmin != null) {

            HttpSession session = req.getSession(true);
            session.setAttribute("admin", uAdmin);
            session.setAttribute("existe", true);

            resp.sendRedirect("/nuevoProyecto/panel");

            //enviamos a la pagina principal

        } else {
            //que siga intentando
            RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
            rd.forward(req, resp);
        }


    }

    private void listarAdmins(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void insertarAdmin(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void mostrarLogin(HttpServletRequest req, HttpServletResponse resp) {
        //Obtener la lista de canchas
        List<Canchas> canchasLista;
        try {
            RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
            rd.forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
