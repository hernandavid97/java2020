package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Usuario;
import entities.Vacuna;
import logic.VacunaLogic;

/**
 * Servlet implementation class VacunaModif
 */
@WebServlet({ "/vacunamod", "/VacunaMod" })
public class VacunaModif extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VacunaModif() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != 0) {
			request.getSession().setAttribute("permisos", "No tiene permisos");
			response.sendRedirect("Signin");
			return;
		}
		ArrayList<Vacuna> vacunas = VacunaLogic.getAll();
		request.setAttribute("vacunas", vacunas);
		request.getRequestDispatcher("/WEB-INF/VacunaModif.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Vacuna> vacunas = VacunaLogic.getAll();
		request.setAttribute("vacunas", vacunas);
		Vacuna nueva = new Vacuna();
		Vacuna old = new Vacuna();
		nueva.setTitulo(request.getParameter("titulo"));
		nueva.setEspecie(request.getParameter("especie"));
		nueva.setDescripcion(request.getParameter("descripcion"));
		old.setId(Integer.parseInt(request.getParameter("id")));
		VacunaLogic vlogic = new VacunaLogic();
		request.setAttribute("estado", vlogic.validaModif(nueva, old));
		request.getRequestDispatcher("/WEB-INF/VacunaModif.jsp").forward(request, response);
	}

}
