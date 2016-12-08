import java.util.TreeSet;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * @author Markus Reichl
 * @version 08.11.2016
 */

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibTree(10));
        System.out.println(fibTree(20));
    }

    private static TreeSet<Integer> fibTree(int size) {
        TreeSet<Integer> t = new TreeSet<>();
        for (int i = 0; i < size; i++) {
            t.add((int) fib(i));
        }

        return t;
    }

    private static double fib(int n) {
        return ((pow(1 + sqrt(5), n) - pow(1 - sqrt(5), n))/(pow(2, n) * sqrt(5)));
    }
}
