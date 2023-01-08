package easyKata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class HighestScoringWord {

    public static String high(String string) {
        String highestScoringWord = "";
        String[] sentence = string.split(" ");
        int count = 0;

        for (String word : sentence) {
            int wordValue = getWordValue(word);
            if (wordValue > count) {
                count = wordValue;
                highestScoringWord = word;
            }
        }
        return highestScoringWord;
    }

    private static int getWordValue(String word) {
        ArrayList<CharSequence> ref = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            ref.add(Character.toString(i));
        }
        return Arrays.stream(word.split("(?<=\\G.)")).mapToInt(s -> ref.contains(s) ? ref.indexOf(s) + 1 : 0).sum();
    }


    public static String high2(String s) {
        return Arrays.stream(s.split(" "))
                .max(Comparator.comparingInt(
                        a -> a.chars().map(i -> i - 96).sum()
                )).get();
    }

    public static String high2Bis(String s) {
        return Arrays.stream(s.toLowerCase().split(" "))
                .max(Comparator.comparingInt((String w) -> w.chars().map(c -> c - 96).sum()))
                .get();
    }

    public static String high3(String s) {

        String winner = "";
        int highScore = 0;

        for (String word : s.split(" ")) {
            int score = 0;
            for (char c : word.toCharArray()) {
                score += c - 'a' + 1;
            }
            if (score > highScore) {
                winner = word;
                highScore = score;
            }
        }

        return winner;
    }


    public static String high4(String s) {
        return Arrays.stream(s.split(" ")).max(Comparator.comparingInt(HighestScoringWord::calculateWordScore)).get();
    }

    private static int calculateWordScore(String word) {
        return word.chars().map(c -> c - (int)'a' + 1).sum();
    }


    public static String high5(String s) {
        String ret = "";
        int n, max = 0;
        for (String w : s.split(" ")) if ((n = w.chars().sum() - w.length() * ('a'-1)) > max) { ret = w; max = n; }
        return ret;
    }

}
