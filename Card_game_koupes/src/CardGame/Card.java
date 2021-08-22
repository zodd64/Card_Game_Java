package CardGame;

public class Card {
    
    public String card;
    
    public Card(String card){
       this.card = card;    
    }
    
    String getCard(){
        return this.card;
    }
    
    void SetCard(String card){
        this.card = card;
    }
    
    @Override
    public String toString() {
        return this.card;
    }
    
}
