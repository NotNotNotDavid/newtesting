package model;

import java.util.ArrayList;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONObject;

import persistence.Writable;

public class Game implements Writable {

    ArrayList<Player> listOfPlayers;

    ArrayList<PublicCompany> listOfPublicCompanies;

    ArrayList<PrivateCompany> listOfPrivateCompanies;

    PublicCompany tosa = new PublicCompany("Tosa Rail", 100, 10);
    PublicCompany iya = new PublicCompany("Iya Rail", 100, 10);
    PublicCompany awa = new PublicCompany("Awa Rail", 100, 10);

    PrivateCompany dogo = new PrivateCompany("Dogo Rail", 60, false);
    PrivateCompany uno = new PrivateCompany("Uno Rail", 100, false);
    PrivateCompany ehime = new PrivateCompany("Ehime Rail", 40, false);

    // EFFECTS: creates a new game with lists of players, public companies and
    // private companies.
    public Game() {

        listOfPlayers = new ArrayList<Player>();
        listOfPublicCompanies = new ArrayList<PublicCompany>();
        listOfPrivateCompanies = new ArrayList<PrivateCompany>();

    }

    // MODIFIES: this
    // EFFECTS: adds all the companies to the game
    public void addAllCompanies() {

        listOfPublicCompanies.add(tosa);
        listOfPublicCompanies.add(iya);
        listOfPublicCompanies.add(awa);
        listOfPrivateCompanies.add(dogo);
        listOfPrivateCompanies.add(uno);
        listOfPrivateCompanies.add(ehime);

    }

    // MODIFIES: this
    // EFFECTS: Adds a player to the game
    public void addPlayer(Player player) {
        this.listOfPlayers.add(player);
        EventLog.getInstance().logEvent(new Event("Added player: " + player.getName() + " with $" + player.getBalance()));
    }

    public ArrayList<PublicCompany> getListofPublicCompanies() {
        return listOfPublicCompanies;
    }

    public ArrayList<PrivateCompany> getListofPrivateCompanies() {
        return listOfPrivateCompanies;
    }

    public ArrayList<Player> getListOfPlayers() {
        return listOfPlayers;
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

        // Check if o is an instance of game or not
        if (getClass() != o.getClass()) {
            return false;
        }

        // type casting o to Transactions to compare data members
        Game g = (Game) o;

        // this line is to comapre all the different instances of objects
        return Objects.equals(listOfPlayers, g.listOfPlayers)
                && Objects.equals(listOfPublicCompanies, g.listOfPublicCompanies)
                && Objects.equals(listOfPrivateCompanies, g.listOfPrivateCompanies);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        JSONArray publicCompanyArray = new JSONArray();
        for (PublicCompany company : listOfPublicCompanies) {
            publicCompanyArray.put(company.toJson());
        }

        JSONArray privateCompanyArray = new JSONArray();
        for (PrivateCompany company : listOfPrivateCompanies) {
            privateCompanyArray.put(company.toJson());
        }

        JSONArray playersArray = new JSONArray();
        for (Player player : listOfPlayers) {
            playersArray.put(player.toJson());
        }

        json.put("publicCompanies", publicCompanyArray);
        json.put("privateCompanies", privateCompanyArray);
        json.put("players", playersArray);

        return json;
    }

    // MODIFIES: this
    // EFFECTS: Adds a public company to the game
    public void addPublicCompany(PublicCompany publicCompany) {
        this.listOfPublicCompanies.add(publicCompany);
    }

    // MODIFIES: this
    // EFFECTS: Adds a private company to the game
    public void addPrivateCompany(PrivateCompany privateCompany) {
        this.listOfPrivateCompanies.add(privateCompany);
    }

}
