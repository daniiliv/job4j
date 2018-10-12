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
        boolean result = false;
        boolean flag = false;
        for (boolean aData : data) {
            if (data[0]) {
                if (!aData) {
                    result = false;
                    break;
                } else {
                    result = true;
                }
            } else {
                if (aData) {
                    result = false;
                    break;
                } else {
                    result = true;
                }
            }
        }
        return result;
    }
}