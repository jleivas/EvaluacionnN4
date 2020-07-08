package cl.awakelab.idao;

public interface IClientesDAO extends InterfaceSuper{

	public Object buscarUsuario(String usuario);
	public Object buscarIdCliente(int idCliente);
}
