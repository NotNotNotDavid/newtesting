package ui;

import model.Event;
import model.EventLog;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// A GUI that has all the functionality of the LedgerApp but now with pictures and stuff!
public class LedgerAppGUI {
    private static final String JSON_STORE = "./data/game.json";
    private List<Player> players;
    private Game game;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private JFrame frame;
    private JTextArea textArea;
    private JComboBox<String> playerComboBox;
    private JWindow splashWindow;

    // EFFECTS: creates the UI
    public LedgerAppGUI() throws FileNotFoundException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        players = new ArrayList<>();
        game = new Game();
        game.addAllCompanies();
        showSplashScreen();
        initializeUI();
    }

    // EFFECTS: displays the splash screen
    private void showSplashScreen() {

        splashWindow = new JWindow();
        splashWindow.setLayout(new BorderLayout());

        ImageIcon splashImage = new ImageIcon("images/startup_image.jpg");
        Image image = splashImage.getImage();
        Image scaledImage = image.getScaledInstance(600, 400, Image.SCALE_AREA_AVERAGING);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel splashLabel = new JLabel(scaledIcon);
        splashWindow.getContentPane().add(splashLabel, BorderLayout.CENTER);

        splashWindow.setSize(600, 300);
        splashWindow.setLocationRelativeTo(null);
        splashWindow.setVisible(true);

        new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                splashWindow.setVisible(false);
                splashWindow.dispose();
                frame.setVisible(true);
            }
        }).start();
    }

    // EFFECTS: initializes the ui with buttons and screen splash
    private void initializeUI() {
        frame = new JFrame("Ledger App - Shikoku 1889");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Don't close the window immediately
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());
    
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                printEventLog();
                System.exit(0); 
            }
        });
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JPanel buttonPanel = initializeButtons();
    
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.WEST);
        frame.setVisible(false);
        frame.setLocationRelativeTo(null);
    }

    // EFFECTS: initializes all the buttons
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

    // EFFECTS: button listener to load game
    class LoadButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                game = jsonReader.read();
                players = game.getListOfPlayers();
                updatePlayerComboBox();
                textArea.setText("Game loaded successfully!\n");
            } catch (IOException ex) {
                textArea.setText("Error loading game.\n");
            }
        }
    }

    // EFFECTS: button listener to save game
    class SaveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                jsonWriter.open();
                jsonWriter.write(game);
                jsonWriter.close();
                textArea.setText("Game saved successfully!\n");
            } catch (FileNotFoundException ex) {
                textArea.setText("Error saving game.\n");
            }
        }
    }

    // EFFECTS: button listener to add players with prompt
    class AddPlayerButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JTextField nameField = new JTextField(20);
            JTextField balanceField = new JTextField(20);
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(new JLabel("Enter Player Name:"));
            panel.add(nameField);
            panel.add(new JLabel("Enter Starting Balance:"));
            panel.add(balanceField);

            int option = JOptionPane.showConfirmDialog(frame, panel, "Add New Player", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String playerName = nameField.getText();
                try {
                    int startingBalance = Integer.parseInt(balanceField.getText());
                    Player player = new Player(playerName, startingBalance);
                    players.add(player);
                    game.addPlayer(player);
                    updatePlayerComboBox();
                    textArea.setText("New player added: " + playerName + "\n");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number for balance.");
                }
            }
        }
    }

    // EFFECTS: update the player combo box to fulfill any additional players
    private void updatePlayerComboBox() {
        Set<String> playerNames = new HashSet<>();

        playerComboBox.removeAllItems();
        for (Player player : players) {
            playerNames.add(player.getName());
        }

        for (String playerName : playerNames) {
            playerComboBox.addItem(playerName);
        }
    }

    // EFFECTS: display player on the text field when pressed
    class ViewPlayersButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String selectedPlayerName = (String) playerComboBox.getSelectedItem();
            if (selectedPlayerName == null) {
                textArea.setText("No player selected.\n");
                return;
            }

            Player selectedPlayer = null;
            for (Player player : players) {
                if (player.getName().equals(selectedPlayerName)) {
                    selectedPlayer = player;
                    break;
                }
            }

            if (selectedPlayer != null) {
                StringBuilder playerInfo = new StringBuilder();
                playerInfo.append("Name: ").append(selectedPlayer.getName())
                        .append("\nBalance: ").append(selectedPlayer.getBalance())
                        .append("\nPublic Companies: ").append(selectedPlayer.getPublicCompanies())
                        .append("\nPrivate Companies: ").append(selectedPlayer.getPrivateCompanies())
                        .append("\n");

                textArea.setText(playerInfo.toString());
                displayPlayerOptions(selectedPlayer);
            }
        }
    }

    // EFFECTS: Display all of player interaction options
    private void displayPlayerOptions(Player player) {
        String[] options = {
                "View Transactions",
                "Buy Public Company",
                "Buy Private Company",
                "Sell Public Company",
                "Sell Private Company",
        };

        String action = (String) JOptionPane.showInputDialog(frame,
                "Select an option:",
                "Player Actions",
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);

        if (action != null) {
            handlePlayerAction(action, player);
        }
    }

    // EFFECTS: Handle the action selected from the player options
    private void handlePlayerAction(String action, Player player) {
        switch (action) {
            case "View Transactions":
                displayTransactions(player);
                break;
            case "Buy Public Company":
                buyPublicCompany(player);
                break;
            case "Buy Private Company":
                buyPrivateCompany(player);
                break;
            case "Sell Public Company":
                sellPublicCompany(player);
                break;
            case "Sell Private Company":
                sellPrivateCompany(player);
                break;
            default: // nothing happens
                break;
        }
    }

    // EFFECTS: Chose player based on name
    class PlayerSelectionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String selectedPlayerName = (String) playerComboBox.getSelectedItem();

            if (selectedPlayerName == null) {
                textArea.setText("No player selected.\n");
                return;
            }

            Player selectedPlayer = null;
            for (Player player : players) {
                if (player.getName().equals(selectedPlayerName)) {
                    selectedPlayer = player;
                    break;
                }
            }

            if (selectedPlayer != null) {
                textArea.setText("Selected Player: " + selectedPlayer.getName() + "\n");
            }
        }
    }

    // EFFECTS: Display Transactions
    private void displayTransactions(Player player) {
        textArea.append("Transactions: " + player.getTransactions() + "\n");
    }

    // MODIFIES: company, player
    // EFFECTS: Buy Public Company
    private void buyPublicCompany(Player player) {
        String companyName = JOptionPane.showInputDialog(frame, "Enter Public Company Name:");
        ArrayList<PublicCompany> companies = game.getListofPublicCompanies();
        for (PublicCompany company : companies) {
            if (company.getName().equalsIgnoreCase(companyName)) {
                player.buyPublicCompany(company);
                textArea.append(player.getName() + " bought " + company.getName() + "!\n");
                return;
            }
        }
        textArea.append("Company not found uh oh.\n");
    }

    // MODIFIES: company, player
    // EFFECTS: Buy Private Company
    private void buyPrivateCompany(Player player) {
        String companyName = JOptionPane.showInputDialog(frame, "Enter Private Company Name:");
        ArrayList<PrivateCompany> companies = game.getListofPrivateCompanies();
        for (PrivateCompany company : companies) {
            if (company.getName().equalsIgnoreCase(companyName)) {
                if (!company.isBought()) {
                    player.buyPrivateCompany(company);
                    textArea.append(player.getName() + " bought " + company.getName() + "!\n");
                    return;
                } else {
                    textArea.append("Company already bought!!.\n");
                    return;
                }
            }
        }
        textArea.append("Private company not found.\n");
    }

    // MODIFIES: company, player
    // EFFECTS: Sell Public Company
    private void sellPublicCompany(Player player) {
        String companyName = JOptionPane.showInputDialog(frame, "Enter Public Company Name to Sell:");
        ArrayList<PublicCompany> companies = game.getListofPublicCompanies();
        for (PublicCompany company : companies) {
            if (company.getName().equalsIgnoreCase(companyName)) {
                player.sellPublicCompany(company);
                textArea.append(player.getName() + " sold " + company.getName() + "!\n");
                return;
            }
        }
        textArea.append("Company not found.\n");
    }

    // MODIFIES: company, player
    // EFFECTS: Sells Private Company
    private void sellPrivateCompany(Player player) {
        String companyName = JOptionPane.showInputDialog(frame, "Enter Private Company Name to Sell:");
        ArrayList<PrivateCompany> companies = game.getListofPrivateCompanies();
        for (PrivateCompany company : companies) {
            if (company.getName().equalsIgnoreCase(companyName)) {
                player.sellPrivateCompany(company);
                textArea.append(player.getName() + " sold " + company.getName() + "!\n");
                return;
            }
        }
        textArea.append("Company not found.\n");
    }

    // EFFECTS: prints all logged events to the console
    private void printEventLog() {
        for (Event next : EventLog.getInstance()) {
            System.out.println(next.toString() + "\n\n");
        }
    }

    // EFFECTS: Exit Application
    class QuitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            printEventLog();
            System.exit(0);
        }
    }

    

}
