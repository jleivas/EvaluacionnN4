package cl.awakelab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.awakelab.dao.CrearReporteAccDAO;
import cl.awakelab.model.Accidente;

/**
 * Servlet implementation class CrearReporte
 */
@WebServlet("/CrearReporte")
public class CrearReporte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearReporte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fechaAccidente = request.getParameter("");
		String tipoAccidente = request.getParameter("");
		
		Accidente accidente = new Accidente();
		CrearReporteAccDAO accidenteDao = new CrearReporteAccDAO();
		boolean agregarRep = accidenteDao.CrearReporte(accidente);
		String mensaje = "";
		if(agregarRep) {
			mensaje = "Reporte creado";
		}else {
			mensaje ="Error al crear el reporte";
		}
		request.setAttribute("elMensaje", mensaje);
		request.getRequestDispatcher(".jsp").forward(request, response);
	}

}
