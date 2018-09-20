package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.beans.Transient;

/**
 * Test.
 * 
 * @author Daniil Ivanov (mailto:dania-spb@mail.ru)
 * @version  $ld$
 * @since 0.1
 */
public class CalculateTest {
    /**
     * Test echo.
     */
    @Test
    public void whenTakeNameThenTreeEchoPlusName() {
        String input = "Daniil Ivanov";
        String expect = "Echo, echo, echo : Daniil Ivanov";

        Calculate calc = new Calculate();

        String result = calc.echo(input);

        assertThat(result, is(expect));
    }
}