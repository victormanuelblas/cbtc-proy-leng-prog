package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.CallableStatement;
import db.MySQLConexion;
import entidades.Producto;
import interfaces.ProductoInterface;

public class ProductoModel implements ProductoInterface {

	@Override
	public int crear(Producto producto) {
		int value = 0;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "CALL LP1P_SP_producto_crear (?, ?, ?, ?, ?, ?);";
			ps = con.prepareStatement(sql);
			ps.setString(1, producto.getCodigo());
			ps.setString(2, producto.getNombre());
			ps.setInt(3, producto.getCategoriaId());
			ps.setDouble(4, producto.getPrecio());
			ps.setInt(5, producto.getStockMin());
			ps.setInt(6, producto.getStockMax());
			
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
	public ArrayList<Producto> listar() {
		ArrayList<Producto> lista = new ArrayList<Producto>();
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "CALL LP1P_SP_producto_listado ('');";
			cs = con.prepareCall(sql);
			rs = cs.executeQuery();
			
			while (rs.next()) {
				Producto producto = new Producto(
						rs.getInt("producto_id"),
						rs.getString("codigo"),
						rs.getString("nombre"),
						rs.getString("categoria"),
						rs.getDouble("precio"),
						rs.getString("fechaCreacion").toString(),
						rs.getInt("stock"),
						rs.getInt("stockMin"),
						rs.getInt("stockMax"),
						rs.getString("estado")
						);
				lista.add(producto);
			}
		} catch (Exception e) {
			System.out.println("Error al listar: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		
		return lista;
	}

	@Override
	public Producto obtener(int productoId) {
		Producto objProducto = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "CALL LP1P_SP_producto_detalle (?);";
			ps = con.prepareStatement(sql);
			ps.setInt(1, productoId);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				objProducto = new Producto(
						rs.getInt("producto_id"),
						rs.getString("codigo"),
						rs.getString("nombre"),
						rs.getInt("categoria"),
						"",
						rs.getDouble("precio"),
						rs.getString("fechaCreacion"),
						rs.getInt("stock"),
						rs.getInt("stockMin"),
						rs.getInt("stockMax"),
						rs.getInt("estado"),
						""				
				);
			}
		} catch (Exception e) {
			System.out.println("Error al obtener el registro: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		
		return objProducto;
	}

	@Override
	public int actualizar(Producto producto) {
		int value = 0;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "CALL LP1P_SP_producto_actualizar (?, ?, ?, ?, ?, ?, ?);";
			ps = con.prepareStatement(sql);
			ps.setInt(1, producto.getProductoId());
			ps.setString(2, producto.getCodigo());
			ps.setString(3, producto.getNombre());
			ps.setInt(4, producto.getCategoriaId());
			ps.setDouble(5, producto.getPrecio());
			ps.setInt(6, producto.getStockMin());
			ps.setInt(7, producto.getStockMax());
			
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
	public int eliminar(int productoId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Producto> buscar(String nomProducto) {
		ArrayList<Producto> lista = new ArrayList<Producto>();
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "CALL LP1P_SP_producto_listado (?);";
			cs = con.prepareCall(sql);
			cs.setString(1, nomProducto);
			rs = cs.executeQuery();
			
			while (rs.next()) {
				Producto producto = new Producto(
						rs.getInt("producto_id"),
						rs.getString("codigo"),
						rs.getString("nombre"),
						rs.getString("categoria"),
						rs.getDouble("precio"),
						rs.getString("fechaCreacion").toString(),
						rs.getInt("stock"),
						rs.getInt("stockMin"),
						rs.getInt("stockMax"),
						rs.getString("estado")
						);
				lista.add(producto);
			}
		} catch (Exception e) {
			System.out.println("Error al listar: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		
		return lista;
	}

}
