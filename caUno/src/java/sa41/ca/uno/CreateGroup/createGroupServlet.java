package sa41.ca.uno.CreateGroup;

import sa41.ca.uno.CreateGroup.GroupBean;
import sa41.ca.uno.CreateGroup.Groups;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import sa41.ca.uno.groupException;

@WebServlet("/create-group")
public class createGroupServlet extends HttpServlet {

	@Resource(lookup = "jdbc/caUno") private DataSource ds;

	@Inject private Groups grp;
	@EJB private GroupBean sagroupBean;

	@Override
	public void init() throws ServletException { //@PostConstruct
	}

	@Override
	public void destroy() { //@PreDestroy
		super.destroy(); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		//HttpSession session = req.getSession();
		//SAGroup grp = (SAGroup)session.getAttribute("sagroup");

		try {
			//@Stateless
			sagroupBean.createGroup(grp);
		} catch (SQLException | groupException ex) {
			ex.printStackTrace();
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR
					, ex.getMessage());
			return;
		}

		resp.setStatus(HttpServletResponse.SC_ACCEPTED);
		resp.setContentType("text/plain");
		try (PrintWriter pw = resp.getWriter()) {
			pw.println(grp.getName() + " has been created");
		}

	}
}
