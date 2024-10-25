package ui;

import model.Game;
import model.Player;
import model.PrivateCompany;
import model.PublicCompany;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// PLEASE NOTE: This LedgerApp was doone while refrencing the Flashcards application.

// A Ledger application that allows the user to add and see transactions made by different players
public class LedgerApp {
     private static final String JSON_STORE = "./data/game.json";
    private List<Player> players;
    private int currentPlayerIndex = 0;

    private Scanner scanner;
    private boolean isProgramRunning;
    private Game game;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: creates an instance of the LedgerApp console ui application
    public LedgerApp() throws FileNotFoundException{
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runLedger();
    }

    public void runLedger() {
        init();

        printDivider();
        System.out.println("Welcome to the Ledger app for Shikoku 1889!");
        printDivider();

        while (this.isProgramRunning) {
            handleMenu();
        }

    }

    // MODIFIES: this
    // EFFECTS: initializes the application with the starting values
    public void init() {

        this.players = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.isProgramRunning = true;
        this.game = new Game();
        game.addAllCompanies();


    }

    // EFFECTS: displays and processes inputs for the main menu
    public void handleMenu() {
        displayMenu();
        String input = this.scanner.nextLine();
        processMenuCommands(input);
    }

    // EFFECTS: displays a list of commands that can be used in the main menu
    public void displayMenu() {
        System.out.println("Please select an option:\n");
        System.out.println("l: Load a game");
        System.out.println("s: Save the game");
        System.out.println("a: Add a new player");
        System.out.println("v: View all players");
        System.out.println("q: Exit the application");
        printDivider();
    }

    // EFFECTS: processes the user's input in the main menu
    public void processMenuCommands(String input) {
        printDivider();
        switch (input) {
            case "l":
                loadGame();
                break;
            case "s":
                saveGame();
                break;
            case "a":
                addNewPlayer();
                break;
            case "v":
                viewPlayers();
                break;
            case "q":
                quitApplication();
                break;
            default:
                System.out.println("Invalid option inputted. Please try again.");
        }
        printDivider();
    }

