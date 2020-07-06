package cl.awakelab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import cl.awakelab.conexion.Conexion;
import cl.awakelab.idao.IUsuariosDAO;
import cl.awakelab.model.Usuario;

public class UsuariosDAO implements IUsuariosDAO{

	private Conexion conexion;
	
	public UsuariosDAO(Conexion conexion) {
		this.conexion = conexion;
	}
	

	@Override
	public boolean agregarRegistro(Object objeto) {
		// TODO Auto-generated method stub
		boolean registroAgregado = false;
		
		Connection con = conexion.conectar();
		
		
			try {
				String sql = "INSERT INTO usuarios (usuario, contraseña) VALUES  (?, ?)";
				
				Usuario usuario = (Usuario) objeto;
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, usuario.getUsuario());
				st.setString(2, usuario.getContraseña());
				
				registroAgregado = st.executeUpdate() > 0;
			} catch (SQLException e){
				System.out.println("Error: Clase UsuariosDAO / Método agregarRegistro");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		
		
		return registroAgregado;
	}

	@Override
	public List<Object> mostrarRegistros() {
		// TODO Auto-generated method stub
		List<Object> usuarios = null;
		
		Connection con = conexion.conectar();
		
		if (con != null) {
			try {
				String sql = "SELECT idUser, usuario FROM usuarios ORDER BY idUser";
				
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				
				usuarios = new ArrayList<>();
				
				while (rs.next()) {
					Usuario u = new Usuario();
					u.setIdUser(rs.getInt("idUser"));
					u.setUsuario(rs.getString("usuario"));
					u.setContraseña(rs.getString("contraseña"));
					usuarios.add(u);
				} 
			} catch (SQLException e) {
				System.out.println("Error: Clase UsuariosDAO / Método mostrarRegistros");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		}

		return usuarios;
	}

	@Override
	public boolean actualizarRegistro(Object objeto) {
		// TODO Auto-generated method stub
		boolean registroActualizado = false;
		
		Connection con = conexion.conectar();
		
		if (con != null) {
			try {
				String sql = "UPDATE usuarios SET usuario = ?, contraseña = ? WHERE idUser = ?";
				
				Usuario usuario = (Usuario) objeto;
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, usuario.getUsuario());
				st.setString(2, usuario.getContraseña());
				
				registroActualizado = st.executeUpdate() > 0;
			} catch (SQLException e) {
				System.out.println("Error: Clase UsuariosDAO / Método actualizarRegistro");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		}
		return registroActualizado;
	}

	@Override
	public boolean eliminarRegistro(Object objeto) {
		// TODO Auto-generated method stub
		boolean registroEliminado = false;
		
		Connection con = conexion.conectar();
		
		if (con != null) {
			try {
				String sql = "DELETE FROM usuarios WHERE idUser = ?";
				
				Usuario usuario = (Usuario) objeto;
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setInt(1, usuario.getIdUser());
				
				registroEliminado = st.executeUpdate() > 0;
			} catch (SQLException e) {
				System.out.println("Error: Clase UsuariosDAO / Método eliminarRegistro");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		}
		return registroEliminado;
	}

	
}
