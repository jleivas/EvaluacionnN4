package cl.awakelab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.awakelab.conexion.Conexion;
import cl.awakelab.idao.IClientesDAO;
import cl.awakelab.model.Cliente;

public class ClientesDAO implements IClientesDAO{

private Conexion conexion;
	
	public ClientesDAO(Conexion conexion) {
		this.conexion = conexion;
	}
	

	@Override
	public boolean agregarRegistro(Object objeto) {
		// TODO Auto-generated method stub
		boolean registroAgregado = false;
		
		Connection con = conexion.conectar();
	
			try {
				String sql = "INSERT INTO clientes (nombre, usuario, password) VALUES  (?, ?, ?)";
				
				Cliente cliente = (Cliente) objeto;
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, cliente.getNombre());
				st.setString(2, cliente.getUsuario());
				st.setString(3, cliente.getPassword());
				
				registroAgregado = st.executeUpdate() > 0;
			} catch (SQLException e){
				System.out.println("Error: Clase ClientesDAO / Método agregarRegistro");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		
		
		return registroAgregado;
	}

	@Override
	public List<Object> mostrarRegistros() {
		// TODO Auto-generated method stub
		List<Object> clientes = null;
		
		Connection con = conexion.conectar();
		
		if (con != null) {
			try {
				String sql = "SELECT idCliente, nombre, usuario FROM clientes ORDER BY idCliente";
				
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				
				clientes = new ArrayList<>();
				
				while (rs.next()) {
					Cliente a = new Cliente();
					a.setIdCliente(rs.getInt("idCliente"));
					a.setNombre(rs.getString("nombre"));
					a.setUsuario(rs.getString("usuario"));
					
					clientes.add(a);
				} 
			} catch (SQLException e) {
				System.out.println("Error: Clase ClientesDAO / Método mostrarRegistros");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		}

		return clientes;
	}

	@Override
	public boolean actualizarRegistro(Object objeto) {
		// TODO Auto-generated method stub
		boolean registroActualizado = false;
		
		Connection con = conexion.conectar();
		
		if (con != null) {
			try {
				String sql = "UPDATE clientes SET nombre = ? WHERE idCliente= ?";
				
				Cliente cliente = (Cliente) objeto;
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, cliente.getNombre());
				
				registroActualizado = st.executeUpdate() > 0;
			} catch (SQLException e) {
				System.out.println("Error: Clase ClientesDAO / Método actualizarRegistro");
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
				String sql = "DELETE FROM clientes WHERE idCliente = ?";
				
				Cliente cliente = (Cliente) objeto;
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setInt(1, cliente.getIdCliente());
				
				registroEliminado = st.executeUpdate() > 0;
			} catch (SQLException e) {
				System.out.println("Error: Clase ClientesDAO / Método eliminarRegistro");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		}
		return registroEliminado;
	}


	@Override
	public Cliente buscarUsuario(String usuario) {
		
		Cliente c = new Cliente();
		
		Connection con = conexion.conectar();
		if (con != null) {
			try {
				String sql = "SELECT idCliente, usuario, nombre, password FROM Clientes WHERE usuario = ?";
				
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, usuario);
				ResultSet rs = st.executeQuery();
				
				while (rs.next()) {
					c.setIdCliente(rs.getInt("idCliente"));
					c.setUsuario(rs.getString("usuario"));
					c.setNombre(rs.getString("nombre"));
					c.setPassword(rs.getString("password"));
				} 
			} catch (SQLException e) {
				System.out.println("Error: Clase ClientesDAO / Método buscarUsuario");
				e.printStackTrace();
			} finally {
				conexion.desconectar();
			}
		}

		return c;
		
	}
}
