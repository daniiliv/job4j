package ru.job4j.max;

/**
 * Class max contains methods: max and summation.
 */
public class Max {
    /**
     * Method returns max from 2 numbers.
     * @param first first number.
     * @param second second number.
     * @return max from two numbers.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Method returns sum of two nums.
     * @param first first num.
     * @param second second num.
     * @return sum of first and second num.
     */
    public int summation(int first, int second) {
        return first + second;
    }

    /**
     * Method returns max from 3 numbers.
     * @param first first number.
     * @param second second number.
     * @param third third number.
     * @return max from two numbers.
     */
    public int max(int first, int second, int third) {
        //int temp = this.max(first, second);
        return this.max(this.max(first, second), third);
    }
}