package easyKata;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SheepCounting {

    /*
    * Description: If you can't sleep, just count sheep!!
    * Task:
    * Given a non-negative integer, 3 for example, return a string with a murmur: "1 sheep...2 sheep...3 sheep...".
    * Input will always be valid, i.e. no negative integers.
*/

    public static String countingSheep(int num) {
        StringBuilder result = new StringBuilder();

        if (num >= 1) {
            for (int i = 0; i < num; i++) {
                result.append(i + 1 + " sheep...");
            }
        }
        return result.toString();
    }

    public static String countingSheepWithLambda(int num) {
        return IntStream.rangeClosed(1, num)
                .mapToObj(i -> i + " sheep...")
                .collect(Collectors.joining());
    }

}
