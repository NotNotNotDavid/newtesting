package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrivateCompanyTest {

    private PrivateCompany testPrivateCompany;

    @BeforeEach
    public void runBefore() {
        testPrivateCompany = new PrivateCompany("Dogo Railway", 50, true);

    }

    @Test
    public void testConstructor() {
        assertEquals("Dogo Railway", testPrivateCompany.getName());
        assertEquals(50, testPrivateCompany.getPrice());
        assertEquals(true, testPrivateCompany.isBought());
    }

    @Test
    public void testEquals() {
        PrivateCompany testCopyPrivateCompany = new PrivateCompany("Dogo Railway", 50, true);
        assertTrue(testPrivateCompany.equals(testCopyPrivateCompany));
    }

    @Test
    public void testNotEqualsName() {
        PrivateCompany testNotCopyPrivateCompany = new PrivateCompany("Toya Railway", 50, true);
        assertFalse(testPrivateCompany.equals(testNotCopyPrivateCompany));
    }

    @Test
    public void testNotEqualsPrice() {
        PrivateCompany testNotCopyPrivateCompany = new PrivateCompany("Dogo Railway", 100, true);
        assertFalse(testPrivateCompany.equals(testNotCopyPrivateCompany));
    }

    @Test
    public void testNotEqualsIsBought() {
        PrivateCompany testNotCopyPrivateCompany = new PrivateCompany("Dogo Railway", 50, false);
        assertFalse(testPrivateCompany.equals(testNotCopyPrivateCompany));
    }

    @Test
    public void testNotNotEquals() {
        assertFalse(testPrivateCompany.equals(5));
    }

    @Test
    public void testNullNotEquals() {
        assertFalse(testPrivateCompany.equals(null));
    }

    @Test
    public void testThisNotEquals() {
        assertTrue(testPrivateCompany.equals(testPrivateCompany));
    }

    @Test
    public void testToString() {
        assertEquals("Private Company [" + testPrivateCompany.getName() + "]", testPrivateCompany.toString());
    }

}
