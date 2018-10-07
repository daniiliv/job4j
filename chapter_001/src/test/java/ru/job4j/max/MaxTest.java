package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class is Test of class Max.
 * @author Daniil Ivanov
 */
public class MaxTest {
    /**
     * Method tests method max.
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }
    /**
     * Method tests method max.
     */
    @Test
    public void whenMaxFrom5and2Then5() {
        Max maximum = new Max();
        int result = maximum.max(5, 2);
        assertThat(result, is(5));
    }
    /**
     * Method tests method summation.
     */
    @Test
    public void sum2and5Then7() {
        Max mxm = new Max();
        int result = mxm.summation(2, 5);
        assertThat(result, is(7));
    }

}




