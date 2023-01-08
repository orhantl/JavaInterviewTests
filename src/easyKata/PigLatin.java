package easyKata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isAlphabetic;

public class PigLatin {

    public static void main(String[] args) {
        int i = '5';
        System.out.println(i);
    }

    /*Description:
     * Move the first letter of each word to the end of it, then add "ay" to the end of the word.
     * Leave punctuation marks untouched.
     * Examples
     * pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
     * pigIt('Hello world !');     // elloHay orldway !
     */

    public static String pigIt(String str) {
        String[] splittedString = str.split(" ");
        for (int i = 0 ; i < splittedString.length ; i++) {
            StringBuilder internSb = new StringBuilder(splittedString[i]);
            String s = splittedString[i];
            if (checkItIsAWord(s)) {
                char c = internSb.charAt(0);
                internSb.deleteCharAt(0).append(c).append("ay");
            }

            splittedString[i] = internSb.toString();
        }

        StringBuilder sb = new StringBuilder();
        for(String s : splittedString) {
            sb.append(s).append(" ");
        }

        return sb.toString().trim();
    }

    public static boolean checkItIsAWord(String s) {
        char[] chars = s.toCharArray();
        boolean isAWord = false;

        for (char c : chars) {
            if(Character.isLetterOrDigit(c))
                isAWord = true;
        }
        return isAWord;
    }

    public static String pigIt2(String str) {
        return Arrays.stream(str.trim().split(" "))
                .map(v -> v.matches("[a-zA-Z]+") ? v.substring(1).concat(v.substring(0, 1)).concat("ay") : v)
                .collect(Collectors.joining(" "));
    }

    public static String pigIt3(String str) {
        return Arrays.stream(str.split(" ")).map(PigLatin::pigify).collect(Collectors.joining(" "));
    }

    private static String pigify(String word){
        return word.length() > 1 || Character.isLetter(word.charAt(0)) ? word.substring(1) + word.charAt(0) + "ay" : word;
    }

    public static String pigIt4(String str) {
        StringBuilder result = new StringBuilder();

        for (String s : str.split(" ")) {
            char firstLetter = s.charAt(0);

            result.append(s, 1, s.length())
                    .append(firstLetter)
                    .append(isAlphabetic(firstLetter) ? "ay" : "")
                    .append(" ");
        }

        return result.substring(0, result.length()-1); //why not result.toString()
    }

    private static final Pattern regex = Pattern.compile("(\\w)(\\w*)");

    public static String pigIt5(String str) {
        return regex.matcher(str).replaceAll("$2$1ay");
    }

    public static String pigIt6(String str) {
        String puncuation = "!?,.";
        List<String> words = new ArrayList<>(Arrays.asList(str.split(" ")));
        List<String> pigLatinWords = new ArrayList<>();

        for (String word : words) {
            String newWord = !puncuation.contains(word) ? word.substring(1) + word.charAt(0) + "ay" : word;
            pigLatinWords.add(newWord);
        }

        return String.join(" ", pigLatinWords);
    }

    public static String pigIt7(String str) {
        String s = "";
        for (String STR : str.split(" ")) {
            if(!STR.matches("\\W")) {
                s += STR.substring(1) + STR.charAt(0) + "ay";
            }
            else
                s += STR;
            s += " ";
        }
        return s.substring(0, s.length() - 1);
    }

    static String func(String s){
        return s.substring(1,s.length()) + s.charAt(0) + "ay";
    }
    static boolean isp(String s){
        return s.equals("!") || s.equals(",") || s.equals(";") || s.equals(".") || s.equals("?") || s.equals(":")
                || s.equals('\'') || s.equals('\"');
    }
    public static String pigIt8(String str) {
        String[] arr = str.split(" ");
        for(int i = 0; i < arr.length; i++){
            if(!isp(arr[i])){arr[i] = func(arr[i]);}
        }
        return String.join(" " , arr);
    }

    public static String pigIt9(String str) {
        String[] inputArray = str.split(" ");
        StringBuilder result = new StringBuilder();

        for(String element : inputArray) {
            if( element.length() >= 1 && ( element.toLowerCase().charAt(0) > 96 && element.toLowerCase().charAt(0) < 123) )
                result.append(element.substring(1) + element.substring(0,1)+ "ay" + " ");
            else
                result.append(element).append(" ");
        }
        return result.toString().trim();
    }

    public static String pigIt10(String str) {
        return str != null ? str.replaceAll("(\\w{1})(\\w*)", "$2$1ay") : null;
    }

    public static String pigIt11(String str) {
        return Stream.of(str.split(" "))
                .map(word -> word.matches("^[a-zA-Z]+$")
                        ? (new StringBuilder(word)).append(word.charAt(0)).deleteCharAt(0).append("ay").toString()
                        : word)
                .collect(Collectors.joining(" "));
    }

    static String pigIt12(String str) {
        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
    }
}
