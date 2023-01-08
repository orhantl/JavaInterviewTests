package easyKata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class PangramChecker {
    /*
    * A pangram is a sentence that contains every single letter of the alphabet at least once. For example,
    * the sentence "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least
    * once (case is irrelevant).
    *
    * Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers
    * and punctuation.
    */

    public boolean check(String sentence){
        ArrayList<CharSequence> ref = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            ref.add(Character.toString(i));
        }
        return ref.stream().allMatch(sentence.toLowerCase()::contains);
    }

    public boolean check2(String sentence){
        for (char c = 'a'; c<='z'; c++)
            if (!sentence.toLowerCase().contains("" + c))
                return false;
        return true;
    }

    public boolean check3(String sentence){
        return sentence.chars().map(Character::toLowerCase).filter(Character::isAlphabetic).distinct().count() == 26;
    }

    boolean check4(final String sentence) {
        return sentence.toLowerCase().chars()
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .distinct()
                .count() == 26;
    }

    public boolean check5(String s){
        return new HashSet<>(Arrays.asList(s.toUpperCase().replaceAll("[^A-Z]","").split(""))).size() == 26;
    }

    public boolean check6(String sentence){

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        List<String> sentence_chars = Arrays.asList( sentence.toLowerCase().split("") );
        List<String> alphabet_chars = Arrays.asList( alphabet.split("") );

        return sentence_chars.containsAll( alphabet_chars );
    }

    public boolean check7(String inputSentence){
        String loweredInput = inputSentence.toLowerCase();
        return IntStream.range('a', 'z' + 1).allMatch(a -> loweredInput.indexOf(a) >= 0);
    }

    public boolean check8(String sentence){
        String alph = "abcdefghijklmnopqrstuvwxyz";
        for (char letter: alph.toCharArray()) {
            if (!sentence.toLowerCase().contains(String.valueOf(letter))) return false;
        }
        return true;
    }

    public boolean check9(String sentence){
        return sentence.length() - sentence.toLowerCase().replaceAll("[a-z]", "").length() > 25;
    }

    public boolean check10(String sentence){
        return 27 <= (int) sentence.toLowerCase().chars().distinct().count();
    }
}
