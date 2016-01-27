package sa41.ca.uno.LogInOut;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/verify")
public class verifyServlet extends HttpServlet {

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
            
                Member member = new Member();
                
		String nama = req.getParameter("name");
		if (null == (nama)) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
                    System.out.println(nama);
                    
		member.setName(req.getParameter("name"));
		member.setEmail(req.getParameter("email"));
                member.setPassword(req.getParameter("password"));
		member.setGroupid(req.getParameter("group_id"));
                
                System.out.println(">>> member: " + member.getName() + ">>> email: " + member.getEmail() + ">>> group: " + member.getGroupid());

		req.setAttribute("member", member);

		req.getRequestDispatcher("my-add")
				.forward(req, resp);
	}

	private boolean isNull(String msg) {
		return ((null == msg) || (msg.trim().length() <= 0));
	}
	
}
