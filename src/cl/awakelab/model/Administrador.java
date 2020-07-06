package cl.awakelab.model;

public class Administrador extends Usuario{

	private int idAdmin;
	private String nombre;
	
	public Administrador() {
	}
	
	public Administrador(String nombre) {
		this.nombre = nombre;
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



	@Override
	public String toString() {
		return "Administrador [idAdmin=" + idAdmin + ", nombre=" + nombre + "]";
	}
	
	
}
