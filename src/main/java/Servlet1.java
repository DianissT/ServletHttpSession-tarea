
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0);

			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();

			String n = request.getParameter("userName");
			//validar nombre
			 if (n == null || n.trim().isEmpty()) {
	               out.print("Debe ingresar un nombre.");
	               return;
			 }
	         
			 // Validar que solo tenga letras y espacios
			 if (!n.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
	               out.print("El nombre solo debe contener letras.");
	               return;
			 }
			

			HttpSession session = request.getSession();
			session.setAttribute("uname", n);
			out.print("WELCOME " + n);
			out.print("<br>");
			out.print("<a href='Servlet2'>visit</a>");
			out.print("<br>");
			out.print("<a href='Logout'>Cerrar sesión</a>");

			out.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
