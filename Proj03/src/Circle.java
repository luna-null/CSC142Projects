package Proj03.src;
import java.awt.Color;
import java.awt.Graphics;

public class Circle {

    Color color;
    double centerX;
    double centerY;
    double radius;

    /**
     * Circle constructor with default values.
     *
     * @param   color       color of the circle
     * @param   centerX     x-coordinate of the center of the circle
     * @param   centerY     y-coordinate of the center of the circle
     * @param   radius      radius of the circle
     */
    public Circle(
        Color color,
        double centerX, double centerY,
        double radius) {
        
        setColor(color);
        setCenterX(centerX);
        setCenterY(centerY);
        setRadius(radius);
    }

    /**
     * Gets color of circle.
     *
     * @return  color of the circle
     */
    public Color getColor() {
        return color;
    }

    /**
     * Gets x-coordinate of circle center.
     *
     * @return  x-coordinate of the center of the circle
     */
    public double getCenterX() {
        return centerX;
    }

    /**
     * Gets y-coordinate of the center of the circle.
     *
     * @return  y-coordinate of the center of the circle
     */
    public double getCenterY() {
        return centerY;
    }
    
    /**
     * Gets radius of the circle.
     *
     * @return  radius of the circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets color of the circle.
     *
     * @param   color   color of the circle
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Sets x-coordinate of the center of the circle.
     *
     * @param   centerX x-coordinate of the center of the circle
     */
    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    /**
     * Sets y-coordinate of the center of the circle.
     *
     * @param centerY   y-coordinate of the center of the circle
     */
    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    /**
     * Sets radius of the circle.
     *
     * @param   radius  radius of the circle
     */
        public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Draws circle on the given graphics object.
     *
     * @param   graphics    graphics object to draw on
     * @param   drawSize    size of the drawing area
     * @throws  IllegalArgumentException    if the color is not specified,
     *                                      radius is negative,
     *                                      or drawSize is less than 1
     */
    public void draw(Graphics graphics, int drawSize) {
        if (color == null) {
        throw new IllegalArgumentException("Color must be specified!");
        }
        else if (radius < 0) {
            throw new IllegalArgumentException("Radius must not be negative!");
        }
        else if (drawSize < 1) {
            throw new IllegalArgumentException("Drawsize must be not be less than 1!");
        }
        else {
        double graphX = cartesianXToGraphicsX(drawSize, centerX);
        double graphY = cartesianYToGraphicsY(drawSize, centerY);
        double topLeftBoundX = graphX - radius;
        double topLeftBoundY = graphY - radius;
        
        graphics.fillOval((int)topLeftBoundX, (int)topLeftBoundY, (int)(2*radius), (int)(2*radius));
        }
    }

    /**
     * Returns string representation of the circle.
     *
     * @return  string representation of the circle
     */
    public String toString() {
        String circleInfo =
            "Circle centered at ("
            + centerX + ", " + centerY + ") "
            + "with radius " + radius
            + " and color " + color;
        
        return circleInfo;
    }

    /**
     * Converts Cartesian x-coordinate to graphics x-coordinate.
     *
     * @param   drawWidth   the width of the drawing area
     * @param   x           the Cartesian x-coordinate
     * @return  the corresponding graphics x-coordinate
     * @throws  IllegalArgumentException if drawWidth is less than 1
     */
    public static double cartesianXToGraphicsX(
        int drawWidth, double x) {
            if (drawWidth < 1) {
            throw new IllegalArgumentException("Drawsize must be not be less than 1!");
        }
            double graphXCoords = drawWidth/2 + x;
            return graphXCoords;
        }

    /**
     * Converts Cartesian y-coordinate to graphics y-coordinate.
     *
     * @param   drawHeight  height of the drawing area
     * @param   y           Cartesian y-coordinate
     * @return  corresponding graphics y-coordinate
     * @throws  IllegalArgumentException if drawHeight is less than 1
     */
    public static double cartesianYToGraphicsY(
        int drawHeight, double y) {
            if (drawHeight < 1) {
            throw new IllegalArgumentException("Drawsize must be not be less than 1!");
        }
            double graphYCoords = drawHeight/2 - y;
            return graphYCoords;
        }
}
