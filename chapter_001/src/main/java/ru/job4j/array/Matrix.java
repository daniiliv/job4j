package ru.job4j.array;
/**
 * Class Matrix.
 *
 * @author Ivanov Daniil (dania-spb@mail.ru)
 */
public class Matrix {
    /**
     * Method calculates multiplicity table.
     * @param size size of table (size x size).
     * @return mult table.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}