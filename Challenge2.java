package week1.challenges;

import java.util.Arrays;
import java.util.ArrayList;
/*A prime number (or a prime) is an integer greater than 1 that has no positive divisors other than 1 and itself.

Write a program which takes as input an int value n and returns an array of int containing all unique primes <= n.

Example: if the value of n is 8, the function should return: {2,3,5,7}

Hint: One well-known algorithm for doing this is over 2,000 years old, but it's not the most efficient.

Remember, you are not allowed to use any primality testing functions.*/
public class Challenge2 {


    // My Solution
    ArrayList primeNoList (int n){
        ArrayList result = new ArrayList();
        if(n >= 2)
            result.add(2);

        int i = 1;

        for(i=i+2; i<=n; i=i+2 ){
            if(isPrime(i))
                result.add(i);
        }

        return result;
    }

    boolean isPrime(int n) {

        //if (n < 2) return false;

        int maxIteration = (int)Math.ceil(Math.sqrt(n));

        for (int i = 2; i <= maxIteration; i++) {

            if(n % i == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(new Challenge2().sieve(100));


        System.out.println("prime "+new Challenge2().primeNoList(100));
        System.out.println("size "+new Challenge2().primeNoList(100).size());

       // System.out.println("no "+(100/Math.log(100-1)));

        // System.out.println("isPrime "+new Challenge2().isPrime(9));

    }

    // Solution provided
    // Eratosthenes algorithm
    public ArrayList<Integer> sieve(int A) {
        boolean prime [] = new boolean[A + 1];

        int counter = 1;
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i <= A; i++) {
            if (!prime[i])
                continue;

            for (long j = 1L * i * i; j <= (long) A; j += i) {
                prime[(int) j] = false;

            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i <= A; i++) {

            if (prime[i])
                res.add(i);
        }

        return res;
    }
}
