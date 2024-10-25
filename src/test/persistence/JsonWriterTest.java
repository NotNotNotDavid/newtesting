// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

package persistence;

import model.Game;
import model.Player;
import model.PrivateCompany;
import model.PublicCompany;
import model.Transactions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest {
    // NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter
    // is to
    // write data to a file and then use the reader to read it back in and check
    // that we
    // read in a copy of what was written out.

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
            // make game

            Game game = new Game();
            game.addAllCompanies();
            PrivateCompany dogo = new PrivateCompany("Dogo Rail", 60, false);
            PublicCompany tosa = new PublicCompany("Tosa Rail", 100, 10);

            Player playerJoe = new Player("Joe", 1000);

            game.addPlayer(playerJoe);
            playerJoe.buyPrivateCompany(dogo);
            playerJoe.buyPublicCompany(tosa);

            // write
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralGame.json");
            writer.open();
            writer.write(game);
            writer.close();
            // read
            JsonReader reader = new JsonReader("./data/testWriterGeneralGame.json");
            game = reader.read();

            ArrayList<PublicCompany> testJoePublicList = new ArrayList<>();
            testJoePublicList.add(tosa);

            assertEquals(playerJoe.getPublicCompanies(), testJoePublicList);

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}