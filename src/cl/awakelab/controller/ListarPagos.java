package cl.awakelab.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.awakelab.dao.PagosDAO;
import cl.awakelab.model.Pagos;

/**
 * Servlet implementation class ListarPagos
 */
@WebServlet("/ListarPagos")
public class ListarPagos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PagosDAO pagosDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarPagos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Pagos> listPago =new ArrayList<Pagos>();
		
		listPago = pagosDao.lPagos();
		
		request.setAttribute("listpago", listPago);
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
