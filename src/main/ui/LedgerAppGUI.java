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

import java.awt.*;

public class LedgerAppGUI {

    private static final String JSON_STORE = "./data/game.json";
    private List<Player> players;
    private Game game;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private JFrame frame;
    private JTextArea textArea;
    private JComboBox<Player> playerComboBox;
    private JComboBox<String> transactionMenu; // i have no idea how this thing works bruh

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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this is the thing that makes them close when closed
        frame.setSize(800, 600);

        initializeButtons();
        frame.setVisible(true);
    }

    // EFFECTS: Creates multiple buttons within a layout
    private void initializeButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 1));

        JButton loadButton = new JButton("Load Game");
        buttonPanel.add(loadButton);

        JButton saveButton = new JButton("Save Game");
        buttonPanel.add(saveButton);

        JButton addPlayerButton = new JButton("Add New Player");
        buttonPanel.add(addPlayerButton);

        JButton viewPlayersButton = new JButton("View Selected Player");
        buttonPanel.add(viewPlayersButton);

        JButton quitButton = new JButton("Quit");
        buttonPanel.add(quitButton);
        frame.add(buttonPanel, BorderLayout.WEST); // this can be any direction, west looks good for now
    }

    // EFFECTS: displays the avaliable player options
    private void displayPlayerOptions() {

    }

}
