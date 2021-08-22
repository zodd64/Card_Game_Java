package CardGame;
import java.util.ArrayList; // import the ArrayList class

public class Deck {
       
    private ArrayList<Card> deck;
    private int deckSize =52,jump=13,jumpBase=13;
    
            
    public Deck(){
        
        this.deck = new ArrayList<>(); // Create an ArrayList object
        
        deck_init();
        
    }
    
    ArrayList<Card> getDeck() {
        return this.deck;
    }
    int getDeckSize() {
        return this.deckSize;
    }

    
    
    
    public void deck_init(){ //initializes the deck
        
        String kind="$"; 
        
        for (int deckPos=0;deckPos<deckSize;deckPos++){

      
            
            if (deckPos==jump-13) 
                
                deck.add (new Card(kind+"A"));
            
            else if(deckPos<jump-3)
                
                deck.add (new Card(kind+String.valueOf(deckPos+14-jump)));
                
            else if(deckPos==jump-3)
                
                deck.add (new Card(kind+"J"));
                
            else if(deckPos==jump+1-3)   

                deck.add (new Card(kind+"Q"));
                
            else if(deckPos==jump+2-3)

                deck.add (new Card(kind+"K"));

            switch(deckPos){    
                case 12 :
                    kind="&";
                    jump+=jumpBase;
                    break;
                case 25:
                    kind="#";
                    jump+=jumpBase;
                    break;
                case 38:
                    kind="%";
                    jump+=jumpBase;
                    break;
                default:
                    break;            
            }
                            


            
            
        }
        
    }
    
}
