package login_session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/login-form" })
public class LoginForm extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<form action='/LearnServlet/login-form' method='POST'>");
		printWriter.println("<label>Username:</label><br/>");
		printWriter.println("<input type='text' name='username'/><br/>");
		printWriter.println("<label>Password:</label><br/>");
		printWriter.println("<input type='password' name='password'/><br/>");
		printWriter.println("<input type='submit' name='submit' value='Login'/><br/>");
		printWriter.println("</form>");
		printWriter.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		HttpSession httpSession = req.getSession();
		if (username.equals("phuc.hoangkim") && password.equals("123456")) {
			httpSession.setAttribute("username", username);
			resp.sendRedirect("/LearnServlet/login-successful");
		} else {
			resp.sendRedirect("/LearnServlet/login-form");
		}
	} 

}
