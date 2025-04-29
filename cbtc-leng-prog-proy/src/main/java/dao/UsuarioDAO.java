package dao;

import java.util.ArrayList;

import entidades.Usuario;

public interface UsuarioDAO {

	public int crear(Usuario usuario);
	public ArrayList<Usuario> listar();
	public ArrayList<Usuario> buscar(String texto);
	public Usuario obtener(int usuarioId);
	public int actualizar(Usuario usuario);
	public int eliminar(int usuarioId);
	
	public Usuario autenticar(String nombre, String clave);
	
}
