package ru.job4j.array;

/**
 * Class BubbleSort.
 *
 * @author Ivanov Daniil (dania-spb@mail.ru)
 */
public class BubbleSort {
    /**
     * Method sorts array using bubble sorting.
     * @param array array.
     * @return sorted array.
     */
    public int[] sort(int[] array) {
        int temp;
        //swapped - переменная, обозначающая, были ли перестановки в текущей итерации
        //нужна, в случае если проходов было меньше, чем N - 1, тогда выходим из цикла
        //- массив отсортирован
        boolean swapped = false;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            //условие array.length - i - 1 исключает последний элемент из
            //рассмотрения, так как он уже стоит на своём месте - отсортирован
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return array;
    }
}
