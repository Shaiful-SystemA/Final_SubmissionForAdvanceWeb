package sa41.ca.uno.LogInOut;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/authenticate")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		System.out.println(">> username: " + username);
		System.out.println(">> password: " + password);

		try {
			req.login(username, password);
		} catch (Exception ex) {
			resp.setStatus(403);
			return;
		}

		resp.setHeader("Access-Control-Allow-Origin", "*");

		HttpSession session = req.getSession();
		session.setAttribute("login", true);
		resp.setStatus(HttpServletResponse.SC_ACCEPTED);
	}
}
