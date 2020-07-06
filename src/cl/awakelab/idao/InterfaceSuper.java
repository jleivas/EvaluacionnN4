package cl.awakelab.idao;

import java.util.List;

public interface InterfaceSuper {

	public boolean agregarRegistro(Object objeto);
	public List<Object> mostrarRegistros();
	public boolean actualizarRegistro(Object objeto);
	public boolean eliminarRegistro(Object objeto);
}
