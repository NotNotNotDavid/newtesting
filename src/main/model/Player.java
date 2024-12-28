package model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import persistence.Writable;

public class Player implements Writable {

    // static final int STARTINGBALANCE = 1000;
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
     * creates a new player with name, balance and both private and public company
     * ownership
     */
    public Player(String playerName, int balance) {
        this.playerName = playerName;
        this.balance = balance;
        publicCompaniesOwnership = new ArrayList<PublicCompany>();
        privateCompaniesOwnership = new ArrayList<PrivateCompany>();
        playerTransactions = new ArrayList<Transactions>();

    }

    public String getName() {
        return playerName;
    }

    public int getBalance() {
        return balance;
    }

    public void addTransaction(Transactions transaction) {
        playerTransactions.add(transaction);
    }

    public void addPublicCompany(PublicCompany publicCompany) {
        publicCompaniesOwnership.add(publicCompany);
    }

    public void addPrivateCompany(PrivateCompany privateCompany) {
        privateCompaniesOwnership.add(privateCompany);
    }

    // EFFECTS: returns the transactions that this player made
    public ArrayList<Transactions> getTransactions() {
        EventLog.getInstance().logEvent(new Event("Player: " + this.getName() 
                + " accessed their transactions: " + playerTransactions));
        return playerTransactions;
    }

    // EFFECTS: returns the list of owned publicCompanies
    public ArrayList<PublicCompany> getPublicCompanies() {
        return publicCompaniesOwnership;
    }

    // EFFECTS: returns the list of owned privateCompanies
    public ArrayList<PrivateCompany> getPrivateCompanies() {
        return privateCompaniesOwnership;
    }

    // MODIFIES: whatever the company type is
    // EFFECTS: uses the helper methods, look for specifications there
    public void buyCompany(Company company) {
        if (company instanceof PublicCompany) {
            buyPublicCompany((PublicCompany) company);
        }
        if (company instanceof PrivateCompany) {
            buyPrivateCompany((PrivateCompany) company);
        }
    }

    // MODIFIES: whatever the company type is
    // EFFECTS: uses the helper methods, look for specifications there
    public void sellCompany(Company company) {
        if (company instanceof PublicCompany) {
            sellPublicCompany((PublicCompany) company);
        }
        if (company instanceof PrivateCompany) {
            sellPrivateCompany((PrivateCompany) company);
        }
    }


    // REQUIRES: and company.sharesLeft > 0
    // MODIFIES: this and the specified PublicCompany
    // EFFECTS: buys one share of the specified public company, company
    // sharesLeft--, decrease balance by sharePrice
    public void buyPublicCompany(PublicCompany company) {
        publicCompaniesOwnership.add(company);
        balance -= company.getPrice();
        company.sharesLeft--;
        playerTransactions.add(new Transactions(playerName, company.price, company.companyName, "buy"));
        EventLog.getInstance().logEvent(new Event("Player: " + this.getName() + " bought public company: " + company));
    }

    // REQUIRES: company.isBought() must be true and company must be within
    // publicCompaniesOwnership
    // MODIFIES: this and the specified PublicCompany
    // EFFECTS: sells one share of the specified public company, company
    // sharesLeft++, increase balance by sharePrice
    public void sellPublicCompany(PublicCompany company) {
        for (int i = 0; i < publicCompaniesOwnership.size(); i++) {
            if (publicCompaniesOwnership.get(i) == company) {
                publicCompaniesOwnership.remove(i);
                balance += company.getPrice();
                company.sharesLeft++;
                playerTransactions.add(new Transactions(playerName, company.price, company.companyName, "sell"));
                EventLog.getInstance().logEvent(new Event("Player: " + this.getName() 
                        + " sold public company: " + company));

            }
        }
    }

    // REQUIRES: company.getPrice() <= player.getBalance() and company.isBought ==
    // false
    // MODIFIES: this and the specified PrivateCompany
    /*
     * EFFECTS:
     * sells one share of the specified private company, the company isBought status
     * will be true.
     * decreases balance by the price of the company
     */
    public void buyPrivateCompany(PrivateCompany company) {
        if (!company.isBought) {
            privateCompaniesOwnership.add(company);
            balance -= company.getPrice();
            company.isBought = true;
            playerTransactions.add(new Transactions(playerName, company.price, company.companyName, "buy"));
            EventLog.getInstance().logEvent(new Event("Player: " + this.getName() 
                    + " bought private company: " + company));

        }
    }

    // REQUIRES: company.getPrice() <= player.getBalance()
    // MODIFIES: this and the specified PrivateCompany
    /*
     * EFFECTS:
     * sells one share of the specified private company, the company isBought status
     * will be false.
     * increases balance by the price of the company
     */
    public void sellPrivateCompany(PrivateCompany company) {
        for (int i = 0; i < privateCompaniesOwnership.size(); i++) {
            if (privateCompaniesOwnership.get(i) == company) {
                privateCompaniesOwnership.remove(i);
                balance += company.getPrice();
                company.isBought = false;
                playerTransactions.add(new Transactions(playerName, company.price, company.companyName, "sell"));
                EventLog.getInstance().logEvent(new Event("Player: " + this.getName() 
                        + " sold private company: " + company));

            }
        }
    }

    @Override
    public JSONObject toJson() {

        JSONObject json = new JSONObject();
        json.put("playerName", playerName);
        json.put("balance", balance);

        JSONArray publicCompaniesJson = new JSONArray();
        for (PublicCompany pc : publicCompaniesOwnership) {
            publicCompaniesJson.put(pc.toJson());
        }
        json.put("publicCompaniesOwnership", publicCompaniesJson);

        JSONArray privateCompaniesJson = new JSONArray();
        for (PrivateCompany pc : privateCompaniesOwnership) {
            privateCompaniesJson.put(pc.toJson());
        }
        json.put("privateCompaniesOwnership", privateCompaniesJson);

        JSONArray transactionsJson = new JSONArray();
        for (Transactions t : playerTransactions) {
            transactionsJson.put(t.toJson());
        }
        json.put("transactions", transactionsJson);
        return json;
    }

    // public void addPublicCompany(PublicCompany publicCompany) {
    // this.publicCompanyList.add(publicCompany);
    // }

    // public void addPrivateCompany(PrivateCompany privateCompany) {
    // this.privateCompaniesOwnership.add(privateCompany);
    // }

    // public void addTransaction(Transactions transactionJsonObject) {
    // this.playerTransactionsList.add(transactionJsonObject);
    // }

}
