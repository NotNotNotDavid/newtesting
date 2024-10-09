package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class TestPublicCompany {
    
    private PublicCompany testPublicCompany;

    @BeforeEach
    void runBefore(){
        testPublicCompany = new PublicCompany("Tosa Rail", 100, 10);
    }

    @Test
    void testConstructor(){
        assertEquals("Tosa Rail", testPublicCompany.getName());
    }

    @Test
    void testGetSharePrice(){
        assertEquals(100, testPublicCompany.getSharePrice("Tosa Rail"));
    }

    @Test
    void testGetSharesLeft(){
        assertEquals(10, testPublicCompany.getSharesLeft("Tosa Rail"));
    }

    @Test
    void testGetName(){
        assertEquals("Tosa Rail", testPublicCompany.getName());
    }

}
