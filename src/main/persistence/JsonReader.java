package persistence;

import model.Game;
import model.Player;
import model.PrivateCompany;
import model.PublicCompany;
import model.Transactions;

import org.json.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// Represents a reader that reads game data from JSON stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads Game from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Game read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseGame(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses Game from JSON object and returns it
    private Game parseGame(JSONObject jsonObject) {
        Game game = new Game();

        addPlayers(game, jsonObject);
        addPublicCompanies(game, jsonObject);
        addPrivateCompanies(game, jsonObject);

        return game;
    }

    // MODIFIES: game
    // EFFECTS: parses players from JSON object and adds them to the game
    private void addPlayers(Game game, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("players");
        for (Object json : jsonArray) {
            JSONObject nextPlayer = (JSONObject) json;
            Player player = parsePlayer(nextPlayer);
            game.addPlayer(player);
        }
    }

    // EFFECTS: parses player from JSON object and returns it
    private Player parsePlayer(JSONObject jsonObject) {
        String playerName = jsonObject.getString("playerName");
        int balance = jsonObject.getInt("balance");

        Player player = new Player(playerName, balance);

        JSONArray publicCompanyArray = jsonObject.getJSONArray("publicCompaniesOwnership");
        for (Object obj : publicCompanyArray) {
            JSONObject companyJson = (JSONObject) obj;
            addPublicCompanies(player, companyJson);
        }

        JSONArray privateCompanyArray = jsonObject.getJSONArray("privateCompaniesOwnership");
        for (Object obj : privateCompanyArray) {
            JSONObject companyJson = (JSONObject) obj;
            addPrivateCompanies(player, companyJson);
        }

        // JSONArray transactionArray = jsonObject.getJSONArray("transactions");
        // for (Object obj : transactionArray) {
        // JSONObject companyJson = (JSONObject) obj;
        // addTransactions(player, companyJson);
        // }

        return player;
    }

    // MODIFIES: game
    // EFFECTS: parses public companies from JSON object and adds them to the game
    private void addPublicCompanies(Game game, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("publicCompanies");
        for (Object json : jsonArray) {
            JSONObject nextCompany = (JSONObject) json;
            PublicCompany publicCompany = parsePublicCompany(nextCompany);
            game.addPublicCompany(publicCompany);
        }
    }

    // MODIFIES: player
    // EFFECTS: parses public companies from JSON object and adds them to the player
    private void addPublicCompanies(Player player, JSONObject jsonObject) {

        PublicCompany publicCompany = parsePublicCompany(jsonObject);
        player.buyPublicCompany(publicCompany);
        // JSONArray jsonArray = jsonObject.getJSONArray("publicCompaniesOwnership");
        // for (Object json : jsonArray) {
        // JSONObject nextCompany = (JSONObject) json;

        // }
    }


    // MODIFIES: game
    // EFFECTS: parses public companies from JSON object and adds them to the game
    private void addPrivateCompanies(Game game, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("privateCompanies");
        for (Object json : jsonArray) {
            JSONObject nextCompany = (JSONObject) json;
            PrivateCompany privateCompany = parsePrivateCompany(nextCompany);
            game.addPrivateCompany(privateCompany);
        }
    }

    // MODIFIES: player
    // EFFECTS: parses private companies from JSON object and adds them to the
    // player
    private void addPrivateCompanies(Player player, JSONObject jsonObject) {

        PrivateCompany privateCompany = parsePrivateCompany(jsonObject);
        privateCompany.setIsBought(false);
        player.buyPrivateCompany(privateCompany);

        // JSONArray jsonArray = jsonObject.getJSONArray("privateCompaniesOwnership");
        // // stops here now
        // for (Object json : jsonArray) {
        // JSONObject nextCompany = (JSONObject) json;

        // }
    }

    // EFFECTS: parses PublicCompany from JSON object and returns it
    private PublicCompany parsePublicCompany(JSONObject jsonObject) {
        String name = jsonObject.getString("publicCompanyName");
        int sharePrice = jsonObject.getInt("sharePrice");
        int sharesLeft = jsonObject.getInt("sharesLeft");
        return new PublicCompany(name, sharePrice, sharesLeft);
    }

    // EFFECTS: parses PrivateCompany from JSON object and returns it
    private PrivateCompany parsePrivateCompany(JSONObject jsonObject) {
        String name = jsonObject.getString("privateCompanyName");
        int price = jsonObject.getInt("price");
        boolean isBought = jsonObject.getBoolean("isBought");
        return new PrivateCompany(name, price, isBought);
    }

    // // do i need this???
    // MODIFIES: game
    // EFFECTS: parses transactions from JSON objects and adds them to the player
    // private void addTransactions(Player player, JSONObject jsonObject) {
    //     JSONArray jsonArray = jsonObject.getJSONArray("Transactions");
    //     for (Object json : jsonArray) {
    //         JSONObject nextTransaction = (JSONObject) json;
    //         Transactions transactions = parseTransactions(nextTransaction);
    //         player.addTransaction(nextTransaction);
    //     }

    // }

    // // EFFECTS: parses PrivateCompany from JSON object and returns it
    // private Transactions parseTransactions(JSONObject jsonObject) {
    //     String name = jsonObject.getString("name");
    //     int price = jsonObject.getInt("price");
    //     String companyName = jsonObject.getString("companyName");
    //     String action = jsonObject.getString("action");
    //     return new Transactions(name, price, companyName, action);
    // }

}
