package cl.awakelab.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.awakelab.conexion.*;
import cl.awakelab.model.Pagos;

public class PagosDAO {

private Conexion conexion;
	
	public PagosDAO(Conexion conexion) {
		this.conexion = conexion;
	}
	public List<Pagos> lPagos(){
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		String sql ="select * from pagos";
			List<Pagos> listarPagos = new ArrayList<Pagos>();
			
			try {
				 
				stm = conn.createStatement();
				rs = stm.executeQuery(sql);
				while (rs.next()) {
					Pagos p = new Pagos();
					p.setIdpago(rs.getInt(1));
					p.setIdCliente(rs.getInt(2));
					p.setMonto(rs.getInt(4));
					p.setfPagar(rs.getDate(5));
					p.setMorosidad(rs.getBoolean(6));
					//p.setuPago(rs.getDate(7));
					listarPagos.add(p);		
				}
				stm.close();
				rs.close();
			}catch(SQLException e) {
				System.out.println("Error en las clase PagosDAO listarPagos");
				e.printStackTrace();
				
			}
			return listarPagos;
	}

	public boolean pagarTotal(Pagos pagar) {
		boolean pago = false;
		Statement stm = null;
		Connection con = null;
		
		String sql = "select idcliente, total, upago from pagos ('"+ pagar.getIdCliente() +"','"+ pagar.getMonto() +"'.'"+ pagar.getuPago()+"' )";
		try {
			con = conexion.conectar();
			stm = con.createStatement();
			stm.execute(sql);
			pago = true;
			stm.close();
			//con.close();
		}catch(SQLException e) {
			System.out.println("Error: Clase PagosDAO, método Pagar");
			e.printStackTrace();
		}
		return pago;
		
	}
	public Pagos obtenerPagos(int idcliente) {
		Connection con = null;
		Statement stm =null;
		ResultSet rs = null;
		String sql ="select * from cliente where IDCLIENTE = " +idcliente;
		Pagos p = new Pagos();
		try {
			con = conexion.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				p.setIdCliente(rs.getInt(2));
				p.setMonto(rs.getInt(4));
				
			}
			stm.close();
			rs.close();
		}catch(SQLException e) {
			System.out.println("Error: Clase PagoDao, metodos obtenerPagos");
			e.printStackTrace();
		}
		return p;
	}

}
