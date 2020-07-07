package cl.awakelab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.awakelab.conexion.Conexion;
import cl.awakelab.idao.IActividadesDAO;
import cl.awakelab.model.Actividad;
import cl.awakelab.model.Cliente;

public class ActividadesDAO implements IActividadesDAO{

	private Conexion conexion;

	public ActividadesDAO (Conexion conexion) {
		this.conexion = conexion;
	}
	@Override
	public boolean agregarRegistro(Object objeto) {
		
		boolean registroAgregado = false;
		
		Connection con = conexion.conectar();
	
			try {
				String sql = "INSERT INTO actividades (nombre) VALUES  (?)";
				
				Actividad actividad = (Actividad) objeto;
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, actividad.getNombre());
				
				registroAgregado = st.executeUpdate() > 0;
			} catch (SQLException e){
				System.out.println("Error: Clase ActividadesDAO / Método agregarRegistro");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		
		
		return registroAgregado;
	}
	

	@Override
	public List<Object> mostrarRegistros() {
		List<Object> actividades = null;
		
		Connection con = conexion.conectar();
		
		if (con != null) {
			try {
				String sql = "SELECT idActividades,idCliente, idProf, idAsesoria, idRevision, nombre, precio, fechaVisita, situacionVisita nombre "
						+ "FROM actividades ORDER BY idActividades";
				
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				
				actividades = new ArrayList<>();
				
				while (rs.next()) {
					Actividad a = new Actividad();
					a.setIdActividad(rs.getInt("idActividad"));
					a.setIdCliente(rs.getInt("idCliente"));
					a.setIdProf(rs.getInt("idProf"));
					a.setIdAsesoria(rs.getInt("idAsesoria"));
					a.setIdRevision(rs.getInt("idRevision"));
					a.setNombre(rs.getString("nombre"));
					a.setPrecio(rs.getInt("precio"));
					a.setFechaVisita(rs.getString("fechaVisita"));
					a.setSituacionVisita(rs.getBoolean("situacionVisita"));
					actividades.add(a);
				} 
			} catch (SQLException e) {
				System.out.println("Error: Clase ActividadesDAO / Método mostrarRegistros");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		}

		return actividades;

	}

	@Override
	public boolean actualizarRegistro(Object objeto) {
		// TODO Auto-generated method stub
		boolean registroActualizado = false;
		
		Connection con = conexion.conectar();
		
		if (con != null) {
			try {
				String sql = "UPDATE actividades SET nombre = ? WHERE idActividad = ?";
				
				Actividad actividad = (Actividad) objeto;
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, actividad.getNombre());
				
				registroActualizado = st.executeUpdate() > 0;
			} catch (SQLException e) {
				System.out.println("Error: Clase ActividadesDAO / Método actualizarRegistro");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		}
		return registroActualizado;
	}

	@Override
	public boolean eliminarRegistro(Object objeto) {
		boolean registroEliminado = false;
		Connection con = conexion.conectar();
		
		if (con != null) {
			try {
				String sql = "DELETE FROM actividades WHERE idActividad = ?";
				
				Actividad actividad = (Actividad) objeto;
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setInt(1, actividad.getIdCliente());
				
				registroEliminado = st.executeUpdate() > 0;
			} catch (SQLException e) {
				System.out.println("Error: Clase ActividadesDAO / Método eliminarRegistro");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		}
		return registroEliminado;
	}


	@Override
	public boolean agregarCliente(Object objeto) {
		boolean clienteAgregado = false;
		
		Connection con = conexion.conectar();
	
			try {
				String sql = "INSERT INTO actividades (idCliente) VALUES  (?)";
				
				Actividad actividad = (Actividad) objeto;
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, actividad.getNombre());
				
				clienteAgregado = st.executeUpdate() > 0;
			} catch (SQLException e){
				System.out.println("Error: Clase ActividadesDAO / Método agregarRegistro");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		
		
		return clienteAgregado;
	}

	@Override
	public boolean agregarProfesional(Object objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean agregarAsesoria(Object objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean agregarRevision(Object objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Object> buscarActividadPorCliente(int idCliente) {
		
		List<Object> actividades = null;
		
		Connection con = conexion.conectar();
		if (con != null) {
			try {
				String sql = "SELECT actividades.nombre FROM actividades INNER JOIN clientes ON actividades.idCliente = clientes.idCliente"  
						+ "WHERE idCliente = ?";
				
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1, idCliente);
				ResultSet rs = st.executeQuery();
				
				actividades = new ArrayList<>();
				
				while (rs.next()) {
					Actividad a = new Actividad();
					a.setNombre(rs.getString("nombre"));
					actividades.add(a);
				} 
			} catch (SQLException e) {
				System.out.println("Error: Clase ActividadesDAO / Método buscarActividadPorCliente");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		}

		return actividades;
		
	}
	@Override
	public List<Object> buscarActividadPorProfesional(int idProf) {
		List<Object> actividades = null;
		
		Connection con = conexion.conectar();
		if (con != null) {
			try {
				String sql = "SELECT actividades.nombre FROM actividades INNER JOIN profesionales ON actividades.idProf = profesionales.idProf"  
						+ "WHERE idProf = ?";
				
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1, idProf);
				ResultSet rs = st.executeQuery();
				
				actividades = new ArrayList<>();
				
				while (rs.next()) {
					Actividad a = new Actividad();
					a.setNombre(rs.getString("nombre"));
					actividades.add(a);
				} 
			} catch (SQLException e) {
				System.out.println("Error: Clase ActividadesDAO / Método buscarActividadPorProfesional");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		}

		return actividades;
	}

	
}
