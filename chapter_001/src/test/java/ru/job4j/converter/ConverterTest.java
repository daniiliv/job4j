package ru.job4j.converter;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Class ConverterTest tests methods of class Converter.
 * @author Daniil Ivanov
 * @since 7.10.18
 * @version 1.1
 *
 */
public class ConverterTest {
    /**
     * Method checks whether method rubleToDollar returns 1 if we input 60
     * as an argument of a method.
     */
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        double result = converter.rubleToDollar(60);
        //assertThat(result, is(1));
        assertThat(result, closeTo(1.0, 0.1));
    }

    /**
     * Method checks whether method rubleToEuro returns 1 if we input 70
     * as an argument of a method.
     */
    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        double result = converter.rubleToEuro(70);
        //assertThat(result, is(1));
        assertThat(result, closeTo(1.0, 0.1));
    }

    /**
     * Method checks whether method rubleToEuro returns 2.8 if we input 195
     * as an argument of a method.
     */
    @Test
    public void when195RubleToEuroThen2point8() {
        Converter converter = new Converter();
        double result = converter.rubleToEuro(195);
        //assertThat(result, is(1));
        assertThat(result, closeTo(2.8, 0.1));
    }

    /**
     * Method checks whether method dollarToRuble returns 120 if we input 2
     * as an argument of a method.
     */
    @Test
    public void when2DollarToRubleThen120() {
        Converter converter = new Converter();
        int result = converter.dollarToRuble(2);
        assertThat(result, is(120));
    }

    /**
     * Method checks whether method euroToRuble returns 210 if we input 3
     * as an argument of a method.
     */
    @Test
    public void when3EuroToRubleThen120() {
        Converter converter = new Converter();
        int result = converter.euroToRuble(3);
        assertThat(result, is(210));
    }
}