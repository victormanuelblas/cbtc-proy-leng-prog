package controladores;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
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
			case "editar" : this.editar(request, response); break;
			case "registrar" : this.registrar(request, response); break;
			default:
				lista(request, response);
		}
	}

	protected void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Producto> lista = this.productoModel.listar();
		request.setAttribute("lista", lista);
		
		request.getRequestDispatcher("/producto/producto_lista.jsp").forward(request, response);
	}
	
	protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/usuario/usuario_editar.jsp").forward(request, response);
	}
	
	protected void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Producto objProducto = new Producto();
		objProducto.setNombre(request.getParameter("nombres"));
		objProducto.setCategoriaId(Integer.parseInt(request.getParameter("apellidos")));
		objProducto.setPrecio(Double.parseDouble(request.getParameter("dni")));
		objProducto.setFechaCreacion(request.getParameter("correo"));
		objProducto.setStock(0);
		objProducto.setStockMin(Integer.parseInt(request.getParameter("intentos")));
		objProducto.setStockMax(Integer.parseInt(request.getParameter("intentos")));
		request.setAttribute("usuario", objProducto);
		
		int value = this.productoModel.crear(objProducto);
		
		response.sendRedirect("usuario");
	}

}
