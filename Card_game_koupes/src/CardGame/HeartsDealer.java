package CardGame;
import java.util.ArrayList;
import java.util.Collections;
import java.sql.*;

public class HeartsDealer extends Human implements CardsDealer{
    
    private Deck deck;
    private int handSize,players = 2,rand,x,p1Koupes=0,p2Koupes=0,round=1;
    private HeartsPlayer player1,player2;
    
    public HeartsDealer(String fName,String lName,int age,String nickname, HeartsPlayer player1,HeartsPlayer player2){
        
        this.player1 = player1;
        this.player2 = player2;
        super.setfName(fName);
        super.setlName(lName);
        super.setAge(age);
        super.setNickname(nickname); 
        handSize = player1.getHandSize(); // gets HandSize value
        deck  = new Deck(); //creating a new Deck object called deck
        introduceSelf(); //introduces dealer
        
        Collections.shuffle(deck.getDeck()); //shuffles deck (disable for sorted deck elements)
        
        showDeck(); //shows deck
        dealToPlayers(player1,player2); //gives 5 cards to each player
        player1.showHand(); //shows p1hand
        player2.showHand(); //shows p2hand
        decideWinner(player1,player2);
        endCast();
                    
    }
    

    
    @Override
    public void showDeck() {
        
        System.out.println("-------------------------");
        System.out.println("These are the deck cards");
        System.out.println("-------------------------");
        
        for (int deckPos=0; deckPos < deck.getDeck().size(); deckPos++){
            
            System.out.println(deck.getDeck().get(deckPos));                
            
        }
        
    }

    @Override
    public Card dealRandomCard() {
            
        rand = (int) ( Math.random() * deck.getDeck().size() );
                        
        return deck.getDeck().get(rand);
    }

    @Override
    public void dealToPlayers(HeartsPlayer player1, HeartsPlayer player2) {
        
        for(x=0;x<handSize;x++){    
        
            
            player1.hand.add  (deck.getDeck().get(0));
            deck.getDeck().remove  (0);
            
            player2.hand.add  (deck.getDeck().get(0));
            deck.getDeck().remove  (0);
        
        }
    }
    
    /*    @Override  
    public void dealToPlayers(HeartsPlayer player1, HeartsPlayer player2) { //random deal
        
        for(x=0;x<handSize;x++){    
        
            rand = (int) ( Math.random() * deck.deck.size() );
            player1.hand.add  (deck.deck.get(rand));
            deck.deck.remove  (rand);
            
            rand = (int) ( Math.random() * deck.deck.size() );
            player2.hand.add  (deck.deck.get(rand));
            deck.deck.remove  (rand);
        
        }
    }*/

    @Override
    public void decideWinner(HeartsPlayer player1, HeartsPlayer player2) {
        
        Card temp,temp2;
        
        for(int x=0; x<handSize;x++){
            
            temp=player1.hand.get(x);
            temp2=player2.hand.get(x);
            
            if(temp.card.substring(0,1).equals("#"))
                p1Koupes++;
            
            if(temp2.card.substring(0,1).equals("#"))
                p2Koupes++;
        }
        
        //System.out.println("-------------------------");
        
        if (p1Koupes>p2Koupes){
            //System.out.println(player1.getNickname()+" has won with "+p1Koupes+" Koupes!!");
            player1.setPoints(player1.getPoints()+(p1Koupes-p2Koupes)*10);
        }
        
        else if(p2Koupes>p1Koupes){
            //System.out.println(player2.getNickname()+" has won with "+p2Koupes+" Koupes!!");
            player2.setPoints(player2.getPoints()+(p2Koupes-p1Koupes)*10);
        }
      
        while(round++<5){ //gia na paiksei 5 gurous
                        
            player1.hand.clear();
            player2.hand.clear();
            Collections.shuffle(deck.getDeck());
            showDeck(); //shows deck
            dealToPlayers(player1,player2); //gives 5 cards to each player
            player1.showHand(); //shows p1hand
            player2.showHand(); //shows p2hand
            decideWinner(player1,player2);            
            
        }
        
    }


        @Override
    void introduceSelf() {
        
        System.out.println("-------------------------");
        System.out.println(this.getNickname()+"'s Info");
        System.out.println("-------------------------");
        System.out.println(this.getfName());
        System.out.println("-------------------------");
        System.out.println(this.getlName());
        System.out.println("-------------------------");
        System.out.println(this.getAge());
    }
    
    public void showHighscore(){
        
        int x=1;
        //database stuff
        Connection con = null;
        try {
        // db parameters
        String url       = "jdbc:mysql://localhost:3306/koupa";
        String user      = "root";
        String password  = "";
	
        // create a connection to the database
        con = DriverManager.getConnection(url, user, password);
        System.out.println("Connection established succesfully!");
        
        Statement stmt = con.createStatement();
        String query = "Select * FROM Highscore ORDER BY points DESC";
        ResultSet rs = stmt.executeQuery(query);
        
        while(rs.next()){
            String highscorer = rs.getString("nickname");
            int score = rs.getInt("points");
            
            System.out.println(x+") "+highscorer+" "+score);
            x++;
        }
        
        stmt.close();
        
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        
        } finally {
            try{
            if(con != null)
                con.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        }
    
    void endCast(){
        
        System.out.println("-------------------------");  
        
        if(player1.getPoints()>player2.getPoints())
            System.out.println(player1.getNickname()+" has won with "+player1.getPoints()+" Points!!");
        
        else if(player2.getPoints()>player1.getPoints())
            System.out.println(player2.getNickname()+" has won with "+player2.getPoints()+" Points!!");
        else 
            System.out.println("It's a Draw!!");
        player1.updateScoreboard();
        player2.updateScoreboard();
        showHighscore();
    }

}

