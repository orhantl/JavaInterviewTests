package easyKata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class NarcissisticNumberTest {

    @Test
    void exampleTests() {
        assertTrue(NarcissisticNumber.isNarcissistic(153), "153 is narcissistic");
        assertTrue(NarcissisticNumber.isNarcissistic(1634), "1634 is narcissistic");
        assertFalse(NarcissisticNumber.isNarcissistic(112), "112 is not narcissistic");
    }


}