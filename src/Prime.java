import java.math.BigInteger;
import java.util.stream.IntStream;

public class Prime {

    /*
    * Define a function that takes an integer argument and returns a logical value true or false depending on
    * if the integer is a prime.
    * Per Wikipedia, a prime number ( or a prime ) is a natural number greater than 1 that has no positive divisors other
    * than 1 and itself. Requirements
    *
    * You can assume you will be given an integer input.
    * You can not assume that the integer will be only positive. You may be given negative numbers as well ( or 0 ).
    * NOTE on performance: There are no fancy optimizations required, but still the most trivial solutions might time
    * out. Numbers go up to 2^31 ( or similar, depending on language ). Looping all the way up to n, or n/2,
    * will be too slow.
    * /check for explanation and solution https://en.wikipedia.org/wiki/Primality_test
*/

    public static boolean isPrime(int num) {
        if (num == 2 || num == 3)
            return true;
        if (num <= 1 || num % 2 == 0 || num % 3 == 0)
            return false;
        for (int i = 5; i * i <= num ; i+=6)
            if (num % i == 0 || num % (i + 2) == 0)
                return false;
        return true;
    }

    // other possible solutions

    public static boolean isPrimeWithSqrt(int number) {
        // Filter out negative numbers, 0 and 1
        if(number < 2)
            return false;
        // Factors of a number form pairs and the middle pair is the square root so no
        // reason to test numbers beyond that
        for (int i=2; i<=Math.sqrt(number); i++){
            if(number % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isPrimeWithBigInteger(int num) {
        // equivalent with a ternary : num > 1 ? BigInteger.valueOf(num).isProbablePrime(1) : false;
        return num > 1 && java.math.BigInteger.valueOf(num).isProbablePrime(20);
    }

    // variation
    public static boolean isPrimeWithBigIntegerBis(int num) {
        if (num < 2) { return false; }
        BigInteger result = BigInteger.valueOf(num);
        return result.isProbablePrime((int)Math.log(num));
    }

    public static boolean isPrimeWithLambda(int num) {
        if(num <= 2)
            return num == 2;
        else
            return (num % 2) != 0
                    &&
                    IntStream.rangeClosed(3, (int)Math.sqrt(num))
                            .filter(n -> n % 2 != 0)
                            .noneMatch(n -> (num % n == 0));
    }

    /*
    * public static boolean isPrimeWithApacheCommons(int num) {
    *    return Primes.isPrime(num);
    * }
    * */
}


