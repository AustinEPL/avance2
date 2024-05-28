package Controllers;

import com.proyecto.nuevoproyecto.Canchas;
import com.proyecto.nuevoproyecto.CanchasDao;
import com.proyecto.nuevoproyecto.UsuarioAdmin;
import com.proyecto.nuevoproyecto.UsuarioAdminDao;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

@MultipartConfig
public class panelAdminstracionControlador extends HttpServlet {

    private CanchasDao modelo;
    private UsuarioAdminDao modeloAdmin;

    //Para conectar a la bbdd
    @Resource(name = "jdbc/futbol")
    private DataSource miPool;


    @Override
    public void init() throws ServletException {

        super.init();
        try {
            modelo = new CanchasDao(miPool);
            modeloAdmin = new UsuarioAdminDao(miPool);

        } catch (Exception e) {
            throw new ServletException(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("existe") == null) {
            // No hay sesión, redirigir al servlet de inicio de sesión
            resp.sendRedirect("/nuevoProyecto/login");
            return; // Detener la ejecución del método para evitar procesar la solicitud sin una sesión válida
        }

        String ruta = req.getPathInfo();
        if (ruta == null) {
            ruta = "/";
        }
        System.out.println("Ruta inicial " + ruta);


        if (ruta.equalsIgnoreCase("/")) {


            String parametro = req.getParameter("instruccion");
            //verifiar si hay session

            if (parametro == null) {
                parametro = "listar";
            }

            switch (parametro) {
                case "listar":
                    listarCanchas(req, resp);
                    break;
                case "hola":
                    break;
            }


        } else if (ruta.equalsIgnoreCase("/actualizar") || ruta.equalsIgnoreCase("/actualizarCancha.jsp")) {

            String id = req.getParameter("id");
            if (id == null) {
                resp.sendRedirect("/nuevoProyecto/panel");

            } else {
                int idd = Integer.parseInt(id);
                Canchas cancha = modelo.obtenerCancha(idd);
                req.setAttribute("cancha", cancha);

                RequestDispatcher rd = req.getRequestDispatcher("/actualizarCancha.jsp");
                rd.forward(req, resp);

            }
        } else if (ruta.equalsIgnoreCase("/registrar") || ruta.equalsIgnoreCase("/registrarAdmin.jsp")) {

            RequestDispatcher rd = req.getRequestDispatcher("/registrarAdmin.jsp");
            rd.forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Recuperamos la ruta
        String ruta = req.getPathInfo();
        if (ruta == null) {
            ruta = "/";
        }
        System.out.println("Ruta inicial " + ruta);

        if (ruta.equalsIgnoreCase("/")) {
            System.out.println("La ruta es la raiz" + ruta);


            String parametro = req.getParameter("instruccion");
            System.out.println(parametro);
            if (parametro == null) {
                parametro = "listar";
            }

            switch (parametro) {
                case "listar":
                    break;
                case "aniadir":
                    aniadir(req, resp);
                    break;
                case "aniadirCancha":
                    aniadirCancha(req, resp);
                    break;
                //no utilizado porque este se ejecuta en otra ruta /panel/actualizar
                case "actualizarCancha":
                    actualizarcancha(req, resp);
                    break;
                case "eliminarCancha":
                    eliminar(req, resp);
                    break;
                case "actualizar":
                    actualizar(req, resp);
                    break;

            }
        } else if (ruta.equalsIgnoreCase("/actualizar") || ruta.equalsIgnoreCase("/actualizarCancha.jsp")) {
            String parametro = req.getParameter("instruccion");
            if (parametro == null) {
                parametro = "listar";
            }

            switch (parametro) {
                case "actualizarCancha":
                    int id = Integer.parseInt(req.getParameter("id"));
                    Canchas cancha = modelo.obtenerCancha(id);
                    req.setAttribute("cancha", cancha);
                    RequestDispatcher rd = req.getRequestDispatcher("/actualizarCancha.jsp");
                    rd.forward(req, resp);
                    break;

                case "actualizar":
                    actualizar(req, resp);
                    break;
            }

        } else if (ruta.equalsIgnoreCase("/registrar") || ruta.equalsIgnoreCase("/registrarAdmin.jsp")) {

            String parametro = req.getParameter("instruccion");
            if (parametro == null) {
                parametro = "listar";
            }

            switch (parametro) {
                case "registrarA":
                    registrarTrabajador(req, resp);
                    break;

                case "actualizar":
                    actualizar(req, resp);
                    break;
            }
        }

    }

    private void registrarTrabajador(HttpServletRequest req, HttpServletResponse resp) {

        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellidos");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int dni = Integer.parseInt(req.getParameter("dni"));
        int celular = Integer.parseInt(req.getParameter("celular"));
        String cargo = req.getParameter("cargo");

        //creamos el objeto UsuarioAdmin
        UsuarioAdmin temp= new UsuarioAdmin(nombre,apellido,email,password,dni,celular,cargo);
        //enivamos al modelo
        try {
            modeloAdmin.aniadirTrabajador(temp);
            resp.sendRedirect("/nuevoProyecto/panel");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private void actualizar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Recuperar los valores y almacenarlos para enviarlo al modelo
        int id = Integer.parseInt(req.getParameter("ida"));
        String nombre = req.getParameter("nombre");
        String direccion = req.getParameter("direccion");
        String horarioInicio = req.getParameter("horario-inicio");
        String horarioFin = req.getParameter("horario-fin");
        String horario = horarioInicio + " - " + horarioFin;
        double precio = Double.parseDouble(req.getParameter("precio"));
        int longitud = Integer.parseInt(req.getParameter("longitud"));
        int ancho = Integer.parseInt(req.getParameter("ancho"));
        int capacidad = Integer.parseInt(req.getParameter("capacidad"));
        String descripcion = req.getParameter("descripcion");
        String val = req.getParameter("rutaImagen");
        Part part = req.getPart("rutaImagen");
        String rutaImagen = Paths.get(part.getSubmittedFileName()).getFileName().toString();

        if (part != null && part.getSize() > 0) {
            //no se agrego una imagen entonces no actualziaremos el campo de la imagen
            Canchas actu = new Canchas(id, nombre, direccion, horario, precio, longitud, ancho, descripcion, capacidad, rutaImagen);
            modelo.actualizarConImagen(actu);
            try {
                resp.sendRedirect("/nuevoProyecto/panel");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            Canchas actu = new Canchas(id, nombre, direccion, horario, precio, longitud, ancho, descripcion, capacidad);
            modelo.actualizarSinImagen(actu);
            //volvemos a la pagina principal
            try {
                resp.sendRedirect("/nuevoProyecto/panel");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    //metodo sin uso
    private void actualizarcancha(HttpServletRequest req, HttpServletResponse resp) {

        int id = Integer.parseInt(req.getParameter("id"));
        //recuperamos la cancha a modificar
        Canchas cancha = modelo.obtenerCancha(id);
        //enviamos el objeto cancha al formulario para modificarlo
        req.setAttribute("cancha", cancha);
        //mostrar el formulario
//metodo sin uso

    }


    private void listarCanchas(HttpServletRequest req, HttpServletResponse resp) {
        //Obtener la lista de canchas
        List<Canchas> canchasLista;
        try {
            canchasLista = modelo.getCanchas();

            //agregar a la lista de reques
            req.setAttribute("canchas", canchasLista);

            //enviar al jsp
            RequestDispatcher rd = req.getRequestDispatcher("/gestionCanchas.jsp");
            rd.forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void aniadir(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.sendRedirect("/nuevoProyecto/vistaAniadirCancha.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {

        //recuperar el id para eliminar la cancha
        int id = Integer.parseInt(req.getParameter("id"));
        modelo.eliminar(id);

        try {
            resp.sendRedirect("/nuevoProyecto/panel");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    private void aniadirCancha(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String nombre = req.getParameter("nombre");
        String direccion = req.getParameter("direccion");
        String horarioInicio = req.getParameter("horario-inicio");
        String horarioFin = req.getParameter("horario-fin");
        String horario = horarioInicio + " - " + horarioFin;
        double precio = Double.parseDouble(req.getParameter("precio"));
        int longitud = Integer.parseInt(req.getParameter("longitud"));
        int ancho = Integer.parseInt(req.getParameter("ancho"));
        int capacidad = Integer.parseInt(req.getParameter("capacidad"));
        String descripcion = req.getParameter("descripcion");

        //debenmos almacenar el nombre de la imagen

        Part part = req.getPart("rutaImagen");
        String rutaImagen = Paths.get(part.getSubmittedFileName()).getFileName().toString();

        //String rutaImagen = new File(part.getSubmittedFileName()).getName();

        //Creamos la Cancha
        Canchas nueva = new Canchas(nombre, direccion, horario, precio, longitud, ancho, descripcion, capacidad, rutaImagen);
        //Enviar al modelo para añadirlo a la bbdd
        modelo.addCancha(nueva);
        //volver a listar los productos
        resp.sendRedirect("/nuevoProyecto/panel");

    }


}
