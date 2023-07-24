package Proj03.src;

import java.awt.Color;
import java.awt.Graphics;

public class Main {

    public static final Color COLOR_BACKGROUND_TOP = new Color(218, 227, 243);
    public static final Color COLOR_BACKGROUND_BOTTOM = new Color(143, 170, 220);
    public static void main(String[] args) {

        int drawingSize = 800;      // Drawing Size

        Sunflower sunflower = new Sunflower(drawingSize, (int)(drawingSize/4), 9);

        sunflower.draw();

        // TODO - do the thing.
        
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

                int YiRed = (int)Math.abs(
                    (1-(Yi/drawingSize)) * topRed - (Yi/drawingSize) * bottomRed
                );
                int YiGreen = (int)Math.abs(
                    (1-(Yi/drawingSize)) * topGreen - (Yi/drawingSize) * bottomGreen
                );
                int YiBlue = (int)Math.abs(
                    (1-(Yi/drawingSize)) * topBlue - (Yi/drawingSize) * bottomBlue
                );
                Color YiColor = new Color(YiRed, YiGreen, YiBlue);

                graphics.setColor(YiColor);
                graphics.drawLine(0, Yi, drawingSize, Yi);
            }
    }
}
