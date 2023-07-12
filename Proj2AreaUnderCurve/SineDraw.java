import java.awt.Graphics;
import java.awt.Color;

public class SineDraw {
    public static void main(String[] args) {
        DrawingPanel graph = new DrawingPanel();
        Graphics graphics = graph.getGraphics();
        graphics.setColor(Color.RED);
        drawSineWave(graphics);
    }
    public static void drawSineWave(Graphics graphic) {
        double h = Math.PI/32;
        for (double theta = 0; theta <= Math.PI/2; theta += h) {
            graphic.drawLine(
            (int) (theta),
            (int) (Math.sin(theta)),
            (int) (theta + h),
            (int) (Math.sin(theta + h))
            );
        }
    }
}
