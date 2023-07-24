package Proj03.src;
import java.awt.Color;
import java.awt.Graphics;

public class Circle {

    Color color;
    double centerX;
    double centerY;
    double radius;

    public Circle(
        Color color,
        double centerX, double centerY,
        double radius) {
        
        setColor(color);
        setCenterX(centerX);
        setCenterY(centerY);
        setRadius(radius);
    }

    public Color getColor() {
        return color;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }
    
    public double getRadius() {
        return radius;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

        public void setRadius(double radius) {
        this.radius = radius;
    }

    public void draw(Graphics graphics, int drawSize) {
        double graphX = cartesianXToGraphicsX(drawSize, centerX);
        double graphY = cartesianYToGraphicsY(drawSize, centerY);
        graphics.setColor(color);
        double topLeftBoundX = graphX - radius;
        double topLeftBoundY = graphY - radius;

        graphics.fillOval((int)topLeftBoundX, (int)topLeftBoundY, (int)(2*radius), (int)(2*radius));
    }

    public String toString() {
        String circleInfo =
            "Circle centered at ("
            + centerX + ", " + centerY + ") "
            + "with radius " + radius
            + " and color" + color;
        
        return circleInfo;
    }

    public static double cartesianXToGraphicsX(
        int drawWidth, double x) {
            double graphXCoords = drawWidth/2 + x;
            return graphXCoords;
        }

    public static double cartesianYToGraphicsY(
        int drawHeight, double y) {
            double graphYCoords = drawHeight/2 - y;
            return graphYCoords;
        }
}
