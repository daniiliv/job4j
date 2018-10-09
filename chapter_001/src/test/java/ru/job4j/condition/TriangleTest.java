package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 * Class tests class Triangle.
 * @author Daniil Ivanov
 */
public class TriangleTest {
    /**
     * Tests method area. Square of an existing triangle.
     */
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        // создаем три объекта класса Point.
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        // Создаем объект треугольник и передаем в него объекты точек.
        Triangle triangle = new Triangle(a, b, c);
        // Вычисляем площадь.
        double result = triangle.area();
        // Задаем ожидаемый результат.
        double expected = 2D;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 0.1));
    }

    /**
     * Tests method area. Square of an existing triangle.
     */
    public void whenAreaSetThreePoints2ThenTriangleArea() {
        // создаем три объекта класса Point.
        Point a = new Point(5, 7);
        Point b = new Point(3, 4);
        Point c = new Point(8, 2);
        // Создаем объект треугольник и передаем в него объекты точек.
        Triangle triangle = new Triangle(a, b, c);
        // Вычисляем площадь.
        double result = triangle.area();
        // Задаем ожидаемый результат.
        double expected = 9.5;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 0.1));
    }

    /**
     * Tests method area. Square of an non-existing triangle.
     */
    public void whenThisIsNonExistingTriangleThenAreaIsMunus1() {
        // создаем три объекта класса Point.
        Point a = new Point(0, 0);
        Point b = new Point(10, 0);
        Point c = new Point(20, 0);
        // Создаем объект треугольник и передаем в него объекты точек.
        Triangle triangle = new Triangle(a, b, c);
        // Вычисляем площадь.
        double result = triangle.area();
        // Задаем ожидаемый результат.
        double expected = -1;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 0.1));
    }
}