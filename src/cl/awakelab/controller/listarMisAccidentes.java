package cl.awakelab.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.awakelab.dao.CrearReporteAccDAO;
import cl.awakelab.model.Accidente;

/**
 * Servlet implementation class listarMisAccidentes
 */
@WebServlet("/listarMisAccidentes")
public class listarMisAccidentes extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public listarMisAccidentes() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CrearReporteAccDAO rep = new CrearReporteAccDAO();
		List<Accidente> lMisAccidentes = new ArrayList<Accidente>();
		
		lMisAccidentes = rep.misAccidentes();
		
		request.setAttribute("mAccidentes", lMisAccidentes);
		request.getRequestDispatcher("listaReporte.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
