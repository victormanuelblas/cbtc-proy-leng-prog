package controladores;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import modelos.ProductoModel;
import entidades.Producto;

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet(name = "producto", urlPatterns = { "/producto" })
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductoModel productoModel;
	private LocalDate fechaRegistro = LocalDate.now();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
        productoModel = new ProductoModel();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = "";
		if (request.getParameter("opcion") != null) opcion = request.getParameter("opcion");
		
		switch (opcion) {
			case "lista" : this.lista(request, response); break;
			case "detalle" : this.detalle(request, response); break;
			case "registrar" : this.registrar(request, response); break;
			default:
				lista(request, response);
		}
	}

	protected void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Producto> lista = null;
		if (request.getParameter("texto") != null) {
			lista = this.productoModel.buscar(request.getParameter("texto"));
		}else {
			lista = this.productoModel.listar();
		}
		request.setAttribute("lista", lista);
		
		request.getRequestDispatcher("/producto/listado.jsp").forward(request, response);
	}
	
	protected void detalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Producto prod = new Producto();
		if (request.getParameter("id") != null) {
			int productoId = Integer.parseInt(request.getParameter("id"));
			prod = this.productoModel.obtener(productoId);
		}
		request.setAttribute("info", prod);
		request.getRequestDispatcher("/producto/detalle.jsp").forward(request, response);
	
	}
	
	protected void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Producto objProducto = new Producto();
		objProducto.setProductoId(Integer.parseInt(request.getParameter("productoId")));
		objProducto.setCategoriaId(Integer.parseInt(request.getParameter("categoria")));
		objProducto.setCodigo(request.getParameter("codigo"));
		objProducto.setNombre(request.getParameter("nombre"));
		objProducto.setPrecio(Double.parseDouble(request.getParameter("precio")));
		objProducto.setFechaCreacion(fechaRegistro.toString());
		objProducto.setStock(0);
		objProducto.setStockMin(Integer.parseInt(request.getParameter("stockMin")));
		objProducto.setStockMax(Integer.parseInt(request.getParameter("stockMax")));
		request.setAttribute("usuario", objProducto);
		
		int value = 0;
		if (objProducto.getProductoId() > 0) {
			value = this.productoModel.actualizar(objProducto);
		} else {
			value = this.productoModel.crear(objProducto);
		}

		response.sendRedirect("producto");
	}

}
