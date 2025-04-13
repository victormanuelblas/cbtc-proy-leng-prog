package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.MySQLConexion;
import entidades.Producto;
import interfaces.ProductoInterface;

public class ProductoModel implements ProductoInterface {

	@Override
	public int crear(Producto producto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Producto> listar() {
		ArrayList<Producto> lista = new ArrayList<Producto>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "CALL LP1P_SP_producto_listado;";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Producto producto = new Producto(
						rs.getInt("producto_id"),
						rs.getString("nombre"),
						rs.getString("categoria"),
						rs.getDouble("precio"),
						rs.getDate("fechaCreacion").toString(),
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int actualizar(Producto producto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(int productoId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
