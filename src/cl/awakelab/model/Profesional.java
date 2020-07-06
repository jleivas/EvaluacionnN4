package cl.awakelab.model;

public class Profesional extends Usuario{
	
	private int idProf;
	private String nombre;
	
	public Profesional() {
	}
	
	public Profesional(String nombre) {
		super();
		this.nombre = nombre;
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



	@Override
	public String toString() {
		return "Profesional [idProf=" + idProf + ", nombre=" + nombre + "]";
	}
	
	

}
