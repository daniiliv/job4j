package ru.job4j.calculator;
/**
 * Calculator.
 *
 * @author Ivanov Daniil (dania-spb@mail.ru)
 */
class Calculator {
    /**
     * Contains a result of calculation.
     */
    private double result;

    /**
     * Method add.
     * @param first First operand.
     * @param second Second operand.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method subtract.
     * @param first First operand.
     * @param second Second operand.
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method div.
     * @param first First op.
     * @param second Second op.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Method multiple.
     * @param first First op.
     * @param second Second op.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method getResult.
     * @return result of calculation.
     */
    public double getResult() {
        return this.result;
    }


}