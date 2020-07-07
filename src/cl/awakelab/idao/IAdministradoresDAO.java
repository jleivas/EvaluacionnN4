package cl.awakelab.idao;

import java.util.List;

public interface IAdministradoresDAO extends InterfaceSuper{

	public  List<Object> buscarUsuario(String usuario);
}
