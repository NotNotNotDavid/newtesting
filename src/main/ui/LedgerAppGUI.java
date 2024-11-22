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
import javax.swing.*;

public class LedgerAppGUI {

    private static final String JSON_STORE = "./data/game.json";
    private List<Player> players;
    private Game game;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private JFrame frame;

    // private JComboBox<String> transactionMenu;
    public static void main(String[] args) {
        new LedgerAppGUI();
    }

    // EFFECTS: Creates a new Ledger with GUI
    public LedgerAppGUI() { // taken from LedgerApp
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        this.game = new Game();
        game.addAllCompanies();
        initializeUI();
    }

    // EFFECTS: starts the ui process, creates frame
    private void initializeUI() {
        frame = new JFrame("Ledger App - Shikoku 1889");
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    // EFFECTS: displays the avaliable player options
    private void displayPlayerOptions() { 

    }

}

