package CardGame;



public interface CardsDealer {
    
    void showDeck();
    
    Card dealRandomCard();
    
    void dealToPlayers(HeartsPlayer player1, HeartsPlayer player2);
    
    void decideWinner(HeartsPlayer player1, HeartsPlayer player2); 
       
         
}
