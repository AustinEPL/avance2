package Controllers;

import com.proyecto.nuevoproyecto.*;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@MultipartConfig
public class ControladorCanchas extends HttpServlet {
    //Para comunicarnos con el Modelo debemos crear su objeto
    private CanchasDao canchaDao;

    //Para conectar a la bbdd
    @Resource(name = "jdbc/futbol")
    private DataSource miPool;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            canchaDao = new CanchasDao(miPool);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void listarCanchas(HttpServletRequest req, HttpServletResponse resp) {
        //Obtener la lista de canchas
        List<Canchas> canchasLista;
        try {
            canchasLista = canchaDao.getCanchas();

            //agregar a la lista de reques
            req.setAttribute("canchas", canchasLista);

            //enviar al jsp
            RequestDispatcher rd = req.getRequestDispatcher("/NuestrasCanchas.jsp");
            rd.forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String parametro = req.getParameter("instruccion");
        if (parametro == null) {
            parametro = "listarCanchas";
        }
        switch (parametro) {
            case "listarCanchas":
                listarCanchas(req, resp);
                break;
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parametro = req.getParameter("instruccion");

        if (parametro == null) {
            parametro = "listarCanchas";
        }

        switch (parametro) {
            case "listarCanchas":
                listarCanchas(req, resp);
                break;
            case "aniadirCancha":
                aniadirCancha(req, resp);
                break;
        }


    }
    private void aniadirCancha(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String nombre = req.getParameter("nombre");
        String direccion = req.getParameter("direccion");
        String horarioInicio = req.getParameter("horario-inicio");
        String horarioFin = req.getParameter("horario-fin");
        String horario = horarioInicio +" - "+horarioFin;
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
        canchaDao.addCancha(nueva);
        //volver a listar los productos
        resp.sendRedirect("/nuevoProyecto/panel");

    }



}
