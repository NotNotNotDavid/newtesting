package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


public class PlayerTest {

    Player player1;
    PublicCompany testPublicCompany1;
    PublicCompany testPublicCompany2;
    PrivateCompany testPrivateCompany1;
    PrivateCompany testPrivateCompany2;
    ArrayList<PublicCompany> testPublicCompaniesList;
    ArrayList<PrivateCompany> testPrivateCompaniesList;


    @BeforeEach
    public void runBefore(){
        player1 = new Player("Joe", 1000);
        testPublicCompany1 = new PublicCompany("Tosa Rail", 100, 10);
        testPublicCompany2 = new PublicCompany("Iyo Rail", 300, 5);
        testPrivateCompany1 = new PrivateCompany("Pill Rail", 50, false);
        testPrivateCompany2 = new PrivateCompany("Dogo Rail", 20, true);
        testPublicCompaniesList = new ArrayList<PublicCompany>();
        testPrivateCompaniesList = new ArrayList<PrivateCompany>();

    }

    @Test
    public void testConstructor(){
        assertEquals("Joe", player1.getName());
        assertEquals(10000, player1.getBalance());
        assertEquals(testPublicCompaniesList, player1.getPublicCompanies());
        assertEquals(testPrivateCompaniesList, player1.getPrivateCompanies());
    }

    @Test 
    public void testBuyPublicCompany(){
        player1.buyPublicCompany(testPublicCompany1);
        testPublicCompaniesList.add(testPublicCompany1);
        assertEquals(testPublicCompaniesList, player1.getPublicCompanies());
        assertEquals(900, player1.getBalance());
        assertEquals(9, testPublicCompany1.getSharesLeft());
    }


    @Test
    public void testBuyMultipleCompanies(){
        player1.buyPublicCompany(testPublicCompany1);
        testPublicCompaniesList.add(testPublicCompany1);
        assertEquals(testPublicCompaniesList, player1.getPublicCompanies());
        assertEquals(900, player1.getBalance());
        assertEquals(9, testPublicCompany1.getSharesLeft());
        player1.buyPublicCompany(testPublicCompany2);
        testPublicCompaniesList.add(testPublicCompany2);
        assertEquals(testPublicCompaniesList, player1.getPublicCompanies());
        assertEquals(600, player1.getBalance());
        assertEquals(4, testPublicCompany2.getSharesLeft());
        player1.buyPublicCompany(testPublicCompany1);
        testPublicCompaniesList.add(testPublicCompany1);
        assertEquals(testPublicCompaniesList, player1.getPublicCompanies());
        assertEquals(500, player1.getBalance());
        assertEquals(8, testPublicCompany1.getSharesLeft());
    }

    @Test
    public void testBuyPrivateCompanyWhenAlreadyBought(){
        player1.buyPrivateCompany(testPrivateCompany2);
        assertEquals(testPrivateCompaniesList, player1.getPrivateCompanies());
        assertTrue(testPrivateCompany1.isBought());
    }

    @Test
    public void testBuyPrivateCompany(){
        player1.buyPrivateCompany(testPrivateCompany1);
        testPrivateCompaniesList.add(testPrivateCompany1);
        assertEquals(testPrivateCompaniesList, player1.getPrivateCompanies());
        assertTrue(testPrivateCompany1.isBought());
        assertEquals(950, player1.getBalance());
    }

    @Test
    public void testBuySamePrivateCompanyTwice(){
        player1.buyPrivateCompany(testPrivateCompany1);
        testPrivateCompaniesList.add(testPrivateCompany1);
        assertTrue(testPrivateCompany1.isBought());
        player1.buyPrivateCompany(testPrivateCompany1);
        assertEquals(testPrivateCompaniesList, player1);
        assertTrue(testPrivateCompany1.isBought());
        assertEquals(950, player1.getBalance());

    }

    @Test
    public void testSellPublicCompany(){
        player1.buyPublicCompany(testPublicCompany1);
        testPublicCompaniesList.add(testPublicCompany1);
        player1.sellPublicCompany(testPublicCompany1);
        testPublicCompaniesList.remove(0);
        assertEquals(1000, player1.getBalance());
        assertEquals(10, testPublicCompany1.getSharesLeft());
    }

    @Test
    public void testSellPrivateCompany(){
        player1.buyPrivateCompany(testPrivateCompany1);
        testPrivateCompaniesList.add(testPrivateCompany1);
        player1.sellPrivateCompany(testPrivateCompany1);
        testPublicCompaniesList.remove(0);
        assertEquals(1000, player1.getBalance());
        assertFalse(testPrivateCompany1.isBought);
    }


}


