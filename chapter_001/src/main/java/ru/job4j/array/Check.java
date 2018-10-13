package ru.job4j.array;
/**
 * Class Check.
 *
 * @author Ivanov Daniil (dania-spb@mail.ru)
 */
public class Check {
    /**
     * Method mono.
     * @param data Array of booleans.
     * @return result of searching.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if (data[0] != data[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}