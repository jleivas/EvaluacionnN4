package cl.awakelab.model;

public class Asesoria {
	private int idAsesoria;
	private String tipoAsesoria;
	private String fechaAsesoria;
	
	public Asesoria() {
		
	}
	public Asesoria(String tipoAsesoria, String fechaAsesoria) {
		super();
		this.tipoAsesoria = tipoAsesoria;
		this.fechaAsesoria = fechaAsesoria;
	}
	public int getIdAsesoria() {
		return idAsesoria;
	}
	public void setIdAsesoria(int idAsesoria) {
		this.idAsesoria = idAsesoria;
	}
	public String getTipoAsesoria() {
		return tipoAsesoria;
	}
	public void setTipoAsesoria(String tipoAsesoria) {
		this.tipoAsesoria = tipoAsesoria;
	}
	public String getFechaAsesoria() {
		return fechaAsesoria;
	}
	public void setFechaAsesoria(String fechaAsesoria) {
		this.fechaAsesoria = fechaAsesoria;
	}
	@Override
	public String toString() {
		return "Asesoria [idAsesoria=" + idAsesoria + ", tipoAsesoria=" + tipoAsesoria + ", fechaAsesoria="
				+ fechaAsesoria + "]";
	}
	
	
	

}
