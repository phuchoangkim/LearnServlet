package old;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/cookie-1"})
public class ServletCookie1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("Servlet cookie 1: set cookie data" + "<br/>");
		Cookie cookie1 = new Cookie("name", "PhucHoangKim");
		Cookie cookie2 = new Cookie("age", "23");
		cookie1.setMaxAge(5);
		cookie2.setMaxAge(10);
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
		printWriter.close();
	}
}
