package cl.awakelab.model;

public class Cliente extends Usuario{
	
	private int idCliente;
	private String nombre;
	
	public Cliente() {
	}
	
	public Cliente(String nombre) {
		this.nombre = nombre;
	}



	public int getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + "]";
	}
	
	

}
