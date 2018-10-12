package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {

    @Test
    public void whenArrayHasElem5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasElem78Then8() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3, 6, 8, 15, 19, -66, 78};
        int value = 78;
        int result = find.indexOf(input, value);
        int expect = 8;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayDoesntHaveElem228ThenMunis1() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3, 6, 8, 15, 19, -66, 78};
        int value = 228;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}