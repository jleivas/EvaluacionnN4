package cl.awakelab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.awakelab.dao.PagosDAO;
import cl.awakelab.model.Pagos;

/**
 * Servlet implementation class PagarMonto
 */
@WebServlet("/PagarMonto")
public class PagarMonto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagarMonto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pagoid = Integer.parseInt(request.getParameter("idCliente"));
		
		PagosDAO PDAO = new PagosDAO();
		Pagos pago = new Pagos();
		pago = PDAO.obtenerPagos(pagoid);
		
		request.setAttribute("datosPago", pago);
		request.getRequestDispatcher(".jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int Monto = Integer.parseInt(request.getParameter("total"));
		int idcliente = Integer.parseInt(request.getParameter("idcliente"));
		
		Pagos  pago = new Pagos(idcliente, Monto); 
		PagosDAO pagar = new PagosDAO();
		boolean editPago = pagar.pagarTotal(pago);
		String mensaje = "";
		
		if(editPago) {
			mensaje = "Pago realizado exitosamente";
		}else {
			mensaje = "Error al procesar pago";
		}
		request.setAttribute("paga", pago);
		request.setAttribute("pmjs", mensaje);
		request.getRequestDispatcher(".jsp").forward(request, response);
	}

}
