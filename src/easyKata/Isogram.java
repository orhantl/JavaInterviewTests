package easyKata;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Isogram {

    /* An isogram is a word that has no repeating letters, consecutive or non-consecutive.
     * Implement a function that determines whether a string that contains only letters is an isogram.
     * Assume the empty string is an isogram. Ignore letter case.
     *
     * Example: (Input --> Output)
     * "Dermatoglyphics" --> true
     * "aba" --> false
     * "moOse" --> false (ignore letter case)
     */

    public static boolean isIsogram1(String str) {
        Set<Character> uniqueLetters = new HashSet<>();
        for (char c : str.toLowerCase().toCharArray()) {
            uniqueLetters.add(c);
        }
        return uniqueLetters.size() >= str.length();
    }

    public static boolean isIsogram(String str) {
        return str.toLowerCase().chars().mapToObj(c -> (char) c).collect(Collectors.toSet()).size() >= str.length();
    }

    public static boolean  isIsogramWithDistinct(String str) {
        return str.length() == str.toLowerCase().chars().distinct().count();
    }

    public static boolean isIsogramWithLengthEquality(String str) {
        return str.toLowerCase()
                .chars()
                .distinct()
                .count() == str.length();
    }

    public static boolean isIsogramOldSchool(String str) {
        Set<Character> letters = new HashSet<Character>();

        for (int i = 0; i < str.length(); ++i) {
            if (letters.contains(str.toLowerCase().charAt(i))) {
                return false;
            }

            letters.add(str.charAt(i));
        }

        return true;
    }

    public static boolean isIsogramWithRegex(String str) {
        return !Pattern.compile("(?i)\\b\\w*(\\w)\\w*(?=\\1)\\w*\\b").matcher(str).matches();
    }

    public static boolean  isIsogramWithAnotherRegex(String s) {
        return !s.matches("(?i).*(.).*\\1.*");
    }

    public static boolean isIsogramWithSplit(String str) {
        int count = 0;
        str = str.toLowerCase();
        for (var x : str.split("")){
            for (var y : str.split("")){
                if (x.equals(y)){count++;}
            }
            if (count > str.split("").length){return false;}
        }
        return true;

    }
}
