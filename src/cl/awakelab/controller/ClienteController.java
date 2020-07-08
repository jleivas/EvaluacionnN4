package cl.awakelab.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
import cl.awakelab.model.Profesional;
/**
 * Servlet implementation class CreacionUsuario
 */
@WebServlet("/ClienteController")
public class ClienteController extends HttpServlet {
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
    public ClienteController() {
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
                request.getRequestDispatcher("/Forms/FormCliente.jsp").forward(request, response);
                break;      
            default:
                break;
            }

        } catch (Exception e) {
        	System.out.println("Error: Servlet ClienteController / Método DoGet");
            e.getStackTrace();
        }

    }


	private void eliminarRegistro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
		Cliente user = new Cliente();
		user.setIdCliente(idCliente);
		System.out.println(user);
		System.out.println(idCliente);
		
		boolean elimino = clientesDAO.eliminarRegistro(user);
		
		List<Object> listadoeliminar = clientesDAO.mostrarRegistros();
		
		String mensaje = "";
		
		if (elimino)
			mensaje = "El cliente ha sido eliminado exitosamente";
		else
			mensaje = "Ocurrió un problema al eliminar al cliente";
		request.setAttribute("confirm", mensaje);
		request.setAttribute("listadoClientes", listadoeliminar);
		request.getRequestDispatcher("/PanelAdmin/ListarClientes.jsp").forward(request, response);

		
	}

	private void mostrarRegistros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			List<Object> listadoClientes = clientesDAO.mostrarRegistros();
	        request.setAttribute("listadoClientes", listadoClientes);
	        request.getRequestDispatcher("/PanelAdmin/ListarClientes.jsp").forward(request, response);
		
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
		request.getRequestDispatcher("/Home.jsp").forward(request, response);
		
		
		
	}

}
