package ru.job4j.loop;

/**
 * Class Counter contains method sumOfOddNums.
 */
public class Counter {
    /**
     * Method returns sum of odd numbers from start to finish.
     * @param start first number.
     * @param finish second number.
     * @return sum.
     */
    public int sumOfOddNums(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}