    // MODIFIES: this
    // EFFECTS: loads game from file
    private void loadGame() {
        try {
            game = jsonReader.read();
            System.out.println("Loaded game from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
        
        // players = game.getListOfPlayers();
    }

    // EFFECTS: saves the game to file
    private void saveGame() {
        try {
            jsonWriter.open();
            jsonWriter.write(game);
            jsonWriter.close();
            System.out.println("Saved game to" + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a player to the list of players
    public void addNewPlayer() {
        System.out.println("Please enter the player's name:");
        String playerName = this.scanner.nextLine();

        System.out.println("\nPlease enter starting balance");
        int startingBalance = this.scanner.nextInt();

        Player player = new Player(playerName, startingBalance);

        this.players.add(player);
        game.getListOfPlayers().add(player);

        System.out.println("\nNew player successfully created!");
    }

    // MODIFIES: this
    // EFFECTS: displays all player one at a time
    public void viewPlayers() {
        displayGivenPlayers(game.getListOfPlayers());
    }

    // MODIFIES: this
    // EFFECTS: displays the given list of players and handles inputs related to
    // viewing the players
    public void displayGivenPlayers(List<Player> players) {
        if (players.isEmpty()) {
            System.out.println("Error: No players. Try adding a player first!");
            return;
        }

        displayViewMenu();
        String input = "";
        while (!input.equals("q")) {
            Player currentPlayer = players.get(this.currentPlayerIndex);
            displayPlayer(currentPlayer);
            input = this.scanner.nextLine();
            handleViewCommands(input, players);
        }
        this.currentPlayerIndex = 0;
    }

    // EFFECTS: displays a list of commands that can be used in the view player menu
    public void displayViewMenu() {
        System.out.println("Enter 't' to display the transaction list");
        System.out.println("Enter 'u' to buy a Public company");
        System.out.println("Enter 'r' to buy a Private company");
        System.out.println("Enter 'l' to sell a Public company");
        System.out.println("Enter 'i' to sell a Private company");
        System.out.println("Enter 'b' to see player balance");
        System.out.println("Enter 'c' to check holdings of public companies");
        System.out.println("Enter 'e' to check holdings of private companies");
        System.out.println("Enter 'm' to move to the next player.");
        System.out.println("Enter 'n' to move to the previous player.");
        System.out.println("Enter 'q' to return to the menu.");
    }

    // EFFECTS: displays the given player
    public void displayPlayer(Player player) {
        printDivider();
        System.out.println("Player " + player.getName());
    }

    // MODIFIES: this
    // EFFECTS: processes the user's input in the view flashcards menu
    public void handleViewCommands(String input, List<Player> players) {
        System.out.print("\n");

        Player currentPlayer = players.get(this.currentPlayerIndex);
        switch (input) {
            case "t":
                displayTransactions(currentPlayer);
                break;
            case "u":
                buyPublicCompany(currentPlayer);
                break;
            case "r":
                buyPrivateCompany(currentPlayer);
                break;
            case "l":
                sellPublicCompany(currentPlayer);
                break;
            case "i":
                sellPrivateCompany(currentPlayer);
            case "b":
                checkBalance(currentPlayer);
                break;
            case "c":
                checkPublicCompanyHoldings(currentPlayer);
                break;
            case "e":
                checkPrivateCompanyHoldings(currentPlayer);
                break;
            case "m":
                getNextPlayer(players);
                break;
            case "n":
                getPreviousPlayer();
                break;
            case "q":
                System.out.println("Returning to the menu...");
                break;
            default:
                System.out.println("Invalid option inputted. Please try again.");
        }
    }

    // EFFECTS: displays all the transactions that the player made
    public void displayTransactions(Player player) {
        System.out.println("Answer: " + player.getTransactions().toString());
    }

    // EFFECTS: displays the balance of the player
    public void checkBalance(Player player) {
        System.out.println("Balance: " + player.getBalance());
    }

    public void checkPublicCompanyHoldings(Player player) {
        System.out.println(player.getPublicCompanies().toString());
    }

    public void checkPrivateCompanyHoldings(Player player) {
        System.out.println(player.getPrivateCompanies().toString());
    }

    // MODIFIES: company, player
    // EFFECTS: player buys the given public company then returns to player page
    public void buyPublicCompany(Player player) {

        System.out.println("Please enter the company name");
        String input1 = "";
        input1 = this.scanner.nextLine();

        ArrayList<PublicCompany> list = this.game.getListofPublicCompanies();

        for (PublicCompany company : list) {
            if (company.getName().equalsIgnoreCase(input1)) {
                player.buyPublicCompany(company);
                System.out.println("Player " + player.getName() + " bought " + company.getName() + " at $"
                        + company.getSharePrice() + "!");
                return; // return back to player page
            }
        }

    }

    // REQUIRES: PrivateCompany chosen isBought is false
    // MODIFIES: company, player
    // EFFECTS: player buys the given private company then returns to player page
    public void buyPrivateCompany(Player player) {

        System.out.println("Please enter the company name");
        String input1 = "";
        input1 = this.scanner.nextLine();

        ArrayList<PrivateCompany> list = this.game.getListofPrivateCompanies();

        for (PrivateCompany company : list) {
            if (company.getName().equalsIgnoreCase(input1)) {
                player.buyPrivateCompany(company);
                System.out.println("Player " + player.getName() + " bought " + company.getName() +
                        " at $" + company.getPrice() + " !");
                return; // go back to menu
            }
        }
    }

    // REQUIRES: PrivateCompany chosen isBought is true
    // MODIFIES: company, player
    // EFFECTS: player sells the given public company then returns to player page
    public void sellPublicCompany(Player player) {

        System.out.println("Please enter the company name");
        String input1 = "";
        input1 = this.scanner.nextLine();

        ArrayList<PublicCompany> list = this.game.getListofPublicCompanies();

        for (PublicCompany company : list) {
            if (company.getName().equalsIgnoreCase(input1)) {
                player.sellPublicCompany(company);
                System.out.println("Player " + player.getName() + " sold " + company.getName() + " at $"
                        + company.getSharePrice() + " !");
                return; // go back to menu
            }
        }

    }

    // MODIFIES: company, player
    // EFFECTS: player sell the given private company then returns to player page
    public void sellPrivateCompany(Player player) {

        System.out.println("Please enter the company name");
        String input1 = "";
        input1 = this.scanner.nextLine();

        ArrayList<PrivateCompany> list = this.game.getListofPrivateCompanies();

        for (PrivateCompany company : list) {
            if (company.getName().equalsIgnoreCase(input1)) {
                player.sellPrivateCompany(company);
                System.out.println("Player " + player.getName() + " sold " + company.getName() +
                        " at $" + company.getPrice() + " !");
                return;
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: if there is another player to display, increments the current
    // player index
    public void getNextPlayer(List<Player> players) {
        if (this.currentPlayerIndex >= players.size() - 1) {
            System.out.println("Error: No more new players to display!");
        } else {
            this.currentPlayerIndex++;
        }
    }

    // MODIFIES: this
    // EFFECTS: if there is a previous player to display, decrements the current
    // player index
    public void getPreviousPlayer() {
        if (this.currentPlayerIndex <= 0) {
            System.out.println("Error: No more previous player to display!");
        } else {
            this.currentPlayerIndex--;
        }
    }

    // MODIFIES: this
    // EFFECTS: prints a closing message and marks the program as not running
    public void quitApplication() {
        System.out.println("Thanks for using the Ledger app for Shikoku 1889!");
        System.out.println("Have a good day :))");
        this.isProgramRunning = false;
    }

    // EFFECTS: prints out a line of dashes to act as a divider
    private void printDivider() {
        System.out.println("------------------------------------");
    }
}
