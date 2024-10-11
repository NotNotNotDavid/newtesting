package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    private Transactions testTransaction;

    @BeforeEach
    public void runBefore() {
        testTransaction = new Transactions("Jeff", 100, "Dogo Rail", "buy");
    }

    @Test
    public void testConstructor() {
        assertEquals("Jeff", testTransaction.getPlayerName());
        assertEquals(100, testTransaction.getPrice());
        assertEquals("Dogo Rail", testTransaction.getCompanyName());
        assertEquals("buy", testTransaction.getAction());
    }

    @Test
    public void testEquals() {
        assertTrue(testTransaction.equals(testTransaction));
    }

    @Test
    public void testNotEqualsPlayerName() {
        Transactions transactionBad = new Transactions("Bobby", 100, "Dogo Rail", "buy");
        assertFalse(testTransaction.equals(transactionBad));
    }

    @Test
    public void testNotEqualsPrice() {
        Transactions transactionBad = new Transactions("Jeff", 40, "Dogo Rail", "buy");
        assertFalse(testTransaction.equals(transactionBad));
    }

    @Test
    public void testNotEqualsCompanyName() {
        Transactions transactionBad = new Transactions("Jeff", 100, "Iya Rail", "buy");
        assertFalse(testTransaction.equals(transactionBad));
    }

    @Test
    public void testNotEqualsAction() {
        Transactions transactionBad = new Transactions("Jeff", 100, "Dogo Rail", "sell");
        assertFalse(testTransaction.equals(transactionBad));
    }

    @Test
    public void testNotEqualOther() {
        assertFalse(testTransaction.equals(99));
    }

    @Test
    public void testNotEqualNull() {
        assertFalse(testTransaction.equals(null));
    }

    @Test
    public void testToString() {
        assertEquals("Transaction[" + "Player: " + testTransaction.getPlayerName()
                + ", Price: " + testTransaction.getPrice() + ", Company: " +
                testTransaction.getCompanyName() + ", Action: " + testTransaction.getAction() + "]",
                testTransaction.toString());
    }
}
