package cl.awakelab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.awakelab.conexion.Conexion;
import cl.awakelab.dao.ProfesionalesDAO;
import cl.awakelab.model.Profesional;
/**
 * Servlet implementation class CreacionUsuario
 */
@WebServlet("/ProfesionalController")
public class ProfesionalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProfesionalesDAO profsDAO;
	
	 public void init() {
		 
		 String url = getServletContext().getInitParameter("jdbcURL");
	     String username = getServletContext().getInitParameter("jdbcUsername");
	     String password = getServletContext().getInitParameter("jdbcPassword");
	      
	     Conexion conexion = Conexion.getInstance(url, username, password);
	     
	     profsDAO = new ProfesionalesDAO(conexion);
	         
	 }
	 
	// private static final void panel(HttpServletRequest request, HttpServletResponse response) {
		// HttpSession session = request.getSession();
		 
		 
	// }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfesionalController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
        try {
            switch (action) {
            case "index":
                index(request, response);
                break;
            case "eliminarRegistro":
            	eliminarRegistro(request, response);
            	break;
            case "mostrarRegistros":
                mostrarRegistros(request, response);
                break;
            case "agregarRegistro":
                request.getRequestDispatcher("/Forms/FormProf.jsp").forward(request, response);
                break;      
            default:
                break;
            }

        } catch (Exception e) {
        	System.out.println("Error: Servlet ProfesionalController / Método DoGet");
            e.getStackTrace();
        }

	}


	private void eliminarRegistro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idProf = Integer.parseInt(request.getParameter("idProf"));
		Profesional user = new Profesional();
		user.setIdProf(idProf);
		System.out.println(user);
		System.out.println(idProf);
		
		boolean elimino = profsDAO.eliminarRegistro(user);
		
		List<Object> listadoeliminar = profsDAO.mostrarRegistros();
		
		String mensaje = "";
		
		if (elimino)
			mensaje = "El profesional ha sido eliminado exitosamente";
		else
			mensaje = "Ocurrió un problema al eliminar al profesional";
		request.setAttribute("confirm", mensaje);
		request.setAttribute("listadoProfesionales", listadoeliminar);
		request.getRequestDispatcher("/PanelAdmin/ListarProfesionales.jsp").forward(request, response);
		
	}

	private void mostrarRegistros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Object> listadoProfesionales = profsDAO.mostrarRegistros();
        request.setAttribute("listadoProfesionales", listadoProfesionales);
        request.getRequestDispatcher("/PanelAdmin/ListarProfesionales.jsp").forward(request, response);

		
	}

		
	

	private void index(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		Profesional user = new Profesional(nombre, password, usuario);
		
		boolean agregar = profsDAO.agregarRegistro(user);
		
		String mensaje = "";
		
		if (agregar)
			mensaje = "Profesional creado exitosamente";
		else
			mensaje = "Ocurrió un error al crear el profesional";
		
		request.setAttribute("confirm", mensaje);
		request.getRequestDispatcher("/Forms/FormProf.jsp").forward(request, response);
		
		
		
	}

}
