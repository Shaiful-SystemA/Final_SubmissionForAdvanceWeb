
package sa41.ca.uno;

import java.util.LinkedList;
import java.util.Scanner;
import java.lang.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.smartcardio.Card;
import javax.websocket.Session;

public class game {

    private setDeck gameDeck = new setDeck();
    private List<player> players = new LinkedList<>();
    private cards discardPile;
    private int numCards2Deal;
    private int numCards2Init = 7;
    private int numPlayers;
    private final String gameID;
    private Session session;
    

    public game() {
        gameID = UUID.randomUUID().toString().replaceAll("-","");
    }

    public cards getDiscardPile() {
        return discardPile;
    }

    public void setDiscardPile(cards discardPile) {
        this.discardPile = discardPile;
    }

    public int getNumCards2Deal() {
        return numCards2Deal;
    }

    public void setNumCards2Deal(int numCards2Deal) {
        this.numCards2Deal = numCards2Deal;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }
    
    public void add(player p) {
        players.add(p);
    }

    public setDeck getGameDeck() {
        return gameDeck;
    }

    public String getGameID() {
        return gameID;
    }
    
    public List<player> getPlayers() {
        return (players);
    }
    
    public List<String> getPlayersNames() {
        
        List<String> temp = new ArrayList<>();
        for(player p: players)
            temp.add(p.getName());
        return (temp);
    }
    
    public player getPlayerByName(String Name) {
        
        for(player p: players) {
            if (p.getName().equals(Name))
                return(p);
        }
        
        return null;
    }
    
    public void setPlayers(List<player> p) { }
    
    public void initialize() {
        
        numPlayers = players.size();
        for (int i = 0; i < numPlayers; i++) {
            
            if (players.get(i).getName().equals("GAME TABLE"))
                    players.get(i).add2Hand(gameDeck.dealCards(1).get(0));
            
            for (int j = 0; j < numCards2Init; j++){
               players.get(i).add2Hand(gameDeck.dealCards(1).get(0));
            }
        }
        
        this.setDiscardPile(gameDeck.dealCards(1).get(0));
    }//initialise
    
    public void showPlayersHand() {
        
        for (int i = 0; i < numPlayers; i++) {
            
            System.out.format("Hand for player: %d%n", i);
            players.get(i).showHand();
            }
    }//showPlayersHand
    
    public void showPlayerCount(int num) {
        
        players.get(num).getHand().size();
    }
    
    public int showDeckCount() {
        
        System.out.format("Game deck card left: %d%n", gameDeck.cardCount());
        
        return gameDeck.cardCount();
        
    }//showDeckCount

    public static void main(String[] args) {
        game g = new game();
        

        System.out.println("Please enter no of players");
        Scanner scan = new Scanner(System.in);

        int numPlayers = scan.nextInt();
        System.out.println(numPlayers);
        
        for (int i = 0; i < numPlayers; i++) {
            
            player p = new player();
            g.add(p);
        }
            g.initialize();
            g.showPlayersHand();
            g.showDeckCount();
            
        System.out.println("Game ID = " + g.getGameID());

    }//main



    
}//Class
