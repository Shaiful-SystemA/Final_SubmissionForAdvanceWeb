package sa41.ca.uno;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;

@WebServlet(urlPatterns = {"/game/joinPlayer"})
public class gameJoinPlayer extends HttpServlet {
    
    private Session session;
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
            String game_id = req.getParameter("gid"); //get selected game id
            System.out.println("playerJoinGame >>>" + game_id);
            
            if (game_id == null)
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            
            req.setAttribute("game_id", game_id); //set to gameOn webSocket
        
            req.getRequestDispatcher("/game/gameOn.html")
                        .forward(req, resp);
        
    }
    
}
