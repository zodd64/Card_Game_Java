package CardGame;

import java.sql.*;
import java.util.ArrayList;

public class HeartsPlayer extends Human implements CardsPlayer {
       
    private int handPos=0,handSize=5, points=0;    
    public ArrayList<Card> hand; 
    
    public  HeartsPlayer(String fName,String lName,int age,String nickname){
        super.setfName(fName);
        super.setlName(lName);
        super.setAge(age);
        super.setNickname(nickname);
        this.hand = new ArrayList<>();
        introduceSelf();
        
        
    }
    
    public int getHandSize() {
        return this.handSize;
    }
    
    public int getPoints(){
        return this.points;
    }
    
    public void setPoints(int points){
        this.points=points;
    }
        
    @Override
    public void introduceSelf() {
        System.out.println("-------------------------");
        System.out.println(this.getNickname()+"'s Info");
        System.out.println("-------------------------");
        System.out.println(this.getfName());
        System.out.println("-------------------------");
        System.out.println(this.getlName());
        System.out.println("-------------------------");
        System.out.println(this.getAge());
    }

    @Override
    public void showHand() {
        System.out.println("-------------------------");
        System.out.println("Player "+this.getNickname()+" has these cards");
        System.out.println("-------------------------");
        
        for(handPos=0;handPos<hand.size();handPos++)
            System.out.println(hand.get(handPos));
        

    }
    
    public void updateScoreboard(){
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
        String query = "INSERT INTO Highscore (nickname,points)"
                + " VALUES ('"+getNickname()+"','"+points+"')";
        int x = stmt.executeUpdate(query);
        System.out.println(x + "Rows inserted");
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
    
}
