package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class tests class Factorial.
 * @author Daniil Ivanov
 */
public class FactorialTest {
    /**
     * Method tests calc when n is 5.
     */
    @Test
    public void whenFiveThen120() {
        Factorial fact = new Factorial();
        int result = fact.calc(5);
        int expected = 120;
        assertThat(result, is(expected));
    }

    /**
     * Method tests calc when n is 8.
     */
    @Test
    public void when8Then40320() {
        Factorial fact = new Factorial();
        int result = fact.calc(8);
        int expected = 40320;
        assertThat(result, is(expected));
    }

    /**
     * Method tests calc when n is 0.
     */
    @Test
    public void when0Then1() {
        Factorial fact = new Factorial();
        int result = fact.calc(0);
        int expected = 1;
        assertThat(result, is(expected));
    }

    /**
     * Method tests calc when n is 1.
     */
    @Test
    public void when1Then1() {
        Factorial fact = new Factorial();
        int result = fact.calc(1);
        int expected = 1;
        assertThat(result, is(expected));
    }

}



