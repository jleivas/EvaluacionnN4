package cl.awakelab.model;

public class Administrador {

	private int idAdmin;
	private String nombre;
	private String usuario;
	private String password;
	
	public Administrador() {
		
	}
	
	public Administrador(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
	}
	
	public Administrador(String nombre, String usuario, String password) {
		this.nombre = nombre;
		this.usuario = usuario;
		this.password = password;
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Administrador [idAdmin=" + idAdmin + ", nombre=" + nombre + ", usuario=" + usuario + ", password="
				+ password + "]";
	}
	
	
	
	
	
}
