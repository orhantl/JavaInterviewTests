package easyKata;

import java.util.Arrays;
import java.util.List;

public class NarcissisticNumber {

    public static boolean isNarcissistic(int number) {
        int numberOfDigits = String.valueOf(number).length();
        List<Integer> digits = Arrays.stream(String.valueOf(number).split(""))
                .map(Integer::valueOf)
                .toList();
        return digits.stream().mapToDouble(n -> Math.pow(n, numberOfDigits)).sum() == number;
    }
}
