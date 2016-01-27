package sa41.game.chat;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import static java.util.Spliterators.iterator;
import static java.util.Spliterators.iterator;
import javax.websocket.*;
import javax.websocket.server.*;
import javax.json.*;
import javax.inject.*;
import javax.enterprise.context.*;
import sa41.ca.uno.ApplicationScopedGameBean;
import sa41.ca.uno.cards;
import sa41.ca.uno.game;
import sa41.ca.uno.player;


@RequestScoped
@ServerEndpoint("/chat/{room}")
public class gameSocket {
    
    private Session session;
    private game gameObj;
    @Inject private gameRooms rooms;
    @Inject private ApplicationScopedGameBean gameBean;
    
    @OnMessage
    public void message(String msg) throws IOException, EncodeException {
        System.out.println(">>>> Client/Player websocket message =" + msg);
        JsonObject reply;
        player pyr = null;
//        System.out.println("=============");
//        for (String s: gameBean.allGameIds())
//            System.out.println(">>> gid = " + s + ", game = " + gameBean.getGameFromMap(s));
        
        JsonReader reader = Json.createReader(new ByteArrayInputStream(msg.getBytes()));
        JsonObject json = reader.readObject();
        String gid = json.getString("room");
        String nam = json.getString("name");
                System.out.println(">>> name = " + json.getString("name"));
		System.out.println(">>> cmd = " + json.getString("message"));
		System.out.println(">>> room = " + gid);
                
                player newPlayer = new player();
        
                newPlayer.setSession(session);//set session in new player
                newPlayer.setName(nam);
                
                
                if (json.getString("message").equals("Join")) {
                    System.out.println(">>> Game object to add player!");
                    
                    gameObj = gameBean.getGameFromMap(gid.trim());
                    System.out.println(">>>Room<<<" + json.getString("room")); 
                    System.out.println(">>>Game<<<" + gameObj);
                    
//                    System.out.println(">>> Game object players to add = " + gameObj.getPlayers().size());
//                    System.out.println(">>> Game object number of players = " + gameObj.getNumPlayers());  
                
                    if (gameObj.getPlayers().size() < (gameObj.getNumPlayers()+1)) {
                        gameObj.add(newPlayer);
                        System.out.println(">>> Game object added players = " + gameObj.getPlayers().size());
                    }
                    
                    
	
                    System.out.println(">>> size = " + gameObj.getPlayers().size());
                    System.out.println(">>> size = " + gameObj.getNumPlayers());
                    
                    if (gameObj.getPlayers().size() == (gameObj.getNumPlayers()+1)){
                        gameObj.initialize();
                        List<player> playerList = gameObj.getPlayers();
                    
                        for (player p: playerList) {

                            ArrayList<cards> hand = p.getHand();
                            pyr = p;
                            System.out.println(p);

                            if (p.getName().equals("GAME TABLE")){
                                    reply = Json.createObjectBuilder()
                                    .add("cmd", "init")
                                    .add("gid", gameObj.getGameID())
                                    .add("card1", gameObj.getDiscardPile().toString())
                                    .add("card2", "back.png")
                                    .add("status", "Play")
                                    .build();
                            }else {

                            reply = Json.createObjectBuilder()
                                    .add("cmd", "init")
                                    .add("gid", gameObj.getGameID())
                                    .add("card1", hand.get(0).toString())
                                    .add("card2", hand.get(1).toString())
                                    .add("card3", hand.get(2).toString())
                                    .add("card4", hand.get(3).toString())
                                    .add("card5", hand.get(4).toString())
                                    .add("card6", hand.get(5).toString())
                                    .add("card7", hand.get(6).toString())
                                    .add("status", "Play")
                                    .build();
                            }  

                            p.getSession().getBasicRemote().sendObject(reply);

                        }//loop through all players to send message
                    
                    }else {
                            reply = Json.createObjectBuilder()
                                    .add("cmd", "init")
                                    .add("gid", gameObj.getGameID())
                                    .add("status", "Waiting")
                                    .build();
                            
                            
                            String room = json.getString("room");
                            rooms.broadcast(room, reply);
                            
                            System.out.println(pyr);
                            
//                     pyr.getSession().getBasicRemote().sendObject(reply);
                    }//test if game loaded and ready to start.
                    
                }//if message == Join

                if (json.getString("message").equals("Draw")) {
                    
                    player p = gameObj.getPlayerByName(nam);
                    reply = Json.createObjectBuilder()
                                    .add("cmd", "draw")
                                    .add("gid", gameObj.getGameID())
                                    .add("card1", gameObj.getGameDeck().drawCard(1).get(0).toString())
                                    .add("status", "Play")
                                    .build();
                    System.out.println(">>>>"+reply);
                    p.getSession().getBasicRemote().sendObject(reply);
                }// if message == Draw
                
                
                if (json.getString("message").equals("Throw")) {
                    
                    player p = gameObj.getPlayerByName("GAME TABLE");
                    reply = Json.createObjectBuilder()
                                    .add("cmd", "throw")
                                    .add("gid", gameObj.getGameID())
                                    .add("card1", json.getString("card1"))
                                    .add("status", "Play")
                                    .build();
                    
                    p.getSession().getBasicRemote().sendObject(reply);
                }// if message == Draw
//        String room = json.getString("room");
//        
//        rooms.broadcast(room, json);
    }//class onMessage
    
    @OnOpen
    public void open(Session s, @PathParam("room") String room) {
        System.out.println(room + ">>>> @OnOpen = " + s.getId());
        
        session = s;
        rooms.add(room, session);
    }
    
    @OnClose
    public void close() {
        System.out.println(">>>> @OnClose = " + session.getId());
    }

    
      
        
    
  
}//Class
