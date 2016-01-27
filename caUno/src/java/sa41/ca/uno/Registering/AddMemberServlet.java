
package sa41.ca.uno.Registering;

import sa41.ca.uno.CreateGroup.Groups;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import sa41.ca.uno.LogInOut.Member;


@WebServlet("/my-add")
public class AddMemberServlet extends HttpServlet {
    
    @Resource(lookup = "jdbc/caUno") private DataSource ds;
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Groups group = new Groups();
	Member member = new Member();
               
        System.out.println(">>> member: " + member 
				+ ", class = " + member.getClass().getName());

	group.add(member);
                
        req.getRequestDispatcher("group.jsp")
		.forward(req, resp);
                
    }
    
}//Class
