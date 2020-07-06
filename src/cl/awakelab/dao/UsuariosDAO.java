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
				String sql = "INSERT INTO usuarios (usuario, contrase�a) VALUES  (?, ?)";
				
				Usuario usuario = (Usuario) objeto;
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, usuario.getUsuario());
				st.setString(2, usuario.getContrase�a());
				
				registroAgregado = st.executeUpdate() > 0;
			} catch (SQLException e){
				System.out.println("Error: Clase UsuariosDAO / M�todo agregarRegistro");
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
					u.setContrase�a(rs.getString("contrase�a"));
					usuarios.add(u);
				} 
			} catch (SQLException e) {
				System.out.println("Error: Clase UsuariosDAO / M�todo mostrarRegistros");
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
				String sql = "UPDATE usuarios SET usuario = ?, contrase�a = ? WHERE idUser = ?";
				
				Usuario usuario = (Usuario) objeto;
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, usuario.getUsuario());
				st.setString(2, usuario.getContrase�a());
				
				registroActualizado = st.executeUpdate() > 0;
			} catch (SQLException e) {
				System.out.println("Error: Clase UsuariosDAO / M�todo actualizarRegistro");
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
				System.out.println("Error: Clase UsuariosDAO / M�todo eliminarRegistro");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		}
		return registroEliminado;
	}

	
}
