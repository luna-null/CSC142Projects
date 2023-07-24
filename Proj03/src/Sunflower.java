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

        Main.drawGradientBackground(
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
        }

        //TODO - draw the sunflower!

    }

    public void sleepHalfSecond() {
        
        //TODO - ask Barry how to make this

    }
}
