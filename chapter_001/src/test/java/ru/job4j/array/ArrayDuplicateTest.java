

package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ArrayDuplicateTest.
 */
public class ArrayDuplicateTest {
    /**
     * Method tests method remove.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate aDupl = new ArrayDuplicate();
        String[] input =  {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] result = aDupl.remove(input);
        String[] expected = {"Привет", "Мир", "Супер"};
        assertThat(result, is(expected));
    }

    /**
     * Method tests method remove.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicateTwo() {
        ArrayDuplicate aDupl = new ArrayDuplicate();
        String[] input =  {"Вова", "Петя", "Митя", "Женя", "Дима", "Антон", "Антон", "Вова"};
        String[] result = aDupl.remove(input);
        String[] expected = {"Вова", "Петя", "Митя", "Женя", "Дима", "Антон"};
        assertThat(result, is(expected));
    }
}

