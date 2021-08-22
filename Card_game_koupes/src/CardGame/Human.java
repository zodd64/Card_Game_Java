/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardGame;

/**
 *
 * @author omnislasher
 */
abstract class Human {
    
    private String fName,lName,nickname;
    private int age;
    
    
    void introduceSelf() {}
        
    
    
    void setfName(String fName) {
        this.fName = fName;
    }
    
    String getfName() {
        return this.fName;
    }
    
    
    void setlName(String lName) {
        this.lName = lName;
    }
    
    String getlName() {
        return this.lName;
        
        
    }    void setAge(int age) {
        this.age = age;
    }
    
    int getAge() {
        return this.age;
    }
    
    void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    String getNickname() {
        return this.nickname;
    }
}
