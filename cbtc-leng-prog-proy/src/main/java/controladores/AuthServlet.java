package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.UsuarioDAO;
import entidades.Usuario;
import factory.DAOFactory;

@WebServlet(name = "auth", urlPatterns = { "/auth" })
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UsuarioDAO usuarioDAO;
	
    public AuthServlet() {
        super();
        DAOFactory fabrica = DAOFactory.getDAOFactory();
        this.usuarioDAO = fabrica.getUsuario();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = "";
		if(request.getParameter("opcion") != null) opcion = request.getParameter("opcion");
		
		switch(opcion) {
			case "autenticar" : this.autenticar(request, response); break;
			case "logout" : this.logout(request, response); break;
			default:
				login(request, response);
				
		}
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/auth/login.jsp").forward(request, response);
	}
	
	protected void autenticar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String clave = request.getParameter("clave");
		Usuario usuario = this.usuarioDAO.autenticar(nombre, clave);
		
		if (usuario == null) {
			request.setAttribute("error", "Usuario y/o contraseña incorrectos.");
			this.login(request, response);
		} else {
			HttpSession miSession = request.getSession(true);
			miSession.setAttribute("usuario", usuario);
			response.sendRedirect("inicio");
		}
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession miSession = request.getSession();
		miSession.invalidate();
		response.sendRedirect("auth");
	}

}
