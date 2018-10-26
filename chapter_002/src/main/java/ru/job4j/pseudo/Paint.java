
package ru.job4j.pseudo;
/**
 * @author Daniil Ivanov (dania-spb@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    /**
     * Метод отрисовки фигуры.
     * @param shape Тип фигуры.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}