package persistence;

import model.Game;
import model.Player;
import model.PrivateCompany;
import model.PublicCompany;
import org.json.*;


import java.io.IOException;


// Represents a reader that reads game data from JSON stored in file
public class JsonReader {


    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {

    }

    // EFFECTS: reads Game from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Game read() throws IOException{
        return null;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        return "";
    }

    // EFFECTS: parses Game from JSON object and returns it
    private Game parseGame(JSONObject jsonObject) {
        return null;
    }

    // MODIFIES: game
    // EFFECTS: parses players from JSON object and adds them to the game
    private void addPlayers(Game game, JSONObject jsonObject) {
        
    }

    // EFFECTS: parses player from JSON object and returns it
    private Player parsePlayer(JSONObject jsonObject) {
        return null;
    }

    // MODIFIES: player
    // EFFECTS: parses public companies from JSON object and adds them to the player
    private void addPublicCompanies(Player player, JSONObject jsonObject) {
        
    }

    // MODIFIES: game
    // EFFECTS: parses public companies from JSON object and adds them to the game
    private void addPublicCompanies(Game game, JSONObject jsonObject) {

    }

    // MODIFIES: game
    // EFFECTS: parses public companies from JSON object and adds them to the game
    private void addPrivateCompanies(Game game, JSONObject jsonObject) {

    }

    // MODIFIES: player
    // EFFECTS: parses private companies from JSON object and adds them to the
    // player
    private void addPrivateCompanies(Player player, JSONObject jsonObject) {

    }

    // EFFECTS: parses PublicCompany from JSON object and returns it
    private PublicCompany parsePublicCompany(JSONObject jsonObject) {
        return null;
    }

    // EFFECTS: parses PrivateCompany from JSON object and returns it
    private PrivateCompany parsePrivateCompany(JSONObject jsonObject) {
        return null;
    }

}
