package easyKata;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringSplitTest {

    @Test
    public void should_split_string_with_even_number_of_characters() {
        String evenString = "abcdef";
        String oddString = "abcde";
        String [] expectedEvenResult = {"ab", "cd", "ef"};
        String [] expectedOddResult = {"ab", "cd", "e_"};
        assertEquals(Arrays.toString(expectedEvenResult), Arrays.toString(StringSplit.solution(evenString)));
        assertEquals(Arrays.toString(expectedOddResult), Arrays.toString(StringSplit.solution(oddString)));
    }

    @Test
    public void testEvenString() {
        String s = "abcdef";
        String s1 = "HelloWorld";
        assertEquals("[ab, cd, ef]", Arrays.toString(StringSplit.solution(s)));
        assertEquals("[He, ll, oW, or, ld]", Arrays.toString(StringSplit.solution(s1)));
    }

    @Test
    public void testOddString() {
        String s = "abcde";
        String s1 = "LovePizza";
        assertEquals("[ab, cd, e_]", Arrays.toString(StringSplit.solution(s)));
        assertEquals("[Lo, ve, Pi, zz, a_]", Arrays.toString(StringSplit.solution(s1)));
    }

}