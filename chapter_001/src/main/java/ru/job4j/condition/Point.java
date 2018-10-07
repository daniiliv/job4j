package ru.job4j.condition;

/**
 *
 * Class point contains x and y coords and also method distanceTo
 * that returns a distance between two points.
 * @author Daniil Ivanov (dania-spb@mail.ru)
 *
 */
public class Point {
    /**
     * Contains x coord.
     */
    private int x;
    /**
     * Contains y coord.
     */
    private int y;

    /**
     * Constructor,
     * @param x coord x
     * @param y coord y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method returns...
     * @param that coord of a point.
     * @return distance to a current point.
     */
    public double distanceTo(Point that) {

        return Math.sqrt(Math.pow(that.x - this.x, 2) + Math.pow(that.y - this.y, 2));
    }
}