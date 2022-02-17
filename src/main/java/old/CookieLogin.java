package old;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/cookie-login" })
public class CookieLogin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<form action='/LearnServlet/cookie-login' method='POST'>");
		printWriter.println("<label>Username:</label><br/>");
		printWriter.println("<input type='text' name='username'/><br/>");
		printWriter.println("<label>Password:</label><br/>");
		printWriter.println("<input type='password' name='password'/><br/>");
		printWriter.println("<input type='submit' name='login' value='Login'/><br/>");
		printWriter.println("</form>");
		printWriter.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (username == "admin" && password == "12345") {
			Cookie cUsername = new Cookie("username", username);
			Cookie cPassword = new Cookie("password", password);
			cUsername.setMaxAge(20);
			cPassword.setMaxAge(20);
			resp.addCookie(cUsername);
			resp.addCookie(cPassword);
			resp.sendRedirect("/LearnServlet/welcome");
		} else {
			resp.sendRedirect("/LearnServlet/cookie-login");
		}
		printWriter.close();
	}
}
