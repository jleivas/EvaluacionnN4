package cl.awakelab.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.awakelab.conexion.Conexion;
import cl.awakelab.dao.ActividadesDAO;

/**
 * Servlet implementation class VisActividades
 */
@WebServlet("/ActividadesController")
public class ActividadesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ActividadesDAO actsDAO;
	
	
	public void init() {
		 
		 String url = getServletContext().getInitParameter("jdbcURL");
	     String username = getServletContext().getInitParameter("jdbcUsername");
	     String password = getServletContext().getInitParameter("jdbcPassword");
	      
	     Conexion conexion = Conexion.getInstance(url, username, password);
	     
	     actsDAO = new ActividadesDAO(conexion);
	         
	 }
	 
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActividadesController() {
        super();
        
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
            case "mostrarRegistros":
                mostrarRegistros(request, response);
                break;    
            default:
                break;
            }

        } catch (Exception e) {
        	System.out.println("Error: Servlet ActividadesController / Método DoGet");
            e.getStackTrace();
        }
	}

	private void mostrarRegistros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Object> listadoActividades = actsDAO.mostrarRegistros();
        request.setAttribute("listadoActividades", listadoActividades);
        request.getRequestDispatcher("/PanelAdmin/VisualizarActividades.jsp").forward(request, response);

		
	}

	private void index(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

}
