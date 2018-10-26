package ru.job4j.pseudo;
/**
 * @author Daniil Ivanov (dania-spb@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Triangle implements Shape {
    /**
     * Метод возвращает фигуру - треугольник.
     * @return Строка - треугольник.
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   +   ");
        pic.append("  +++  ");
        pic.append("  +++++  ");
        pic.append("+++++++");
        return pic.toString();
    }
}
