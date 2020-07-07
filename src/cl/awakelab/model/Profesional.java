package cl.awakelab.model;

public class Profesional {
	
	private int idProf;
	private String nombre;
	private String usuario;
	private String password;
	
	public Profesional() {
	}

	public Profesional(String nombre, String usuario, String password) {
		this.nombre = nombre;
		this.usuario = usuario;
		this.password = password;
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
		return "Profesional [idProf=" + idProf + ", nombre=" + nombre + ", usuario=" + usuario + ", password="
				+ password + "]";
	}
	
	

}
