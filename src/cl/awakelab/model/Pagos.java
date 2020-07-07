package cl.awakelab.model;

import java.util.Date;

public class Pagos {
	private int idpago;
	private int idCliente;
	private int monto;
	private int multa;
	private Date fPagar; //fecha a pagar
	private Date uPago; //fecha ultimo pago
	private boolean morosidad;
	
	public Pagos() {
		super();
	}

	public Pagos(int idCliente, int monto, Date fPagar, Date uPago, boolean morosidad) {
		super();
		this.idCliente = idCliente;
		this.monto = monto;
		this.fPagar = fPagar;
		this.uPago = uPago;
		this.morosidad = morosidad;
	}

	public Pagos(int idCliente, int monto, int multa, Date fPagar, Date uPago, boolean morosidad) {
		super();
		this.idCliente = idCliente;
		this.monto = monto;
		this.multa = multa;
		this.fPagar = fPagar;
		this.uPago = uPago;
		this.morosidad = morosidad;
	}

	public int getIdpago() {
		return idpago;
	}

	public void setIdpago(int idpago) {
		this.idpago = idpago;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public int getMulta() {
		return multa;
	}

	public void setMulta(int multa) {
		this.multa = multa;
	}

	public Date getfPagar() {
		return fPagar;
	}

	public void setfPagar(Date fPagar) {
		this.fPagar = fPagar;
	}

	public Date getuPago() {
		return uPago;
	}

	public void setuPago(Date uPago) {
		this.uPago = uPago;
	}

	public boolean isMorosidad() {
		return morosidad;
	}

	public void setMorosidad(boolean morosidad) {
		this.morosidad = morosidad;
	}

	@Override
	public String toString() {
		return "Pagos [idpago=" + idpago + ", idCliente=" + idCliente + ", monto=" + monto + ", multa=" + multa
				+ ", fPagar=" + fPagar + ", uPago=" + uPago + ", morosidad=" + morosidad + "]";
	}
	
	
	
	
}


