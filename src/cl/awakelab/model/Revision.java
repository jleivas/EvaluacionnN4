package cl.awakelab.model;

public class Revision {
	
	private int idRevision;
	private String fecha;
	private boolean situacionActividad;
	
	public Revision() {
	}
	
	public Revision(String fecha, boolean situacionActividad) {
		this.fecha = fecha;
		this.situacionActividad = situacionActividad;
	}
	public int getIdRevision() {
		return idRevision;
	}
	public void setIdRevision(int idRevision) {
		this.idRevision = idRevision;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public boolean isSituacionActividad() {
		return situacionActividad;
	}
	public void setSituacionActividad(boolean situacionActividad) {
		this.situacionActividad = situacionActividad;
	}
	
	@Override
	public String toString() {
		return "Revision [idRevision=" + idRevision + ", fecha=" + fecha + ", situacionActividad=" + situacionActividad
				+ "]";
	}
	
	
}
