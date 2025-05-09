package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class PackageHandlerTest {

    private PackageHandler underTest;

    @BeforeEach
    void setUp() {
        underTest= new PackageHandler();
    }



    @Test
    void weightCost() {
        assertEquals("200",underTest.weightCost("5001"));
        assertEquals("0",underTest.weightCost("1"));

    }

    @Test
    void heightCost() {
        assertEquals("300",underTest.heightCost("101"));
        assertEquals("0",underTest.weightCost("1"));

    }

    @Test
    void systemCost() {
        assertEquals("1",underTest.systemCost("110"));
    }
}