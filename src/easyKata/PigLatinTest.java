package easyKata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PigLatinTest {
    @Test
    public void FixedTests() {
        assertEquals("igPay atinlay siay oolcay", PigLatin.pigIt("Pig latin is cool"));
        assertEquals("hisTay siay ymay tringsay", PigLatin.pigIt("This is my string"));
        assertEquals("hisTay siay ymay tringsay ! []", PigLatin.pigIt("This is my string ! []"));
        assertEquals("oratay oay oresmay ![]", PigLatin.pigIt( "tora o mores ![]"));
        assertEquals("appenedhay ;:!# éay [ [] {} ! ereHay tiay siay :)", PigLatin.pigIt("happened ;:!# é [ [] {} ! Here it is :)"));
    }

    @Test
    public void isAWord() {
        String correctWord = "Something";
        assertTrue(PigLatin.checkItIsAWord(correctWord));
    }

    @Test
    public void isNotAWord() {
        String bracket = "[";
        String specialChars = "{['=}]";
        assertFalse(PigLatin.checkItIsAWord(bracket));
        assertFalse(PigLatin.checkItIsAWord(specialChars));
    }
}