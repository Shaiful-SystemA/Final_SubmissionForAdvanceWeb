package sa41.ca.uno;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/game/create")
public class gameCreateServlet extends HttpServlet{
    
    @Inject
    private ApplicationScopedGameBean appGameBean;
    
    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

            HttpSession session=req.getSession();   //From here on is a session scoped.
            game newGame = new game();
            System.out.println("Game Id created: " + newGame.getGameID());
            
            Integer nos_player = Integer.parseInt(req.getParameter("numPlayers")); 
            
            newGame.setNumPlayers(nos_player);
            
            System.out.println("create game add nos_player >>>" + nos_player);
            
            session.setAttribute("gameid", newGame.getGameID());
            appGameBean.addGame2Map(newGame);
            System.out.println(newGame); 


            resp.sendRedirect("gameStart.jsp");

        }//doPost
 
}//Class