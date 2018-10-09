package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class tests class Counter.
 * @author Daniil Ivanov
 */
public class CounterTest {
    /**
     * Method tests sumOfOddNums when start is 1 and finish is 10.
     */
    @Test
    public void when1To10Then30() {
        Counter counter = new Counter();
        int result = counter.sumOfOddNums(1, 10);
        int expected = 30;
        assertThat(result, is(expected));
    }

    /**
     * Method tests sumOfOddNums when start is 1 and finish is 10.
     */
    @Test
    public void when6To20Then104() {
        Counter counter = new Counter();
        int result = counter.sumOfOddNums(6, 20);
        int expected = 104;
        assertThat(result, is(expected));
    }
}



