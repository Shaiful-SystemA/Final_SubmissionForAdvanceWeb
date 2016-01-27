package sa41.ca.uno;


import java.util.ArrayList;
import javax.websocket.Session;

public class player { //HOW TO GET NAME? >>> From session.remoteUser
    
    private ArrayList<cards> hand = null;
    private String name = null;
    private String game2Join = null;
    private Session session = null; //GET FROM WEBCHAT
    
    public player(){
        
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGame2Join() {
        return game2Join;
    }

    public void setGame2Join(String game2Join) {
        this.game2Join = game2Join;
    }
    
    public ArrayList<cards> add2Hand(cards card) {
        if (hand == null)
            hand = new ArrayList<cards>();
        
        getHand().add(card);
        return hand;
    }
    
    public ArrayList<cards> throwCard(cards card) {
        if (hand == null)
            hand = new ArrayList<cards>();
        
        getHand().remove(card);
        return hand;
    }
    
    public int cardCount() {
        return hand.size();
    }
    
    public ArrayList<cards> getHand(){
        return hand;
    }
    
    public void setHand(ArrayList<cards> cardsAtHand){
        hand = cardsAtHand;
    }
    
    public void showHand() {
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(hand.get(i).toString());
        }
    }
    
}//Class
