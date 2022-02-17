package session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/set-session"})
public class SetSession extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		HttpSession httpSession = req.getSession();
		httpSession.setAttribute("name", "Phuc Hoang Kim");
		httpSession.setAttribute("age", "23");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("Set session value");
		printWriter.close();
	}
}
