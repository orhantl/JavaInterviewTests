package easyKata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class TotalPoints {

    /* Instructions :
    * Our football team has finished the championship.
    * Our team's match results are recorded in a collection of strings. Each match is represented by a string in the format "x:y", where x is our team's score and y is our opponents score.
    * For example: ["3:1", "2:2", "0:1", ...]
    * Points are awarded for each match as follows:
    *
    * if x > y: 3 points (win)
    * if x < y: 0 points (loss)
    * if x = y: 1 point (tie)
    *
    * We need to write a function that takes this collection and returns the number of points our team (x) got in the championship by the rules given above.
    *
    * Notes:
    * Our team always plays 10 matches in the championship
    * 0 <= x <= 4
    * 0 <= y <= 4
    */

    public static int points( String[] games) {

        List<Integer> xScores = new ArrayList<>();
        List<Integer> yScores = new ArrayList<>();

        for(String s : games) {
            String xScore = s.substring(0, 1);
            String yScore = s.substring(2, 3);

            int x = Integer.parseInt(xScore);
            xScores.add(x);

            int y = Integer.parseInt(yScore);
            yScores.add(y);
        }

        int total = 0;
        for(int i = 0; i < xScores.size(); i++) {

            if (isTie(xScores.get(i), yScores.get(i))) {
                total += 1;
            }

            if (isWining(xScores.get(i), yScores.get(i))) {
                total += 3;
            }
        }
        return total;
    }

    private static boolean isWining(int x, int y) {
        if (x > y) {
            return true;
        }
            return false;
    }

    private static boolean isTie(int x, int y) {
        if (x == y) {
            return true;
        }
        return false;
    }

    public static int pointsBestPractice(String[] games) {
        int sum = 0;

        for (String s : games) {
            char x = s.charAt(0),
                    y = s.charAt(2);

            sum += x > y ? 3 : x == y ? 1 : 0;
        }

        return sum;
    }

    public static int pointsWithLambda(String[] games) {
        return Arrays.stream(games)
                .mapToInt(score -> score.charAt(0) - score.charAt(2))
                .map(match -> match > 0 ? 3 : match == 0 ? 1 : 0)
                .sum();
    }


    public static int pointsWithLambda2(String[] games) {
        return Stream.of(games)
                .mapToInt(TotalPoints::scoreMatchResult)
                .sum();
    }

    private static int scoreMatchResult(String score) {
        String[] split = score.split(":");
        int comparison = split[0].compareTo(split[1]);
        if (comparison > 0)
            return 3;
        else if (comparison == 0)
            return 1;
        else
            return 0;
    }


    public static int points2(String[] games) {
        return java.util.Arrays.stream(games).mapToInt(g ->
                g.charAt(0) > g.charAt(2) ? 3 :
                        g.charAt(0) < g.charAt(2) ? 0 : 1).sum();
    }


    public static int points3(String[] games) {
        int total = 0;
        for(String s : games){
            int x = Integer.parseInt(s.split(":",2)[0],10);
            int y = Integer.parseInt(s.split(":",2)[1],10);
            if(x > y){ total += 3;}
            if(x == y){ total += 1;}
        }
        return total;
    }


    public static int points4(String[] games) {
        int sum = 0;
        for(String s:games) sum += s.charAt(0)>s.charAt(2)?3:s.charAt(0)<s.charAt(2)?0:1;
        return sum;
    }


}
