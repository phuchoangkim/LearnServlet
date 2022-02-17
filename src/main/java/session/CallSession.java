package session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/call-session"})
public class CallSession extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		HttpSession httpSession = req.getSession();
		
		Object objName = httpSession.getAttribute("name");
		Object objAge = httpSession.getAttribute("age");
		
		String name = "";
		String age = "";
		
		if(objName != null && objAge != null) {
			name = objName.toString();
			age = objAge.toString();
		} else {
			resp.sendRedirect("/LearnServlet/set-session");
		}
		
		String output = "";
		if(name != "" && age != "") {
			output = "Hello " + name + " " + age;
		} else {
			output = "Empty value";
		}
		
		PrintWriter printWriter = resp.getWriter();
		printWriter.println(output);
		printWriter.close();
	}
}
