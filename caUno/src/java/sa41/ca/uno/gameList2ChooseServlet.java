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


@WebServlet("/game/player")
public class gameList2ChooseServlet extends HttpServlet{
    
    @Inject
    private ApplicationScopedGameBean appGameBean;
    
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

             appGameBean.showAllGameIDFromMap();
            
            req.getRequestDispatcher("game2Choose.jsp")
                        .forward(req, resp);

    }//doGet
 


}//Class