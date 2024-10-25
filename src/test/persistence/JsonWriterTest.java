package persistence;

import model.Game;
import model.Player;
import model.PrivateCompany;
import model.PublicCompany;
import model.Transactions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            Game game = new Game();
            game.addAllCompanies();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            System.out.println("Illegal File Name, please enter again:");
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            Game game = new Game();
            game.addAllCompanies();
            JsonWriter writer = new JsonWriter("./data/testLedgerAppWriter.json");
            writer.open();
            writer.write(game);
            writer.close();

            JsonReader reader = new JsonReader("./data/testLedgerAppWriter.json");
            game = reader.read();
            assertEquals(0, game.getListOfPlayers().size());
            assertEquals(3, game.getListofPrivateCompanies().size());
            assertEquals(3, game.getListofPublicCompanies().size());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralGame() {
        try {
            Game game = new Game();
            game.addAllCompanies();
            game.addPlayer(new Player("Joe", 1000));
            game.addPlayer(new Player("Bob", 2000));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralGame.json");
            writer.open();
            writer.write(game);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralGame.json");
            game = reader.read();
            List<Player> players = game.getListOfPlayers();
            checkGame(game, null, null, null, null);
            assertEquals(2, players.size());
            assertEquals("Joe",  players.get(0).getName());
            assertEquals("Bob",  players.get(1).getName());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}