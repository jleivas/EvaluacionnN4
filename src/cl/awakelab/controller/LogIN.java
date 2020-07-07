package cl.awakelab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import cl.awakelab.conexion.Conexion;
import cl.awakelab.dao.AdministradoresDAO;
import cl.awakelab.model.Administrador;

/**
 * Servlet implementation class LogIN
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AdministradoresDAO administradoresDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
    
   // private static final void home(HttpServletRequest request, HttpServletResponse response) {
    //	HttpSession session = request.getSession();
    	
    	//String usuario = request.getParameter("usuario");
    	//String password = request.getParameter("password"); 
    	
    	//session.setAttribute("usuario", usuario);
    	//session.setAttribute("pass", password);
    //}
    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/Vista/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String usuario = request.getParameter("usuario");
    	String password = request.getParameter("password"); 
    	
    	Administrador admin = administradoresDAO.buscarUsuario(usuario);
    	String clave = admin.getPassword();
    	
    	if (admin != null && clave.equals(password)) {
    		int id = admin.getIdAdmin();
    		session.setAttribute("loggedIn", true);
    		session.setAttribute("id", id);
    		System.out.println("NO ENCUENTRO LA WEAAA");
    		response.sendRedirect(request.getContextPath() + "/Panel/AdminPanel.jsp");
    		
    	} else {
    		String error = "Usuario y/o Contraseña no válida";
    		
    		request.setAttribute("error", error);
    		request.setAttribute("usuario", usuario);
    		
    		request.getRequestDispatcher("/WEB-INF/Vista/home.jsp").forward(request, response);
    	}
    	
	}

}
