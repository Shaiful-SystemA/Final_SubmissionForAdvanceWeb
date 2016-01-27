package sa41.ca.uno;

public class cards {

    private String name;
    private int value;
    
    public cards() {
        
    }

    public cards(String Name) {
        this.name = Name;
    }

    public String getName() {
        return name;
    }
   
    public int getValue() {
        return value;
    }
    
//    @Override
//    public boolean equals(Object o) {
//        return (o != null && o instanceof Card && ((Card) o).name == name && ((Card) o).col == col);
//    }

    public String toString(){
        
        return (new StringBuilder().append(name.substring(1)).append(".png").toString());
    }
    
}//Class
