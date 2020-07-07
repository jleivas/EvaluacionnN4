package cl.awakelab.idao;

import java.util.List;

import cl.awakelab.model.Accidente;

public interface IDAOaccidentes {
	
	public boolean CrearReporte(Accidente reporte);
	public boolean eliminarReporte(Accidente reporte);
	public List<Accidente> misAccidentes(); 

}
