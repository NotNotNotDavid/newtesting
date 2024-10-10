package model;

import java.util.ArrayList;

public class Player {

    public Player(String playerName, int balance){ 
       //stub
    }
 
    public String getName(){
       return ""; //stub
    }
    
    public int getBalance(){
       return 0; //stub
    }

    //EFFECTS: returns the list of owned publicCompanies
    public ArrayList<PublicCompany> getPublicCompanies(){
       return null; //stub
    }

    //EFFECTS: returns the list of owned privateCompanies
    public ArrayList<PrivateCompany> getPrivateCompanies(){
       return null; //stub
    }

    //REQUIRES: company.getPrice() <= player.getBalance()
    //MODIFIES: this and the specified PublicCompany
    //EFFECTS: buys one share of the specified public company, company sharesBought++, decrease balance by sharePrice
    public void buyPublicCompany(PublicCompany company){
       //stub
    }

    //REQUIRES: company.isBought() must be true
    //MODIFIES: this and the specified PublicCompany
    //EFFECTS: sells one share of the specified public company, company sharesBought--, increase balance by sharePrice
    public void sellPublicCompany(PublicCompany company){
       //stub
    }

    //REQUIRES: company.getPrice() <= player.getBalance()
    //MODIFIES: this and the specified PrivateCompany
    /* EFFECTS: 
    sells one share of the specified private company, the company isBought status will be true.
    decreases balance by the price of the company
    */
    public void buyPrivateCompany(PrivateCompany company){
       //stub
    }

    //REQUIRES: company.getPrice() <= player.getBalance()
    //MODIFIES: this and the specified PrivateCompany
    /* EFFECTS: 
    sells one share of the specified private company, the company isBought status will be false.
    increases balance by the price of the company
    */
    public void sellPrivateCompany(PrivateCompany company){
       //stub
    }


}
