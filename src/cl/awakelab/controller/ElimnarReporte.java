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
 * Servlet implementation class ElimnarReporte
 */
@WebServlet("/ElimnarReporte")
public class ElimnarReporte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CrearReporteAccDAO accDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElimnarReporte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int idAccidente = Integer.parseInt(request.getParameter(""));
	Accidente accidente = new Accidente();
	accidente.setIdAccidente(idAccidente);
	boolean eliminar = accDao.eliminarReporte(accidente);
	List<Accidente> listEliminar = new ArrayList<Accidente>();
	listEliminar = accDao.misAccidentes();
	String mensaje = "";
	if(eliminar) {
		mensaje = "Reporte Eliminado";
	}else {
		mensaje = "Error al eliminar el reporte";
	}
	request.setAttribute("pitiao", mensaje);
	request.setAttribute("elNuevo", listEliminar);
	request.getRequestDispatcher(".jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
