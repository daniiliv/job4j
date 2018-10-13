package ru.job4j.array;

import java.util.Arrays;

/**
 * Class ArrayDuplicate.
 *
 * @author Ivanov Daniil (dania-spb@mail.ru)
 */
public class ArrayDuplicate {
    /**
     * Method remove.
     * @param array array of strings.
     * @return array of strings.
     */
    public String[] remove(String[] array) {
        int elements = array.length;
        for (int i = 0; i < elements; i++) {
            for (int j = i + 1; j < elements; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[elements - 1];
                    elements--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, elements);
    }
}
