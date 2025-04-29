package dao.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import db.MySQLConexion;
import entidades.Usuario;

public class UsuarioDAO implements dao.UsuarioDAO {

	@Override
	public int crear(Usuario usuario) {
		int value = 0;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "INSERT INTO usuarios VALUES(null, ?, ?, ?);";
			ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getClave());
			ps.setString(3, usuario.getRol());
			
			value = ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error al registrar: " + e.getMessage());
		}
		finally {
			MySQLConexion.closeConexion(con);
		}
		
		return value;
	}

	@Override
	public ArrayList<Usuario> listar() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM usuarios;";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Usuario usuario = new Usuario(
						rs.getInt("usuario_id"),
						rs.getString("nombre"),
						rs.getString("clave"),
						rs.getString("rol")
						);
				lista.add(usuario);
			}
		} catch (Exception e) {
			System.out.println("Error al listar: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		
		return lista;
	}

	@Override
	public Usuario obtener(int usuarioId) {
		Usuario usuario = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM usuarios WHERE usuario_id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, usuarioId);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				usuario = new Usuario(
					rs.getInt("usuario_id"),
					rs.getString("nombre"),
					rs.getString("clave"),
					rs.getString("rol")
					);
			}
		} catch (Exception e) {
			System.out.println("Error al obtener el registro: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		
		return usuario;
	}

	@Override
	public int actualizar(Usuario usuario) {
		int value = 0;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "update usuarios set nombre = ?, clave = ?, rol = ? where usuario_id = ?;";
			ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getClave());
			ps.setString(3, usuario.getRol());
			ps.setInt(4, usuario.getUsuarioId());
			
			value = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al actualizar el registro: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		
		return value;
	}

	@Override
	public int eliminar(int usuarioId) {
		int value = 0;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "delete from usuarios where usuario_id = ?;";
			ps = con.prepareStatement(sql);
			ps.setInt(1, usuarioId);
			
			value = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al eliminar el registro: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return value;
	}

	@Override
	public ArrayList<Usuario> buscar(String texto) {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM usuarios WHERE nombre like ?;";
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + texto + "%");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Usuario usuario = new Usuario(
						rs.getInt("usuario_id"),
						rs.getString("nombre"),
						rs.getString("clave"),
						rs.getString("rol")
						);
				lista.add(usuario);
			}
		} catch (Exception e) {
			System.out.println("Error al listar: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		
		return lista;
	}

	@Override
	public Usuario autenticar(String nombre, String clave) {
		Usuario usuario = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM usuarios WHERE nombre = ? AND clave = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.setString(2, clave);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				usuario = new Usuario(
					rs.getInt("usuario_id"),
					rs.getString("nombre"),
					rs.getString("clave"),
					rs.getString("rol")
					);
			}
		} catch (Exception e) {
			System.out.println("Error al obtener el registro: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		
		return usuario;
	}

}
