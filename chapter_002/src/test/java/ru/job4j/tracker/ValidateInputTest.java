package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Тест класса-валидатора.
 *
 * @author Daniil Ivanov (dania-spb@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        input.ask("Enter", new int[] {1});
        assertThat(
                this.mem.toString(),
                is(new StringBuilder()
                        .append("Please, enter correct number: ")
                        .append(System.lineSeparator())
                        .toString())
        );
    }

    @Test
    public void whenInvalidInputOutOfRange() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"5", "1"})
        );
        input.ask("Enter", new int[] {1});
        assertThat(
                this.mem.toString(),
                is(new StringBuilder()
                        .append("Please, select correct menu option: ")
                        .append(System.lineSeparator())
                        .toString())
        );
    }
}