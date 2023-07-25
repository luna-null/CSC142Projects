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

    public Sunflower(int drawingSize, int centerRadius, int petalCount) {

        this.drawingSize = drawingSize;
        this.centerRadius = centerRadius;
        this.petalCount = petalCount;
    }

    public void draw() {

        DrawingPanel picture = new DrawingPanel(drawingSize, drawingSize);
        Graphics graphic = picture.getGraphics();

        drawGradientBackground(
            graphic,
            Main.COLOR_BACKGROUND_TOP, Main.COLOR_BACKGROUND_BOTTOM,
            drawingSize
        );

        Circle flowerCenter = new Circle(
            COLOR_CENTER,
            0, 0, centerRadius);

        flowerCenter.draw(graphic, drawingSize);

        for (int iter = 0; iter <= petalCount; iter++) {
            double petalCenterX = (3*centerRadius/2)*Math.sin(2*Math.PI*iter/petalCount);
            double petalCenterY = (3*centerRadius/2)*Math.cos(2*Math.PI*iter/petalCount);

            Circle petal = new Circle(
                COLOR_PETALS,
                (int)(petalCenterX), (int)(petalCenterY), (int)(centerRadius/2)
            );
            petal.draw(graphic, drawingSize);
            sleepHalfSecond();
        }

    }

    public static void sleepHalfSecond() {
        try {
        Thread.sleep(500);
        } catch (InterruptedException e) {
            // do nothing
        }
    }
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
