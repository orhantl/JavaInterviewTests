package easyKata;

public class StringSplit {

    /*
     * Complete the solution so that it splits the string into pairs of two characters.
     * If the string contains an odd number of characters then it should replace the missing second character
     * of the final pair with an underscore ('_').*/

    public static String[] solution(String s) {
       return s.length() % 2 != 0 ? s.concat("_").split("(?<=\\G..)") : s.split("(?<=\\G..)");
    }

}
