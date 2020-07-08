package cl.awakelab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.awakelab.conexion.Conexion;
import cl.awakelab.dao.ClientesDAO;
import cl.awakelab.model.Cliente;

/**
 * Servlet implementation class ActualizarUsuario
 */
@WebServlet("/ActualizarCliente")
public class ActualizarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ClientesDAO clientesDAO;
	
	 public void init() {
		 
		 String url = getServletContext().getInitParameter("jdbcURL");
	     String username = getServletContext().getInitParameter("jdbcUsername");
	     String password = getServletContext().getInitParameter("jdbcPassword");
	      
	     Conexion conexion = Conexion.getInstance(url, username, password);
	     
	     clientesDAO = new ClientesDAO(conexion);
	         
	 }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
		
		Cliente user = new Cliente();
		user = (Cliente) clientesDAO.buscarIdCliente(idCliente);
		
		request.setAttribute("datosusuario", user);
		request.getRequestDispatcher("/Forms/FormClienteEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		int idCliente = Integer.parseInt(request.getParameter("hdnidusuario"));

		Cliente user = new Cliente(idCliente, nombre, usuario, password);
		
		boolean editar = clientesDAO.actualizarRegistro(user);
		
		String mensaje = "";
		
		if (editar)
			mensaje = "El usuario se ha editado exitosamente";
		else
			mensaje = "Ocurrió un error al editar el usuario";

		request.setAttribute("datosusuario", user);
		request.setAttribute("confirm", mensaje);
		request.getRequestDispatcher("/Forms/FormCliente.jsp").forward(request, response);
		
	}

}
