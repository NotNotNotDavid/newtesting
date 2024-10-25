package persistence;

import model.Game;
import model.Player;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Game game = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyGame.json");
        try {
            Game game = reader.read();
            // assertEquals("My work room", wr.getName());
            assertEquals(0, game.getListOfPlayers().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralGame.json");
        try {
            Game game = reader.read();
            List<Player> players = game.getListOfPlayers();
            assertEquals(2, players.size());
            assertEquals("Joe", players.get(0).getName());
            assertEquals("Bob", players.get(1).getName());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}