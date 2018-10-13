package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class BubbleSort.
 *
 * @author Ivanov Daniil (dania-spb@mail.ru)
 */
public class BubbleSortTest {
    /**
     * Method tests sorting.
     */
    @Test
    public void when64291Then12469() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = new int[] {6, 4, 2, 9, 1};
        int[] result = bubbleSort.sort(input);
        int[] expected = new int[] {1, 2, 4, 6, 9};

        assertThat(result, is(expected));
    }

    /**
     * Method tests sorting.
     */
    @Test
    public void when8elemsThen8elemsSorted() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = new int[] {13, 18, -2, 2, 2, 5, 0, 1};
        int[] result = bubbleSort.sort(input);
        int[] expected = new int[] {-2, 0, 1, 2, 2, 5, 13, 18};

        assertThat(result, is(expected));
    }

}