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
        
    }
    @Test
    public void testGetListofPublicCompanies(){
        assertEquals(listOfPublicCompanies, testGame.getListofPublicCompanies());;
    }

    @Test
    public void testGetListofPrivateCompanies(){
        assertEquals(listOfPrivateCompanies, testGame.getListofPrivateCompanies());;
    }

    @Test 
    public void testGetListofPlayers(){
        assertEquals(listOfPlayers, testGame.getListOfPlayers());
    }


    
}
