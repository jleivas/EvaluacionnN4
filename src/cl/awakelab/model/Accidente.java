package cl.awakelab.model;

public class Accidente {
	
	private int idAccidente;
	private String fecha;
	private String tipoAccidente;
	private int idCliente;
	
	public Accidente() {
		super();
	}
	
	public Accidente(String fecha, String tipoAccidente, int idCliente) {
		this.fecha = fecha;
		this.tipoAccidente = tipoAccidente;
		this.idCliente = idCliente;
	}

	public int getIdAccidente() {
		return idAccidente;
	}

	public void setIdAccidente(int idAccidente) {
		this.idAccidente = idAccidente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTipoAccidente() {
		return tipoAccidente;
	}

	public void setTipoAccidente(String tipoAccidente) {
		this.tipoAccidente = tipoAccidente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "Accidente [idAccidente=" + idAccidente + ", fecha=" + fecha + ", tipoAccidente=" + tipoAccidente
				+ ", idCliente=" + idCliente + "]";
	}
	

}
