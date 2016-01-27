package sa41.ca.uno;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;


@Named
@ApplicationScoped
public class ApplicationScopedGameBean {
    
    // Create a hash map
    private Map<String, game>  gameMap;
    
    @PostConstruct
    public void init() {
        //initialize the map and it's data
        gameMap = new ConcurrentHashMap<>();
    }
    
    public Map<String, game> getMap() {
        return this.gameMap;
    }

    public void addGame2Map(game gioco) {
        // Put elements to the map
        gameMap.put(gioco.getGameID(), gioco);
    }
    
    public Set<String> allGameIds() {
        return (gameMap.keySet());
    }
    
    public game getGameFromMap(String gameID) {
        // Get elements to the map
        
        return gameMap.get(gameID);
    }
    
    public List<game> getAllGameIDFromMap() {
        
        List<game> valueList = new ArrayList<game>(gameMap.values());
	System.out.println("\n==> Size of Value list: " + valueList.size());
            for (game temp : valueList) {
                    System.out.println("GameID >>>" + temp.getGameID());
                    System.out.println("NumPlayers >>>" + temp.getNumPlayers());
                    System.out.println("getPlayers >>>" + temp.getPlayers());
                    System.out.println("getGameDeck >>>" + temp.getGameDeck());
            }
        
        return (valueList);
        
    }
    
    public void showAllGameIDFromMap() {
        
        for (game item : getAllGameIDFromMap()) {
            System.out.println(item);
        }
    
    }
 

   
}//Class