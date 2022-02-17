package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = { "/servlet1" })
public class Logger implements Filter {
	@Override
	public void doFilter(ServletRequest a0, ServletResponse a1, FilterChain a2) throws IOException, ServletException {
		System.out.println("Waiting handle at logger");
		a2.doFilter(a0, a1);
		a1.setContentType("text/plain");
		System.out.println("After call");
	}
}
