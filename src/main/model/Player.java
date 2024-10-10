package model;

import java.util.ArrayList;

public class Player {

    static final int STARTINGBALANCE = 1000;
    int balance;
    String playerName;
    ArrayList<PublicCompany> publicCompaniesOwnership;
    ArrayList<PrivateCompany> privateCompaniesOwnership;
    ArrayList<Transactions> playerTransactions;
    
    /*
    * REQUIRES:
    * playerName has a non-zero length;
    * balance >= 0
    *
    * EFFECTS:
    * creates a new player with name, balance and both private and public company ownership
    */
    public Player(String playerName, int balance){ 
       this.playerName = playerName;
       this.balance = balance;
       publicCompaniesOwnership = new ArrayList<PublicCompany>();
       privateCompaniesOwnership = new ArrayList<PrivateCompany>();
       playerTransactions = new ArrayList<Transactions>();

    }
 
    public String getName(){
       return playerName;
    }
    
    public int getBalance(){
       return balance;
    }

    //EFFECTS: returns the transactions that this player made
    public ArrayList<Transactions> getTransactions(){
        return null; //stub TODO
    }

    //EFFECTS: returns the list of owned publicCompanies
    public ArrayList<PublicCompany> getPublicCompanies(){
       return publicCompaniesOwnership; 
    }

    //EFFECTS: returns the list of owned privateCompanies
    public ArrayList<PrivateCompany> getPrivateCompanies(){
       return privateCompaniesOwnership;
    }

    //REQUIRES:  and company.sharesLeft > 0
    //MODIFIES: this and the specified PublicCompany
    //EFFECTS: buys one share of the specified public company, company sharesLeft--, decrease balance by sharePrice
    public void buyPublicCompany(PublicCompany company){
        publicCompaniesOwnership.add(company);
        balance -= company.getSharePrice();
        company.sharesLeft--;
    }

    //REQUIRES: company.isBought() must be true and company must be within publicCompaniesOwnership
    //MODIFIES: this and the specified PublicCompany
    //EFFECTS: sells one share of the specified public company, company sharesLeft++, increase balance by sharePrice
    public void sellPublicCompany(PublicCompany company){
       for (int i = 0; i < publicCompaniesOwnership.size(); i++) {
            if (publicCompaniesOwnership.get(i) == company) {
                publicCompaniesOwnership.remove(i);
                balance += company.getSharePrice();
                company.sharesLeft++;
            }
       }
    }

    //REQUIRES: company.getPrice() <= player.getBalance() and company.isBought == false
    //MODIFIES: this and the specified PrivateCompany
    /* EFFECTS: 
    sells one share of the specified private company, the company isBought status will be true.
    decreases balance by the price of the company
    */
    public void buyPrivateCompany(PrivateCompany company){
        if (!company.isBought) {
            privateCompaniesOwnership.add(company);
            balance -= company.getPrice();
            company.isBought = true;
       }
    }

    //REQUIRES: company.getPrice() <= player.getBalance()
    //MODIFIES: this and the specified PrivateCompany
    /* EFFECTS: 
    sells one share of the specified private company, the company isBought status will be false.
    increases balance by the price of the company
    */
    public void sellPrivateCompany(PrivateCompany company){
        for (int i = 0; i < privateCompaniesOwnership.size(); i++) {
            if (privateCompaniesOwnership.get(i) == company) {
                privateCompaniesOwnership.remove(i);
                balance += company.getPrice();
                company.isBought = false;
            }
       }
    }


}
