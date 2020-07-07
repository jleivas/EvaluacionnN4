package cl.awakelab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.awakelab.dao.ClientesDAO;
import cl.awakelab.dao.ProfesionalesDAO;

/**
 * Servlet implementation class VisActividades
 */
@WebServlet("/VisActividades")
public class ActividadesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ClientesDAO clientesDAO;
	ProfesionalesDAO profsDAO;
	
	
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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String buscado = request.getParameter("buscar");
		
		
	}

}
