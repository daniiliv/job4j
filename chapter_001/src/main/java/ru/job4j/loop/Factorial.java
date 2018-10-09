package ru.job4j.loop;

/**
 * Class Factorial contains method calc.
 */
public class Factorial {
    /**
     * Method calculates a factorial of a number.
     * @param n natural number.
     * @return factorial of n.
     */
    public int calc(int n) {
        int result;
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            result = 1;
        } else {
            result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
        }

        return result;
    }
}