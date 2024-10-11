package model;

import java.util.ArrayList;
import java.util.Objects;

public class Game {
    ArrayList<Player> listOfPlayers;
    PublicCompany Tosa = new PublicCompany("Tosa Rail", 100, 10);
    PublicCompany Iya = new PublicCompany("Iya Rail", 100, 10);
    PublicCompany Awa = new PublicCompany("Awa Rail", 100, 10);
    ArrayList<PublicCompany> listOfPublicCompanies;

    PrivateCompany Dogo = new PrivateCompany("Dogo Rail", 60, false);
    PrivateCompany Uno = new PrivateCompany("Uno Rail", 100, false);
    PrivateCompany Ehime = new PrivateCompany("Ehime Rail", 40, false);
    ArrayList<PrivateCompany> listOfPrivateCompanies;

    // EFFECTS: creates a new game with lists of players, public companies and
    // private companies.
    public Game() {

        listOfPlayers = new ArrayList<Player>();

        listOfPublicCompanies = new ArrayList<PublicCompany>();
        listOfPublicCompanies.add(Tosa);
        listOfPublicCompanies.add(Iya);
        listOfPublicCompanies.add(Awa);

        listOfPrivateCompanies = new ArrayList<PrivateCompany>();
        listOfPrivateCompanies.add(Dogo);
        listOfPrivateCompanies.add(Uno);
        listOfPrivateCompanies.add(Ehime);

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

}
