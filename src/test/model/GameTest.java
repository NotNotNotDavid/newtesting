package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class GameTest {
    
    private Game testGame;
    ArrayList<Player> listOfPlayers;
    PublicCompany Tosa = new PublicCompany("Tosa Rail", 100, 10);
    PublicCompany Iya = new PublicCompany("Iya Rail", 100, 10);
    PublicCompany Awa = new PublicCompany("Awa Rail", 100, 10);
    ArrayList<PublicCompany> listOfPublicCompanies;

    PrivateCompany Dogo = new PrivateCompany("Dogo Rail", 60, false);
    PrivateCompany Uno = new PrivateCompany("Uno Rail", 100, false);
    PrivateCompany Ehime = new PrivateCompany("Ehime Rail", 40, false);
    ArrayList<PrivateCompany> listOfPrivateCompanies;

    @BeforeEach
    public void runBefore(){
        testGame = new Game();

        listOfPlayers = new ArrayList<Player>();

        listOfPublicCompanies = new ArrayList<PublicCompany>();
        listOfPublicCompanies.add(Tosa);
        listOfPublicCompanies.add(Iya);
        listOfPublicCompanies.add(Awa); 

        listOfPrivateCompanies = new ArrayList<PrivateCompany>();
        listOfPrivateCompanies.add(Dogo);
        listOfPrivateCompanies.add(Uno);
        listOfPrivateCompanies.add(Ehime);
        
    }
    @Test
    public void testGetListofPublicCompanies(){
        assertEquals(listOfPublicCompanies, testGame.getListofPublicCompanies());
    }

    @Test
    public void testGetListofPrivateCompanies(){
        assertEquals(listOfPrivateCompanies, testGame.getListofPrivateCompanies());
    }

    @Test 
    public void testGetListofPlayers(){
        assertEquals(listOfPlayers, testGame.getListOfPlayers());
    }

    @Test
    public void testEqualGame(){
        assertTrue(testGame.equals(testGame));
    }

    @Test
    public void testNullEqualGame(){
        assertFalse(testGame.equals(null));
    }

    @Test
    public void testOtherNotEqualGame(){
        assertFalse(testGame.equals(3));
    }

    @Test
    public void testOtherEqualsGame(){
        Game testGame2 = new Game();
        assertTrue(testGame.equals(testGame2));
    }

    @Test
    public void testEachInstanceEqual(){
        Game testGame2 = new Game();
        assertTrue(testGame.getListOfPlayers().equals(testGame2.getListOfPlayers()));
    }

    @Test 
    public void testNotEqualOtherl(){
        assertFalse(testGame.equals(0));
    }
    
    @Test 
    public void testNotEqualNull(){
        assertFalse(testGame.equals(null));
    }

    @Test
    public void testNotEqualListOfPlayer(){
        Game testGameBad = new Game();
        testGameBad.getListOfPlayers().add(null);
        assertFalse(testGame.equals(testGameBad));
    }

    @Test
    public void testNotEqualListOfPublicCompanies(){
        Game testGameBad = new Game();
        testGameBad.getListofPublicCompanies().add(Awa);
        assertFalse(testGame.equals(testGameBad));
    }

    @Test
    public void testNotEqualListOfPrivateCompanies(){
        Game testGameBad = new Game();
        testGameBad.getListofPrivateCompanies().add(Dogo);
        assertFalse(testGame.equals(testGameBad));
    }
    
}
