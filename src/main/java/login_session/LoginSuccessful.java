package login_session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/login-successful"})
public class LoginSuccessful extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = resp.getWriter();
		HttpSession httpSession = req.getSession();
		Object objUsername = httpSession.getAttribute("username");
		if(objUsername != null) {
			printWriter.println("Logged in successfully!<br/>");
			printWriter.println("<a href='/LearnServlet/logout'>Logout</a>");
		} else {
			resp.sendRedirect("/LearnServlet/login-form");
		}
		printWriter.close();
	}
}
