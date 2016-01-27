
package sa41.ca.uno.LogInOut;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "logoutServlet", urlPatterns = {"/game/logout"})
public class logoutServlet extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        
        
        req.getRequestDispatcher("../login.html").forward(req, resp);
    }

}
