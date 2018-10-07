package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Class tests Point class.
 * @author Daniil Ivanov
 */
public class PointTest {

    /**
     * Method checks whether method distanceTo returns 3.16 if we input coords x = 5, y = 2 of point B
     * as an argument of a method. Coords of point A equal to x = 2, y = 3.
     */
    @Test
    public void whenPointAequalsTo2and3PointBequalsTo5and3distanceToThen3point16() {
        Point pointA = new Point(2, 3);
        Point pointB = new Point(5, 2);

        double result = pointA.distanceTo(pointB);

        assertThat(result, closeTo(3.16, 0.1));
    }
}

