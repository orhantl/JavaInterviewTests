package easyKata;

import java.util.HashSet;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class MultiplesOf3And5 {

    /* If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
     * The sum of these multiples is 23.
     * Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.
     * Additionally, if the number is negative, return 0 (for languages that do have them).
     * Note: If the number is a multiple of both 3 and 5, only count it once.*/

    public int solution(int number) {
        int result;
        Set<Integer> sumOfMultiples = new HashSet<>();
        for (int i = 0; i < number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sumOfMultiples.add(i);
            }
        }
        result = sumOfMultiples.stream().reduce(0, Integer::sum);
        return result;
    }


    public int solution2(int number) {
        int sum = 0;

        for (int i = 0; i < number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }


    public int solutionWithIntStream(int number) {

        // alternate :  return IntStream.range(3, number).filter(n -> n % 3 == 0 || n % 5 == 0).sum();
        return IntStream.range(0, number)
                .filter(n -> (n % 3 == 0) || (n % 5 == 0))
                .sum();
    }


    public int solutionWithIntStreamVariation(int number) {
        //INT STREAMS FTW!
        IntPredicate i = s -> s % 5 == 0;
        return IntStream.iterate(1, n -> n + 1)
                .limit(number-1)
                .filter(i.or(s -> s % 3 == 0))
                .sum();
    }

    public int solutionWithMathCeil(int n) {
        int a = (int) Math.ceil(n / 3d) - 1;
        int b = (int) Math.ceil(n / 5d) - 1;
        int c = (int) Math.ceil(n / 15d) - 1;
        return (3 * a * (a + 1) + 5 * b * (b + 1) - 15 * c * (c + 1)) / 2;
    }


    public int solutionWithTernary(int number) {
        int sum =0;
        for (int i = 1; i< number ; i++){
            sum += ( i%3 == 0 || i%5 == 0)?i:0;
        }
        return sum;
    }


    public int solutionWtf(int number) {
        int numberIncluding = number - 1;

        int result = 0;
        result += sumUpTo(numberIncluding / 3) * 3;
        result += sumUpTo(numberIncluding / 5) * 5;
        result -= sumUpTo(numberIncluding / 15) * 15;
        return result;
    }

    private static int sumUpTo(int n) {
        return n * (n + 1) / 2;
    }
}


