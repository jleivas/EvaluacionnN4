package cl.awakelab.model;

public class Pago {

	private int idPago;
	private int idCliente;
	private int multas;
	private int total;
	private String fechaCaduco;
	private boolean morosidad;
	
	public Pago() {
	}
	
	public Pago(int multas, int total, String fechaCaduco, boolean morosidad) {
		this.multas = multas;
		this.total = total;
		this.fechaCaduco = fechaCaduco;
		this.morosidad = morosidad;
	}



	public int getIdPago() {
		return idPago;
	}



	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}



	public int getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}



	public int getMultas() {
		return multas;
	}



	public void setMultas(int multas) {
		this.multas = multas;
	}



	public int getTotal() {
		return total;
	}



	public void setTotal(int total) {
		this.total = total;
	}



	public String getFechaCaduco() {
		return fechaCaduco;
	}



	public void setFechaCaduco(String fechaCaduco) {
		this.fechaCaduco = fechaCaduco;
	}



	public boolean isMorosidad() {
		return morosidad;
	}



	public void setMorosidad(boolean morosidad) {
		this.morosidad = morosidad;
	}



	@Override
	public String toString() {
		return "Pago [idPago=" + idPago + ", idCliente=" + idCliente + ", multas=" + multas + ", total=" + total
				+ ", fechaCaduco=" + fechaCaduco + ", morosidad=" + morosidad + "]";
	}
	
	
}
