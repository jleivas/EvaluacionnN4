package cl.awakelab.model;

public class Profesional {
	
	private int idProf;
	private String nombre;
	private String password;
	private String usuario;
	
	public Profesional() {
	}

	public Profesional(int idProf, String nombre, String password, String usuario) {
		this.idProf = idProf;
		this.nombre = nombre;
		this.password = password;
		this.usuario = usuario;
	}
	
	public Profesional(String nombre, String password, String usuario) {
		this.nombre = nombre;
		this.password = password;
		this.usuario = usuario;
	}

	public int getIdProf() {
		return idProf;
	}

	public void setIdProf(int idProf) {
		this.idProf = idProf;
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
		return "Profesional [idProf=" + idProf + ", nombre=" + nombre + ", password=" + password + ", usuario="
				+ usuario + "]";
	}

	
}
	
	


