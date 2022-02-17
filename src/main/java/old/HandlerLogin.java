package old;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/handler-login"})
public class HandlerLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		if (username.equals("phuc.hk") && password.equals("12345")) {
			RequestDispatcher validRQ = req.getRequestDispatcher("/welcome");
			validRQ.forward(req, resp);
		} else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.println("Username or password doesn't correct");
			RequestDispatcher invalidRQ = req.getRequestDispatcher("/login");
			invalidRQ.include(req, resp);
			printWriter.close();
		}
	}
}
