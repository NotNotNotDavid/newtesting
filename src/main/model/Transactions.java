package model;

import java.util.Objects;

public class Transactions {

    String playerName;
    int price;
    String companyName;
    String action;

    /*
     * REQUIRES:
     * player company and action to have a non-zero length;
     * EFFECTS:
     * creates a transaction with the player's name,
     * the company it traded and what action it did with said company.
     */

    public Transactions(String player, int price, String company, String action) {
        this.playerName = player;
        this.price = price;
        this.companyName = company;
        this.action = action;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAction() {
        return action;
    }

    public int getPrice() {
        return price;
    }

    // THIS PART IS LEARNED FROM OTHER SOURCES, SEE README FILE
    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        // If the object is compared with null then return false
        if (o == null) {
            return false;
        }

        // Check if o is an instance of Transaction or not
        if (getClass() != o.getClass()) {
            return false;
        }

        // type casting o to Transactions to compare data members
        Transactions t = (Transactions) o;

        // this line is to comapre all the different instances of objects
        return price == t.price 
            && Objects.equals(playerName, t.playerName) 
            && Objects.equals(companyName, t.companyName) 
            && Objects.equals(action, t.action);
    }

    @Override
    public String toString() {
        return "Transaction[" +
                "Player: " + playerName + ", Price: " + price +
                ", Company: " + companyName + ", Action: " + action + "]";
    }

}
