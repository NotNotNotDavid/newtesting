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
}
