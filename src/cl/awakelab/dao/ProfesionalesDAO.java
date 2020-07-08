package cl.awakelab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.awakelab.conexion.Conexion;
import cl.awakelab.idao.IProfesionalesDAO;
import cl.awakelab.model.Profesional;

public class ProfesionalesDAO implements IProfesionalesDAO{

private Conexion conexion;
	
	public ProfesionalesDAO(Conexion conexion) {
		this.conexion = conexion;
	}
	

	@Override
	public boolean agregarRegistro(Object objeto) {
		// TODO Auto-generated method stub
		boolean registroAgregado = false;
		
		Connection con = conexion.conectar();
	
			try {
				String sql = "INSERT INTO profesionales (nombre, password, usuario) VALUES  (?, ?, ?)";
				
				Profesional prof= (Profesional) objeto;
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, prof.getNombre());
				st.setString(2, prof.getPassword());
				st.setString(3, prof.getUsuario());
				
				
				registroAgregado = st.executeUpdate() > 0;
			} catch (SQLException e){
				System.out.println("Error: Clase ProfesionalDAO / Método agregarRegistro");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		
		
		return registroAgregado;
	}

	@Override
	public List<Object> mostrarRegistros() {
		// TODO Auto-generated method stub
		List<Object> profs = null;
		
		Connection con = conexion.conectar();
		
		if (con != null) {
			try {
				String sql = "SELECT idProf, nombre, usuario FROM profesionales ORDER BY idProf";
				
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				
				profs = new ArrayList<>();
				
				while (rs.next()) {
					Profesional a = new Profesional();
					a.setIdProf(rs.getInt("idProf"));
					a.setNombre(rs.getString("nombre"));
					a.setUsuario(rs.getString("usuario"));
					
					profs.add(a);
				} 
			} catch (SQLException e) {
				System.out.println("Error: Clase ProfesionalesDAO / Método mostrarRegistros");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		}

		return profs;
	}

	@Override
	public boolean actualizarRegistro(Object objeto) {
		// TODO Auto-generated method stub
		boolean registroActualizado = false;
		
		Connection con = conexion.conectar();
		
		if (con != null) {
			try {
				String sql = "UPDATE profesionales SET nombre = ? WHERE idProf = ?";
				
				Profesional prof = (Profesional) objeto;
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, prof.getNombre());
				
				registroActualizado = st.executeUpdate() > 0;
			} catch (SQLException e) {
				System.out.println("Error: Clase ProfesionalesDAO / Método actualizarRegistro");
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
				String sql = "DELETE FROM profesional WHERE idProf = ?";
				
				Profesional prof = (Profesional) objeto;
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setInt(1, prof.getIdProf());
				
				registroEliminado = st.executeUpdate() > 0;
			} catch (SQLException e) {
				System.out.println("Error: Clase ProfesionalesDAO / Método eliminarRegistro");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		}
		return registroEliminado;
	}


	@Override
	public Profesional buscarUsuario(String usuario) {
		
		Profesional p = null;
		
		Connection con = conexion.conectar();
		if (con != null) {
			try {
				String sql = "SELECT idProf, nombre, password, usuario FROM profesionales WHERE usuario = ?";
				
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, usuario);
				ResultSet rs = st.executeQuery();
				
				while (rs.next()) {
					p = new Profesional();
					p.setIdProf(rs.getInt("idProf"));
					p.setNombre(rs.getString("nombre"));
					p.setPassword(rs.getString("password"));
					p.setUsuario(rs.getString("usuario"));
				} 
			} catch (SQLException e) {
				System.out.println("Error: Clase ProfesionalesDAO / Método buscarRegistros");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		}

		return p;
		
	}


	@Override
	public Object buscarIdProf(int idProf) {
		Profesional p = null;
		
		Connection con = conexion.conectar();
		if (con != null) {
			try {
				String sql = "SELECT idProf, nombre, password, usuario FROM Profesionales WHERE idProf = ?";
				
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1, idProf);
				ResultSet rs = st.executeQuery();
				
				while (rs.next()) {
					p = new Profesional();
					p.setIdProf(rs.getInt("idProf"));
					p.setNombre(rs.getString("nombre"));
					p.setPassword(rs.getString("password"));
					p.setUsuario(rs.getString("usuario"));
				} 
			} catch (SQLException e) {
				System.out.println("Error: Clase ProfesionalesDAO / Método buscarIdProf");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		}

		return p;
	}
}
