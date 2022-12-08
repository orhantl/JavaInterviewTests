package easyKata;

import java.util.Arrays;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class KataHalloween {

    int a = 12;
    float b = 13;
    float bPrime = 13.1f;
    double c = 14;
    double cPrime = 14.1;

    Float b1 = 13f; // 13f / F
    Double c1 = 14d; // 14d / D


    private String trickOrTreat = "Trick or treat!";
    private String thankYou = "Thank you, strange uncle!";

    public static void main(String[] args) {

        String s = "animals";
        System.out.println(s.indexOf('a'));

        String Str = "Welcome to Tutorialspoint.com";

        System.out.print("Found Index :" );
        System.out.println(Str.indexOf( 'o', 5 ));
    }

    public String trickOrTreat(int numberOfChildren, String[][] packets) {

        if (isThereMissingPacket(numberOfChildren, packets)) {
            return trickOrTreat;
        }

        if (isBelowLimitOfTwoCandies(packets)) {
            return trickOrTreat;
        }

        if (isContainingABomb(packets)) {
            return trickOrTreat;
        }

        if (isUnequalNumberOfCandies(packets)) {
            return trickOrTreat;
        } else return thankYou;
    }


    private boolean isUnequalNumberOfCandies(String[][] packets) {
        Set<Long> candies = Arrays.stream(packets)
                .map(packet -> Arrays.stream(packet).filter(p -> p.equals("candy")).count()).collect(Collectors.toSet());

        if (candies.size() != 1) {
            return true;
        }
        return false;
    }

    private boolean isBelowLimitOfTwoCandies(String[][] packets) {
        for (String[] packet : packets) {
            long candies = Arrays.stream(packet).filter(p -> p.equals("candy")).count();
            if (candies < 2) {
                return true;
            }
        }
        return false;

    }

    private boolean isThereMissingPacket(int numberOfChildren, String[][] packets) {
        if (packets.length < numberOfChildren) {
            return true;
        }
        return false;
    }

    private boolean isContainingABomb(String[][] packets) {
        for (String[] packet : packets) {
            if (Arrays.asList(packet).contains("bomb")) {
                return true;
            }
        }
        return false;
    }

    private void something() {

      int num = 2;
        int num2 = Math.abs(num);

                List<Integer> firstPrimes = List.of(2, 3, 5, 7, 11);

        if (firstPrimes.contains(num)) {

        }
    }

}
