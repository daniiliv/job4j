package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Daniil Ivanov (dania-spb@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class PaintTest {
    @Test
    public void whenPaintPyWithHeightOfThreeThenPyWithHeightOfThree() {
        Paint paint = new Paint();
        String result = paint.pyramid(3);
        final String line = System.getProperty("line.separator");
        String expected = String.format("  ^  %s ^^^ %s^^^^^%s", line, line, line);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPaintPyWithHeightOfFiveThenPyWithHeightOfFive() {
        Paint paint = new Paint();
        String result = paint.pyramid(5);
        final String line = System.getProperty("line.separator");
        String expected = String.format("    ^    %s   ^^^   %s  ^^^^^  %s ^^^^^^^ %s^^^^^^^^^%s", line, line, line, line, line);
        assertThat(result, is(expected));
    }
}