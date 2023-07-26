package Proj03.src;

import java.awt.Color;
import java.awt.Graphics;

import Proj03.lib.DrawingPanel;

public class Sunflower {
    
    public final Color COLOR_CENTER = new Color(94, 54, 23);
    public final Color COLOR_PETALS = new Color(252, 206, 1);
    
    int drawingSize;
    int centerRadius;
    int petalCount;

    /**
     * Constructor for Sunflower class.
     *
     * @param drawingSize size of the drawing panel
     * @param centerRadius radius of the flower's center
     * @param petalCount petal count
     */
    public Sunflower(int drawingSize, int centerRadius, int petalCount) {

        this.drawingSize = drawingSize;
        this.centerRadius = centerRadius;
        this.petalCount = petalCount;
    }

    /**
     * Draws sunflower.
     */
    public void draw() {

        DrawingPanel picture = new DrawingPanel(drawingSize, drawingSize);
        Graphics graphic = picture.getGraphics();

        drawGradientBackground(
            graphic,
            Main.COLOR_BACKGROUND_TOP, Main.COLOR_BACKGROUND_BOTTOM,
            drawingSize
        );
        double radius = centerRadius*drawingSize/(2*petalCount*petalCount*Math.sqrt(petalCount));
        Circle flowerCenter = new Circle(
            COLOR_CENTER,
            0, 0, radius);

        flowerCenter.draw(graphic, drawingSize);

        for (int iter = 0; iter <= petalCount; iter++) {
            double petalCenterX = 1.5*radius*Math.sin(2.0*Math.PI*(double)iter/(double)petalCount)-1;
            double petalCenterY = 1.5*radius*Math.cos(2.0*Math.PI*(double)iter/(double)petalCount)+1;

            Circle petal = new Circle(
                COLOR_PETALS,
                (int)(petalCenterX), (int)(petalCenterY), (int)(radius/2)
                );
            petal.draw(graphic, drawingSize);
            sleepHalfSecond();
        }

    }

    /**
     * Makes petals wait half a second to be drawn.
     */
    public static void sleepHalfSecond() {
        try {
        Thread.sleep(500);
        } catch (InterruptedException e) {
            // do nothing
        }
    }

    /**
     * Draws gradient background.
     *
     * @param   graphics    graphics object to draw on
     * @param   topColor    color at the top of the gradient
     * @param   bottomColor color at the bottom of the gradient
     * @param   drawingSize size of the drawing panel
     */
    public static void drawGradientBackground(
        Graphics graphics, Color topColor, Color bottomColor, int drawingSize) {

            int topRed = topColor.getRed();
            int topGreen = topColor.getGreen();
            int topBlue = topColor.getBlue();

            int bottomRed = bottomColor.getRed();
            int bottomGreen = bottomColor.getGreen();
            int bottomBlue = bottomColor.getBlue();


            for (int Yi = 0; Yi < drawingSize; Yi++) {
                double p = (double) Yi / (double) drawingSize;
                int YiRed = (int)Math.abs(
                    (1-p) * topRed + p * bottomRed
                );
                int YiGreen = (int)Math.abs(
                    (1-p) * topGreen + p * bottomGreen
                );
                int YiBlue = (int)Math.abs(
                    (1-p) * topBlue + p * bottomBlue
                );
                Color YiColor = new Color(YiRed, YiGreen, YiBlue);

                graphics.setColor(YiColor);
                graphics.drawLine(0, Yi, drawingSize, Yi);
            }
    }
}
