package cl.awakelab.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.awakelab.model.Pagos;
import cl.awakelab.conexion.ConexionSingleton;

public class PagosDAO {
	
	public List<Pagos> lPagos(){
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		String sql ="selec * from pagos";
			List<Pagos> listarPagos = new ArrayList<Pagos>();
			
			try {
				conn = ConexionSingleton.getConnection();
				stm = conn.createStatement();
				rs = stm.executeQuery(sql);
				while (rs.next()) {
					Pagos p = new Pagos();
					p.setIdpago(rs.getInt(1));
					p.setIdCliente(rs.getInt(2));
					p.setMulta(rs.getInt(3));
					p.setMonto(rs.getInt(4));
					p.setfPagar(rs.getDate(5));
					p.setMorosidad(rs.getBoolean(6));
					//p.setuPago(rs.getDate(7));
					listarPagos.add(p);		
				}
				stm.close();
				rs.close();
			}catch(SQLException e) {
				System.out.println("Error en las clse PagosDAO listarPagos");
				e.printStackTrace();
				
			}
			return listarPagos;
	}
	public boolean multar(Pagos mul) {
		boolean multa = false;
		Connection conn = null;
		Statement stm = null;
		
		
		String sql = "select idcliente, multas from pagos ('"+ mul.getIdCliente() +"','"+ mul.getMulta() +"' )";
		try{
			conn = ConexionSingleton.getConnection();
			stm = conn.createStatement();
			stm.execute(sql);
			multa =true;
			stm.close();
		}catch(SQLException e) {
			System.out.println("Error: metodo Multar");
			e.printStackTrace();
		}
		return multa;
		
	}
	public boolean pagarTotal(Pagos pagar) {
		boolean pago = false;
		Statement stm = null;
		Connection con = null;
		
		String sql = "select idcliente, total, upago from pagos ('"+ pagar.getIdCliente() +"','"+ pagar.getMonto() +"'.'"+ pagar.getuPago()+"' )";
		try {
			con = ConexionSingleton.getConnection();
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
	

}
