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
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}