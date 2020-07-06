package cl.awakelab.model;

public class Usuario {

	private int idUser;
	private String usuario;
	private String contraseña;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String usuario, String contraseña) {
		this.usuario = usuario;
		this.contraseña = contraseña;
	}


	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	@Override
	public String toString() {
		return "Usuario [idUser=" + idUser + ", usuario=" + usuario + ", contraseña=" + contraseña + "]";
	}
	
	
}
