package cl.awakelab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.awakelab.conexion.Conexion;
import cl.awakelab.dao.ProfesionalesDAO;
import cl.awakelab.model.Profesional;

/**
 * Servlet implementation class ActualizarProfesional
 */
@WebServlet("/ActualizarProfesional")
public class ActualizarProfesional extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProfesionalesDAO profesionalesDAO;
	
	 public void init() {
		 
		 String url = getServletContext().getInitParameter("jdbcURL");
	     String username = getServletContext().getInitParameter("jdbcUsername");
	     String password = getServletContext().getInitParameter("jdbcPassword");
	      
	     Conexion conexion = Conexion.getInstance(url, username, password);
	     
	     profesionalesDAO = new ProfesionalesDAO(conexion);
	 }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarProfesional() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idProf = Integer.parseInt(request.getParameter("idProf"));
		
		Profesional user = new Profesional();
		user = (Profesional) profesionalesDAO.buscarIdProf(idProf);
		
		request.setAttribute("datosusuario", user);
		request.getRequestDispatcher("/Forms/FormrProfEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		int idProf = Integer.parseInt(request.getParameter("hdnidusuario"));

		Profesional user = new Profesional(idProf, nombre, usuario, password);
		
		boolean editar = profesionalesDAO.actualizarRegistro(user);
		
		String mensaje = "";
		
		if (editar)
			mensaje = "El usuario se ha editado exitosamente";
		else
			mensaje = "Ocurrió un error al editar el usuario";

		request.setAttribute("datosusuario", user);
		request.setAttribute("confirm", mensaje);
		request.getRequestDispatcher("/Forms/FormProf.jsp").forward(request, response);
	}

}
