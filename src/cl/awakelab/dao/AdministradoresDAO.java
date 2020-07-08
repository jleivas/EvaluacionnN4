package cl.awakelab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.awakelab.conexion.Conexion;
import cl.awakelab.idao.IAdministradoresDAO;
import cl.awakelab.model.Administrador;

public class AdministradoresDAO implements IAdministradoresDAO{

private Conexion conexion;
	
	public AdministradoresDAO(Conexion conexion) {
		this.conexion = conexion;
	}
	

	@Override
	public boolean agregarRegistro(Object objeto) {
		// TODO Auto-generated method stub
		boolean registroAgregado = false;
		
		Connection con = conexion.conectar();
	
			try {
				String sql = "INSERT INTO administradores (nombre, usuario, password) VALUES  (?, ?, ?)";
				
				Administrador admin= (Administrador) objeto;
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, admin.getNombre());
				st.setString(2, admin.getUsuario());
				st.setString(3, admin.getPassword());
				
				registroAgregado = st.executeUpdate() > 0;
			} catch (SQLException e){
				System.out.println("Error: Clase AdmintradoresDAO / Método agregarRegistro");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		
		
		return registroAgregado;
	}

	@Override
	public List<Object> mostrarRegistros() {
		// TODO Auto-generated method stub
		List<Object> admins = null;
		
		Connection con = conexion.conectar();
		
		if (con != null) {
			try {
				String sql = "SELECT idAdmin, nombre, usuario FROM administradores ORDER BY idAdmin";
				
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				
				admins = new ArrayList<>();
				
				while (rs.next()) {
					Administrador a = new Administrador();
					a.setIdAdmin(rs.getInt("idAdmin"));
					a.setNombre(rs.getString("nombre"));
					a.setUsuario(rs.getString("usuario"));
					
					admins.add(a);
				} 
			} catch (SQLException e) {
				System.out.println("Error: Clase AdministradoresDAO / Método mostrarRegistros");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		}

		return admins;
	}

	@Override
	public boolean actualizarRegistro(Object objeto) {
		// TODO Auto-generated method stub
		boolean registroActualizado = false;
		
		Connection con = conexion.conectar();
		
		if (con != null) {
			try {
				String sql = "UPDATE administradores SET nombre = ? WHERE idAdmin = ?";
				
				Administrador admin = (Administrador) objeto;
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, admin.getNombre());
				
				registroActualizado = st.executeUpdate() > 0;
			} catch (SQLException e) {
				System.out.println("Error: Clase AdministradoresDAO / Método actualizarRegistro");
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
				String sql = "DELETE FROM administrador WHERE idAdmin = ?";
				
				Administrador admin = (Administrador) objeto;
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setInt(1, admin.getIdAdmin());
				
				registroEliminado = st.executeUpdate() > 0;
			} catch (SQLException e) {
				System.out.println("Error: Clase AdministradoresDAO / Método eliminarRegistro");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		}
		return registroEliminado;
	}


	@Override
	public Administrador buscarUsuario(String usuario) {
		
		Administrador a = null;
		
		Connection con = conexion.conectar();
		if (con != null) {
			try {
				String sql = "SELECT idAdmin, usuario, nombre, password FROM administradores WHERE usuario = ?";
				
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, usuario);
				ResultSet rs = st.executeQuery();
				
				while (rs.next()) {
					a = new Administrador();
					
					a.setIdAdmin(rs.getInt("idAdmin"));
					a.setUsuario(rs.getString("usuario"));
					a.setNombre(rs.getString("nombre"));
					a.setPassword(rs.getString("password"));
				} 
			} catch (SQLException e) {
				System.out.println("Error: Clase AdministradoresDAO / Método buscarRegistros");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		}

		return a;
		
	}
}
