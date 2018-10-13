package ru.job4j.array;
/**
 * Class MatrixCheck.
 *
 * @author Ivanov Daniil (dania-spb@mail.ru)
 */
public class MatrixCheck {
    /**
     * Method mono.
     * @param data 2D array.
     * @return true of false.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if (data[0][0] != data[i][i]) {
                result = false;
                break;
            }
            if (data[0][data.length - 1] != data[i][data.length - i - 1]) {
                result = false;
                break;
            }

        }
        return result;
    }
}