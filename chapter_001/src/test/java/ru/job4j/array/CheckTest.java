package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class CheckTest.
         *
         * @author Ivanov Daniil (dania-spb@mail.ru)
        */
public class CheckTest {
    /**
     * Test mono.
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
    /**
     * Test mono.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
    /**
     * Test mono.
     */
    @Test
    public void whenDataMonoByFalseThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
    /**
     * Test mono.
     */
    @Test
    public void whenDataMonoByFalseAndTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false, false, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
    /**
     * Test mono.
     */
    @Test
    public void whenDataMonoByFalseAndTrueThenFalse2() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, false, true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}