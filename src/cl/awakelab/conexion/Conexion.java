package cl.awakelab.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static Conexion instancia = null;
	private Connection conexion = null;
	
	private String url;
	private String username;
	private String password;
	
	private  Conexion(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public static Conexion getInstance(String url, String username, String password) {
		if (instancia == null) {
			instancia = new Conexion(url, username, password);
		}
		return instancia;
	} 
	
	public Connection conectar() {
		try {
			if (conexion == null || conexion.isClosed()) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conexion = DriverManager.getConnection(url, username, password);
				} 
			} catch (SQLException | ClassNotFoundException e) {
				System.out.println("No se pudo conectar a la base de datos");
				e.printStackTrace();
		}
		return conexion;
	}
	
	public void desconectar() {
		try {
			if (conexion != null && !conexion.isClosed()) {
				conexion.isClosed();
			}
		} catch (SQLException e) {
			System.out.println("No se pudo desconectar la base de datos");
			e.printStackTrace();
		}
	}
}
