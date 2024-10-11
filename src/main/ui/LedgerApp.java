package ui;


import model.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// PLEASE NOTE: This LedgerApp was doone while refrencing the Flashcards application.

// A Ledger application that allows the user to add and see transactions made by different players
public class LedgerApp {
    private List<Player> players;
    private int currentPlayerIndex = 0;

    private Scanner scanner;
    private boolean isProgramRunning;

    // EFFECTS: creates an instance of the LedgerApp console ui application
    public LedgerApp() {
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
    }

    // EFFECTS: displays and processes inputs for the main menu
    public void handleMenu() {
        displayMenu();
        String input = this.scanner.nextLine();
        processMenuCommands(input);
    }

    // EFFECTS: displays a list of commands that can be used in the main menu
    public void displayMenu() {
        //stub
    }

    // EFFECTS: processes the user's input in the main menu
    public void processMenuCommands(String input) {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: adds a player to the list of players
    public void addNewPlayer() {
        //stub
    }

    // MODIFIES: this
    // EFFECTS: displays all player one at a time
    public void viewPlayers() {
        displayGivenPlayers(this.players);
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
        //stub
    }

    // EFFECTS: displays the given player
    public void displayPlayer(Player player) {
        printDivider();
        System.out.println("Player " + player.getName());
    }

    // MODIFIES: this
    // EFFECTS: processes the user's input in the view flashcards menu
    public void handleViewCommands(String input, List<Player> players) {
        //stub
    }

    // EFFECTS: displays all the transactions that the player made
    public void displayTransactions(Player player) {
        //stub
    }

    // EFFECTS: displays the balance of the player
    public void checkBalance(Player player) {
        //stub
    }

    // MODIFIES: company, player
    // EFFECTS: player buys the given public company then returns to player page
    public void buyPublicCompany(Player player) {
        //stub
    }


    // MODIFIES: company, player
    // EFFECTS: player buys the given private company then returns to player page
    public void buyPrivateCompany(Player player) {
        //stub
    }

    // MODIFIES: company, player
    // EFFECTS: player sells the given public company then returns to player page
    public void sellPublicCompany(Player player) {
        //stub
    }

    // MODIFIES: company, player
    // EFFECTS: player sell the given private company then returns to player page
    public void sellPrivateCompany(Player player) {
        //stub
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
