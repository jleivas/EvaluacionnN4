package cl.awakelab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.awakelab.dao.UsuariosDAO;
import cl.awakelab.model.Usuario;

/**
 * Servlet implementation class CreacionUsuario
 */
@WebServlet("/CreacionUsuario")
public class CreacionUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreacionUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/Vista/FormUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario = request.getParameter("usuario");
		String contraseña = request.getParameter("contraseña");
		
		Usuario user = new Usuario(usuario, contraseña);
		UsuariosDAO userDAO = new UsuariosDAO(null);
		
		boolean agregar = userDAO.agregarRegistro(user);
		
		String mensaje = "";
		
		if (agregar)
			mensaje = "El usuario se ha creado exitosamente";
		else
			mensaje = "Ocurrió un error al crear el usuario";
		
		request.setAttribute("confirm", mensaje);
		request.getRequestDispatcher("FormUsuario.jsp").forward(request, response);
		
		
		
	}

}
