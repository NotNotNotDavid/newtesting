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

}
