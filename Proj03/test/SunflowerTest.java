package Proj03.test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import Proj03.src.Circle;

public class SunflowerTest {
    
        Circle testCircle = new Circle(Color.BLACK, 300, 150, 54);

    @Test
    public void testGetColor() {
        assertEquals(null, Color.BLACK, testCircle.getColor());
    }

    @Test
    public void testGetRadius() {
        assertEquals(null, 54, testCircle.getRadius(), 0);
    }

    @Test
    public void testGetCenterY() {
        assertEquals(null, 150, testCircle.getCenterY(), 0);
    }

    @Test
    public void testCartesianXToGraphicsX() {
        assertEquals(null, 500, Circle.cartesianXToGraphicsX(400,testCircle.getCenterX()), 0);
    }

    @Test
    public void testCartesianYToGraphicsY() {
        assertEquals(null, 50, Circle.cartesianYToGraphicsY(400,testCircle.getCenterY()), 0);
    }
    @Test
    public void testSetCenterX() {
        testCircle.setCenterX(-50);
        assertEquals(null, -50, testCircle.getCenterX(), 0);
    }

    @Test
    public void testSetCenterY() {
        testCircle.setCenterY(-200);
        assertEquals(null, -200, testCircle.getCenterY(), 0);
    }

    @Test
    public void testSetColor() {
        testCircle.setColor(Color.CYAN);
        assertEquals(null, Color.CYAN, testCircle.getColor());
    }

    @Test
    public void testSetRadius() {
        testCircle.setRadius(1);
        assertEquals(null, 1, testCircle.getRadius(), 0);
    }

    @Test
    public void testToString() {
        assertEquals(null, "Circle centered at ("  +
            testCircle.getCenterX() + ", " + testCircle.getCenterY() + ") " +
            "with radius " + testCircle.getRadius() + " and color " + testCircle.getColor(),
            testCircle.toString()
        );
    }
}
