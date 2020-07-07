package cl.awakelab.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.awakelab.idao.IDAOaccidentes;

import cl.awakelab.conexion.ConexionSingleton;
import cl.awakelab.model.Accidente;




public class CrearReporteAccDAO implements IDAOaccidentes {

	@Override
	public boolean CrearReporte(Accidente acc) {
		boolean registrar = false;
		Statement stm = null;
		Connection con = null;
		
		String sql = "insert into accidente values (null, '" + acc.getFecha() + "','"+ acc.getTipoAccidente() +"',null)";
	try {
		con = ConexionSingleton.getConnection();
		stm = con.createStatement();
		stm.execute(sql);
		registrar =true;
		stm.close();
	}catch(SQLException e) {
		System.out.println("Error: metodo crearReporte");
		e.printStackTrace();
	}
		
		return registrar;
	}


	@Override
	public List<Accidente> misAccidentes() {
	Connection conn = null;
	Statement stm = null;
	ResultSet rs = null;
	
	String sql ="select accidente.idaccidente, accidente.fecha, accidente.tipoaccidente, actividad.fechavisita, actividad.situacionvisita, actividad.idcliente from accidente inner join actividad on (actividad.idcliente = accidente.idcliente) order by accidente.fecha";
			List<Accidente> listAccidentes = new ArrayList<Accidente>();
			
			try {
				conn = ConexionSingleton.getConnection();
				stm = conn.createStatement();
				rs = stm.executeQuery(sql);
				while (rs.next()) {
					Accidente a = new Accidente();
					a.setIdAccidente(rs.getInt(1));
					a.setFecha(rs.getString(2));
					a.setTipoAccidente(rs.getString(3));
					a.setIdCliente(rs.getInt(6));
					listAccidentes.add(a);
					
				}
				stm.close();
				rs.close();
			} catch(SQLException e) {
				System.out.println("Error: Clase CrearReporteAccDao, método MisAccidentes ");
				e.printStackTrace();
			}
			
			return listAccidentes;
		}


	@Override
	public boolean eliminarReporte(Accidente acc) {
		Connection con = null;
		Statement stm = null;
		
		boolean eliminar = false;
		String sql = "delete from accidente where idAccidente = " + acc.getIdAccidente();
		
		try {
			con = ConexionSingleton.getConnection();
			stm = con.createStatement();
			stm.execute(sql);
			eliminar = true;
			stm.close();
			
		}catch(SQLException e){
			System.out.println("Error: clase crearReporte, metodo eliminar");
			e.printStackTrace();
			
		}
		return eliminar;
	}
}
	
	

