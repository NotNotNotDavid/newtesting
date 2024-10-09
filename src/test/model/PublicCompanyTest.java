package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PublicCompanyTest{
    
    private PublicCompany testPublicCompany;

    @BeforeEach
    public void runBefore(){
        testPublicCompany = new PublicCompany("Tosa Rail", 100, 10);
    }

    @Test
    public void testConstructor(){
        assertEquals("Tosa Rail", testPublicCompany.getName());
        assertEquals(100, testPublicCompany.getSharePrice());
        assertEquals(10, testPublicCompany.getSharesLeft());
    }

}
