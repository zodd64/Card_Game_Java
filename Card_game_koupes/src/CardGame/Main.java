/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardGame;

public class Main {


    
    public static void main(String[] args) {
        
        HeartsPlayer player1 = new HeartsPlayer("Odysseas","Vlamakis",29,"Master Satchel");
        HeartsPlayer player2 = new HeartsPlayer("Giwrgos","Gewrgiou",7,"Zidane");
        new HeartsDealer("Klevis","Tokoglufoglou",33,"Dealer",player1,player2);
        

    }
}