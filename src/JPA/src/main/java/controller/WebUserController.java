package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import business.WebUserSearcher;
import model.UtenteWeb;

/**
 * Servlet implementation class WebUserController
 */
@WebServlet("/webus")
public class WebUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebUserController() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebUserSearcher wum = new WebUserSearcher();
		List<UtenteWeb> modList = wum.GetModList();
		ObjectMapper om = new ObjectMapper();
		response.setContentType("/application/JSON");
		response.getWriter().append(om.writeValueAsString(modList));
	}

}
