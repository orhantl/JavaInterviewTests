package easyKata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PangramCheckerTest {

    PangramChecker pc = new PangramChecker();

    @Test
    public void test1() {
        String pangram1 = "The quick brown fox jumps over the lazy dog.";
        assertTrue(pc.check(pangram1));
    }

    @Test
    public void test2() {
        String pangram2 = "You shall not pass!";
        assertFalse(pc.check(pangram2));
    }

}