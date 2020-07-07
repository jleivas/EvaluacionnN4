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
				String sql = "INSERT INTO administradores (nombre) VALUES  (?)";
				
				Administrador admin= (Administrador) objeto;
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, admin.getNombre());
				
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
				String sql = "SELECT idUser, usuario, nombre FROM usuarios, administradores ORDER BY idUser";
				
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				
				admins = new ArrayList<>();
				
				while (rs.next()) {
					Administrador a = new Administrador();
					a.setIdUser(rs.getInt("idUser"));
					a.setUsuario(rs.getString("usuario"));
					a.setNombre(rs.getString("nombre"));
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
				System.out.println("Error: Clase AdministradorDAO / Método actualizarRegistro");
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
				
				st.setInt(1, admin.getIdUser());
				
				registroEliminado = st.executeUpdate() > 0;
			} catch (SQLException e) {
				System.out.println("Error: Clase AdministradorDAO / Método eliminarRegistro");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		}
		return registroEliminado;
	}


	@Override
	public List<Object> buscarUsuario(String usuario) {
		
		List<Object> admins = null;
		
		Connection con = conexion.conectar();
		if (con != null) {
			try {
				String sql = "SELECT idUser, usuario, nombre FROM usuarios, administradores WHERE usuario = ?";
				
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				
				admins = new ArrayList<>();
				
				while (rs.next()) {
					Administrador a = new Administrador();
					a.setIdUser(rs.getInt("idUser"));
					a.setUsuario(rs.getString("usuario"));
					a.setNombre(rs.getString("nombre"));
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
}
