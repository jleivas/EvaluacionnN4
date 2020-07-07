package cl.awakelab.idao;

import java.util.List;

public interface IActividadesDAO extends InterfaceSuper{

	
	public boolean agregarCliente(Object objeto);
	public boolean agregarProfesional(Object objeto);
	public boolean agregarAsesoria(Object objeto);
	public boolean agregarRevision(Object objeto);
	public List<Object> buscarActividadPorCliente(int idCliente);
	public List<Object> buscarActividadPorProfesional(int idProf);
	
}
