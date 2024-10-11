package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PublicCompanyTest {

    private PublicCompany testPublicCompany;

    @BeforeEach
    public void runBefore() {
        testPublicCompany = new PublicCompany("Tosa Rail", 100, 10);
    }

    @Test
    public void testConstructor() {
        assertEquals("Tosa Rail", testPublicCompany.getName());
        assertEquals(100, testPublicCompany.getSharePrice());
        assertEquals(10, testPublicCompany.getSharesLeft());
    }

    @Test 
    public void testEquals(){
        assertTrue(testPublicCompany.equals(testPublicCompany));
    }

    @Test 
    public void testNotEqualsName(){
        PublicCompany testCopyPublicCompany = new PublicCompany("Dogo Railway", 100, 10);
        assertFalse(testPublicCompany.equals(testCopyPublicCompany));
    }

    @Test 
    public void testNotEqualsPrice(){
        PublicCompany testCopyPublicCompany = new PublicCompany("Tosa Railway", 200, 10);
        assertFalse(testPublicCompany.equals(testCopyPublicCompany));
    }

    @Test 
    public void testNotEqualsShares(){
        PublicCompany testCopyPublicCompany = new PublicCompany("Tosa Railway", 100, 9);
        assertFalse(testPublicCompany.equals(testCopyPublicCompany));
    }

    @Test 
    public void testNotObjectEquals(){
        assertFalse(testPublicCompany.equals(5));
    }

    @Test 
    public void testNullNotEquals(){
        assertFalse(testPublicCompany.equals(null));
    }

    @Test 
    public void testThisNotEquals(){
        assertTrue(testPublicCompany.equals(testPublicCompany));
    }

    @Test 
    public void testToString(){
        assertEquals("Public Company [" + testPublicCompany.getName() + "]", testPublicCompany.toString());
    }

}
