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
import cl.awakelab.dao.AdministradoresDAO;
import cl.awakelab.dao.UsuariosDAO;
import cl.awakelab.model.Administrador;

/**
 * Servlet implementation class LogIN
 */
@WebServlet("/LogIN")
public class LogIN extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AdministradoresDAO administradoresDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIN() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
		 
		 String url = getServletContext().getInitParameter("jdbcURL");
	     String username = getServletContext().getInitParameter("jdbcUsername");
	     String password = getServletContext().getInitParameter("jdbcPassword");
	      
	     Conexion conexion = Conexion.getInstance(url, username, password);
	     
	     administradoresDAO = new AdministradoresDAO(conexion);
	         
	 }
    
    private static final void home(HttpServletRequest request, HttpServletResponse response) {
    	HttpSession session = request.getSession();
    	
    	String usuario = request.getParameter("usuario");
    	String password = request.getParameter("password"); 
    	
    	session.setAttribute("usuario", usuario);
    	session.setAttribute("pass", password);
    }
    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String usuario = request.getParameter("usuario");
    	String password = request.getParameter("password"); 
    	
    	List<Object> admin = administradoresDAO.buscarUsuario(usuario);
    	
    	
    	
	}

}
