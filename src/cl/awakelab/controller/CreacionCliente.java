package cl.awakelab.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.awakelab.conexion.Conexion;
import cl.awakelab.dao.ClientesDAO;
import cl.awakelab.model.Cliente;
/**
 * Servlet implementation class CreacionUsuario
 */
@WebServlet("/CreacionCliente")
public class CreacionCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ClientesDAO clientesDAO;
	
	 public void init() {
		 
		 String url = getServletContext().getInitParameter("jdbcURL");
	     String username = getServletContext().getInitParameter("jdbcUsername");
	     String password = getServletContext().getInitParameter("jdbcPassword");
	      
	     Conexion conexion = Conexion.getInstance(url, username, password);
	     
	     clientesDAO = new ClientesDAO(conexion);
	         
	 }
	 
	// private static final void panel(HttpServletRequest request, HttpServletResponse response) {
		// HttpSession session = request.getSession();
		 
		 
	// }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreacionCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
        try {
            switch (action) {
            case "index":
                index(request, response);
                break;
            case "MostrarPorID":
                break;
            case "mostrarRegistros":
                mostrarRegistros(request, response);
                break;
            default:
                break;
            }

        } catch (Exception e) {
        	System.out.println("Error: Servlet CreacionCliente / Método DoGet");
            e.getStackTrace();
        }

    }
	
	private void mostrarRegistros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 List<Object> listadoClientes = clientesDAO.mostrarRegistros();
	        request.setAttribute("lista", listadoClientes);
	        request.getRequestDispatcher("ListarClientes.jsp").forward(request, response);
		
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		Cliente user = new Cliente(nombre, usuario, password);
		
		boolean agregar = clientesDAO.agregarRegistro(user);
		
		String mensaje = "";
		
		if (agregar)
			mensaje = "Cliente creado exitosamente";
		else
			mensaje = "Ocurrió un error al crear el cliente";
		
		request.setAttribute("confirm", mensaje);
		request.getRequestDispatcher("/WEB-INF/Vista/FormAdmin.jsp").forward(request, response);
		
		
		
	}

}
