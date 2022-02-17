package old;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/login"})
public class LoginPage extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<form action='handler-login' method='POST'>");
		printWriter.println("<label>Username:</label><br/>");
		printWriter.println("<input type='input' name='username'/><br/>");
		printWriter.println("<label>Password:</label><br/>");
		printWriter.println("<input type='password' name='password'/><br/>");
		printWriter.println("<input type='submit' name='submit' value='Login'/>");
		printWriter.println("</form>");
		printWriter.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
