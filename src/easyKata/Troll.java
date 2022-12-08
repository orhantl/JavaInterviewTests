package easyKata;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Troll {

    /*
    * Instructions :
    * Trolls are attacking your comment section!
    * A common way to deal with this situation is to remove all of the vowels from the trolls' comments, neutralizing the threat.
    * Your task is to write a function that takes a string and return a new string with all vowels removed.
    * For example, the string "This website is for losers LOL!" would become "Ths wbst s fr lsrs LL!".
    * Note: for this kata y isn't considered a vowel.

    * */

    public static String disemvowel(String string) {
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        List<Character> chars = convertStringToList(string);
        StringBuilder sb = new StringBuilder();
        chars.stream()
                .filter(c -> !vowels.contains(c))
                .collect(toList())
                .stream()
                .forEach(c -> sb.append(c));
        return sb.toString();
    }

    private static List<Character> convertStringToList(String string) {

        return new AbstractList<Character>() {

            @Override
            public int size() {
                return string.length();
            }

            @Override
            public Character get(int index) {
                return string.charAt(index);
            }
        };
    }

    public static String disemvowel2(String Z) {
        return Z.replaceAll("(?i)[aeiou]" , "");
    }

    public static String disemvowel3(String str) {
        return str.replaceAll("[aAeEiIoOuU]", "");
    }

    public static String disemvowel4(String str) {
        return  str.replaceAll("(?i)[aeiouâãäåæçèéêëìíîïðñòóôõøùúûü]", "");
    }


    private static final Pattern DISEMVOWEL_PATTERN = Pattern.compile("[AaEeIiOoUu]");


    public static String disemvowel5(String str) {
        return DISEMVOWEL_PATTERN.matcher(str).replaceAll("");
    }

    public static String disemvowel6(String str) {
        String output = "";
        for (int i=0; i<str.length(); i++) {
            switch (str.toLowerCase().charAt(i)) {
                case 'a': output+= "";
                    break;
                case 'e': output+= "";
                    break;
                case 'i': output+= "";
                    break;
                case 'o': output+= "";
                    break;
                case 'u': output+= "";
                    break;
                default: output+= str.charAt(i);
            }
        }
        return output;
    }

    public static String disemvowel7(String origin) {
        return origin.chars()
                .mapToObj(value -> (char)value)
                .filter(ch -> !java.util.Arrays.asList('A','E','O','I','U')
                        .contains(Character.toUpperCase(ch)))
                .map(String::valueOf)
                .collect(java.util.stream.Collectors.joining());
    }

    public static String disemvowel8(String str) {
        String toBeReplaced = str;
        toBeReplaced = toBeReplaced.replace("a","");
        toBeReplaced = toBeReplaced.replace("e","");
        toBeReplaced = toBeReplaced.replace("i","");
        toBeReplaced = toBeReplaced.replace("o","");
        toBeReplaced = toBeReplaced.replace("u", "");
        toBeReplaced = toBeReplaced.replace("A","");
        toBeReplaced = toBeReplaced.replace("E","");
        toBeReplaced = toBeReplaced.replace("I","");
        toBeReplaced = toBeReplaced.replace("O","");
        toBeReplaced = toBeReplaced.replace("U", "");
        return toBeReplaced;
    }

    public static String disemvowel9(String str) {
        return Arrays.stream(str.split(" "))
                .map(i -> i.replaceAll("[aeiouAEIOU]", ""))
                .collect(Collectors.joining(" "));
    }

    public static String disemvowel10(String str) {
        List<String> list = new ArrayList<>(Arrays.asList(str.split("")));
        list.removeIf(s -> s.matches("(?i)[aeiou]"));

        return String.join("", list);
    }

    public static String disemvowel11(String str) {
        // Code away...
        String[] vowels = {"a","e","i","o","u","A","E","I","O","U"};

        for ( String v : vowels) {
            str = str.replace(v,"");
        }
        return str;
    }
}
