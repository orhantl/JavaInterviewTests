package easyKata;

import org.junit.jupiter.api.Test;

import static easyKata.Isogram.isIsogram;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IsogramTest {

    @Test
    public void FixedTests() {
        assertEquals(true, isIsogram("Dermatoglyphics"));
        assertEquals(true, isIsogram("isogram"));
        assertEquals(false, isIsogram("moose"));
        assertEquals(false, isIsogram("isIsogram"));
        assertEquals(false, isIsogram("aba"));
        assertEquals(false, isIsogram("moOse"));
        assertEquals(true, isIsogram("thumbscrewjapingly"));
        assertEquals(true, isIsogram(""));
    }
}