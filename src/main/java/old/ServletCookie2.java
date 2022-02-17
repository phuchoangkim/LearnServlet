package old;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/cookie-2"})
public class ServletCookie2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("Servlet 2: load cookie data" + "<br/>");
		Cookie[] cookies = req.getCookies();
		for(Cookie cookie : cookies) {
			printWriter.println(cookie.getName() + " : " + cookie.getValue() + "<br/>");
		}
		printWriter.close();
	}
}	
