package ui;

import model.Game;
import model.Player;
import model.PrivateCompany;
import model.PublicCompany;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LedgerAppGUI {
    private static final String JSON_STORE = "./data/game.json";
    private List<Player> players;
    private Game game;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private JFrame frame;
    private JTextArea textArea;
    private JComboBox<Player> playerComboBox;
    private JComboBox<String> transactionMenu;

    public LedgerAppGUI() throws FileNotFoundException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        players = new ArrayList<>();
        game = new Game();
        game.addAllCompanies();
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Ledger App - Shikoku 1889");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JPanel buttonPanel = initializeButtons();

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.WEST);

        frame.setVisible(true);
    }

    // EFFECTS: Creates multiple buttons within a layout
    private JPanel initializeButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(8, 1));

        JButton loadButton = new JButton("Load Game");
        loadButton.addActionListener(new LoadButtonListener());
        buttonPanel.add(loadButton);

        JButton saveButton = new JButton("Save Game");
        saveButton.addActionListener(new SaveButtonListener());
        buttonPanel.add(saveButton);

        playerComboBox = new JComboBox<>();
        playerComboBox.addActionListener(new PlayerSelectionListener());
        buttonPanel.add(playerComboBox);

        JButton addPlayerButton = new JButton("Add New Player");
        addPlayerButton.addActionListener(new AddPlayerButtonListener());
        buttonPanel.add(addPlayerButton);

        JButton viewPlayersButton = new JButton("View Selected Player");
        viewPlayersButton.addActionListener(new ViewPlayersButtonListener());
        buttonPanel.add(viewPlayersButton);

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(new QuitButtonListener());
        buttonPanel.add(quitButton);

        return buttonPanel;
    }

    // EFFECTS: Button listener to load game
    class LoadButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        }
    }

    // EFFECTS: Button listener to save game
    class SaveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        }
    }

    // EFFECTS: button listener to add players with prompt
    class AddPlayerButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        }
    }

    // EFFECTS: Update the player combo box to fulfill any additional players
    private void updatePlayerComboBox() {
    }

    // EFFECTS: View all players within the combo box
    class ViewPlayersButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        }
    }

    // EFFECTS: Display all of player interaction options
    private void displayPlayerOptions(Player player) {
    }

    // EFFECTS: Chose Player
    class PlayerSelectionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        }
    }

    // EFFECTS: Display Transactions
    private void displayTransactions(Player player) {
    }

    // EFFECTS: View Player's Balance
    private void checkBalance(Player player) {
    }

    // EFFECTS: View Public Company Holdings
    private void checkPublicCompanyHoldings(Player player) {
    }

    // EFFECTS: View Private Company Hildings
    private void checkPrivateCompanyHoldings(Player player) {
    }

    // EFFECTS: Buy Public Company
    private void buyPublicCompany(Player player) {
    }

    // EFFECTS: Buy Private Company
    private void buyPrivateCompany(Player player) {
    }

    // EFFECTS: Sell Public Company
    private void sellPublicCompany(Player player) {
    }

    // EFFECTS: Sell Private Company
    private void sellPrivateCompany(Player player) {
    }

    // EFFECTS: Exit Application
    class QuitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        }
    }
}
