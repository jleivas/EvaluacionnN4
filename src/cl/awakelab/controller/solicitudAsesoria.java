package cl.awakelab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.awakelab.dao.AsesoriaEspecialDAO;
import cl.awakelab.model.Asesoria;

/**
 * Servlet implementation class solicitudAsesoria
 */
@WebServlet("/solicitudAsesoria")
public class solicitudAsesoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public solicitudAsesoria() {
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
		String tipoAsesoria = request.getParameter("textTipo");
		String fechaAsesoria = request.getParameter("textFecha");
				
			Asesoria peticion = new Asesoria(tipoAsesoria,fechaAsesoria);
			AsesoriaEspecialDAO AEDAO = new AsesoriaEspecialDAO();
			boolean solicitar = AEDAO.solicitarAsesoria(peticion);
			String mensaje = "";
			if (solicitar == true) {
				mensaje = "solicitud enviada";
				
			}else {
				mensaje = "error";
			}
		request.setAttribute("enviarMensaje", mensaje);	
		request.getRequestDispatcher(".jsp").forward(request, response);
		
	}

}
