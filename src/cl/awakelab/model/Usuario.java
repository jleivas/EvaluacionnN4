package cl.awakelab.model;

public class Usuario {

	private int idUser;
	private String usuario;
	private String password;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password= password;
	}


	@Override
	public String toString() {
		return "Usuario [idUser=" + idUser + ", usuario=" + usuario + ", contraseña=" + password + "]";
	}
	
	
}
