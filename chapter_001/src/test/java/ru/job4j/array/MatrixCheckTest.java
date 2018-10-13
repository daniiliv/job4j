package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class MatrixCheckTest.
 *
 * @author Ivanov Daniil (dania-spb@mail.ru)
 */
public class MatrixCheckTest {
    /**
     * Method tests mono method.
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
    /**
     * Method tests mono method.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
    /**
     * Method tests mono method.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse2() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, false, true},
                {false, true, true, true},
                {true, false, true, true},
                {true, false, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
    /**
     * Method tests mono method.
     */
    @Test
    public void whenDataMonoByFalseThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {false, true, false, true},
                {false, false, true, true},
                {true, false, false, true},
                {true, false, false, false}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }


}