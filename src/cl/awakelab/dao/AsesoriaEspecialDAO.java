package cl.awakelab.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import cl.awakelab.model.Asesoria;
import cl.awakelab.conexion.Conexion;


public class AsesoriaEspecialDAO {
private Conexion conexion;
	
	public AsesoriaEspecialDAO(Conexion conexion) {
		this.conexion = conexion;
	}
	
	public boolean solicitarAsesoria(Asesoria as){
		
		boolean crearSolicitud = false;
		
		Statement stm = null;
		Connection con = conexion.conectar();
		
		String sql = "insert into asesoria values (null, '"+ as.getFechaAsesoria() + "','"+as.getTipoAsesoria()+"')";
		try {
			con = conexion.conectar();
			stm = con.createStatement();
			stm.execute(sql);
			crearSolicitud = true;
			stm.close();
		}catch(SQLException e) {
			System.out.println("Error: Clase AsesoriaEspecial, metodo solicitudEspecial");
			e.printStackTrace();
		}
		return crearSolicitud;
		
	}
}
