package cl.awakelab.controller;

import java.io.IOException;
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
@WebServlet("/CreacionProf")
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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/Vista/FormProf.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		Profesional user = new Profesional(nombre, usuario, password);
		
		boolean agregar = profsDAO.agregarRegistro(user);
		
		String mensaje = "";
		
		if (agregar)
			mensaje = "Profesional creado exitosamente";
		else
			mensaje = "Ocurrió un error al crear el profesional";
		
		request.setAttribute("confirm", mensaje);
		request.getRequestDispatcher("/WEB-INF/Vista/FormProf.jsp").forward(request, response);
		
		
		
	}

}
