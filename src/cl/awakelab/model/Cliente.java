package cl.awakelab.model;

public class Cliente {
	
	private int idCliente;
	private String nombre;
	private String usuario;
	private String password;
	
	public Cliente() {
	}

	public Cliente(String nombre, String usuario, String password) {
		this.nombre = nombre;
		this.usuario = usuario;
		this.password = password;
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
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", usuario=" + usuario + ", password="
				+ password + "]";
	}
	
	
}