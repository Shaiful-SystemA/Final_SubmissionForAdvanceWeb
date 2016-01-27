package sa41.ca.uno;

import java.util.*;

public class setDeck {
    
//    private Random mRandom;

    ArrayList<cards> deck = new ArrayList<cards>();

    private static final String[] cardName = {"000b","001b","002b","003b","004b","005b","006b","007b","008b","009b","011b","012b","013b",
                                "101b","102b","103b","104b","105b","106b","107b","108b","109b",    
                         "000y","001y","002y","003y","004y","005y","006y","007y","008y","009y","011y","012y","013y",
                                "101y","102y","103y","104y","105y","106y","107y","108y","109y",
                         "000g","001g","002g","003g","004g","005g","006g","007g","008g","009g","011g","012g","013g",
                                "101g","102g","103g","104g","105g","106g","107g","108g","109g",
                         "000r","001r","002r","003r","004r","005r","006r","007r","008r","009r","011r","012r","013r",
                                "101r","102r","103r","104r","105r","106r","107r","108r","109r",
                         "014","114","214","314","015","115","215","315"};
    
    public setDeck(){
        for (int i = 0; i < cardName.length; i++) {
            
                this.deck.add(new cards(cardName[i]));
        }
        //shuffle the deck when its created
        Collections.shuffle(this.deck);
       
    }//Method
    
    public ArrayList<cards> getDeck(){
        return deck;
    }

      
    public ArrayList<cards> dealCards(int cards2Deal){
        
        if (this.deck.isEmpty()){
            System.out.println("Dealer deck is empty!");
            return null;
        }
            
        ArrayList<cards> temp = new ArrayList<>();
        
        for (int i = 0; i < cards2Deal; i++) {
            
                temp.add(this.deck.remove(i));
        }
        
        return temp;
                
    }//Method
    
    public ArrayList<cards> drawCard(int cards2Draw){
        
        ArrayList<cards> temp = new ArrayList<>();
        
        for (int i = 0; i < cards2Draw; i++) {
            
                temp.add(dealCards(cards2Draw).get(i));
        }
        
        return temp;
    }
    
    public int cardCount() {
        
        return deck.size();
    }//Method
    
    
    public boolean showCard(ArrayList<cards> deck2Show) {
        
        boolean status = false;
        
        if (deck2Show.isEmpty())
                return status;
        
        for (int i = 0; i < deck2Show.size(); i++) {
            
            System.out.println(deck2Show.get(i).toString());
        }
        
        return status = true;
        
    }//Method
    
    
}//Class