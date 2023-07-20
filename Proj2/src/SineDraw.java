import java.awt.Color;
import java.awt.Graphics;

public class SineDraw {

    public static void drawSineWave(Graphics graphic, int gWidth, int gHeight) {
        double h = Math.PI/65536;
        Color defColor = Color.RED;
        graphic.setColor(defColor);
        for (double theta = 0; theta < 2*Math.PI; theta += h) {
            int point1X = SineCalc.sineXCoords(theta)-1; int point1Y = SineCalc.sineYCoords(theta)-1;
            int point2X = SineCalc.sineXCoords(theta+h); int point2Y = SineCalc.sineYCoords(theta+h);
            graphic.drawLine(
            point1X,                                    // (int) ((gWidth/32)+(gWidth-(gWidth/16))*theta/(2*Math.PI)),    
            point1Y,                                    // (int) ((gHeight/2)-(gHeight)*Math.sin(theta)/2-1),             
            point2X,                                    // (int) ((gWidth/32)+(gWidth-(gWidth/16))*(theta+h)/(2*Math.PI)),
            point2Y                                     // (int) ((gHeight/2)-(gHeight)*Math.sin(theta + h)/2)            
            );
        }
    }
    public static void drawGraph(Graphics graphic, int gWidth, int gHeight) {
        graphic.setColor(Color.BLACK);      // paint it black
        graphic.drawLine(                   // x-axis
            (int) (gWidth/32),
            (int) (gHeight/2),
            (int) (gWidth),
            (int) (gHeight/2)
        );

        graphic.drawLine(               // arrows
            (int) (gWidth),
            (int) ((gHeight/2)),
            (int) (gWidth-gWidth/64),
            (int) ((gHeight/2)-(gHeight/64))
        );
        graphic.drawLine(
            (int) (gWidth),
            (int) ((gHeight/2)),
            (int) (gWidth-gWidth/64),
            (int) ((gHeight/2)+(gHeight/64))
        );
        for (int x=0; x<=4; x++) {      // X‌ labels and lines
            graphic.setColor(Color.LIGHT_GRAY);     // gray-out extensions for lines
            graphic.drawLine(
                (int) ((gWidth/32)+(gWidth-(gWidth/16))*x/4),
                (int) (0),
                (int) ((gWidth/32)+(gWidth-(gWidth/16))*x/4),
                (int) (gHeight)
            );
            graphic.setColor(Color.BLACK);
            graphic.drawLine(                       // coordinate lines
                (int) ((gWidth/32)+(gWidth-(gWidth/16))*x/4),
                (int) ((gHeight/2)+(gHeight/64)),
                (int) ((gWidth/32)+(gWidth-(gWidth/16))*x/4),
                (int) ((gHeight/2)-(gHeight/64))
            );
            graphic.setColor(Color.getColor("ffffff"));

        }
        graphic.drawString("x", (gWidth-gWidth/8), gHeight/2-gHeight/64);

        graphic.drawLine(               // y-axis
            (int) (gWidth/32),
            (int) (0),
            (int) (gWidth/32),
            (int) ((gHeight))
        );
        graphic.drawLine(               // arrows
            (int) (gWidth/32),
            (int) ((gHeight)),
            (int) (gWidth/64),
            (int) ((gHeight)-(gHeight/32))
        );
        graphic.drawLine(
            (int) (gWidth/32),
            (int) ((gHeight)),
            (int) (gWidth/32+gWidth/64),
            (int) ((gHeight)-(gHeight/32))
        );

        graphic.drawLine(
            (int) (gWidth/32),
            (int) (0),
            (int) (gWidth/64),
            (int) (gHeight/32)
        );
        graphic.drawLine(
            (int) (gWidth/32),
            (int) (0),
            (int) (gWidth/32+gWidth/64),
            (int) (gHeight/32)
        );
        for (int y=0; y<=8; y++) {      // Y‌ labels and lines
            if (y != 4) {
                
                graphic.setColor(Color.LIGHT_GRAY);     // gray-out extensions for lines
                graphic.drawLine(
                    (int) ((gWidth/32)-(gWidth/64)),
                    (int) (200-200*y/8),
                    (int) (gWidth),
                    (int) (200-200*y/8)
                );
                graphic.setColor(Color.BLACK);
                graphic.drawLine(                       // coordinate lines
                        (int) ((gWidth/32)-(gWidth/64)),
                        (int) (200-200*y/8),
                        (int) ((gWidth/32)+(gWidth/64)),
                        (int) ((200-200*y/8))
                    );
            }
        }
        graphic.drawString("y", (5*gWidth/128), gHeight/8);
    }
    /**
     * Draws rectangles from Riemann Sum Rectangles displayed as coordinates in a string
     *
     * @param       RectPointArray      Rectangle Point Array as a string.
     * @param       point               One point of (x,y).
     * @param       coordStr            Array of strings with each entry being
     *                                      one coordinate on the graph.
     * @param       coord               One value for a coordinate.
     */
    
    public static void DrawRiemannRects(Graphics graphic, 
                                        double bound1, 
                                        double bound2, 
                                        double rectNum, 
                                        int rectPlacement, 
                                        int gWidth, int gHeight) {
        double hStep = Math.PI/rectNum;
        graphic.setColor(Color.BLACK);
        if (rectPlacement == 1) {
            for (double i = bound1-hStep; i <= bound2;i+=hStep) {
                graphic.drawRect(
                    SineCalc.sineXCoords(i-hStep),
                    SineCalc.sineYCoords(i),
                    -gWidth/32 + SineCalc.sineXCoords(hStep),
                    gHeight/2 - SineCalc.sineYCoords(i)
                );
            }
        }
        else if (rectPlacement == 2) {
            for (double i = bound1-hStep/2; i <= bound2;i+=hStep) {
                graphic.drawRect(
                    SineCalc.sineXCoords(i-hStep/2),
                    SineCalc.sineYCoords(i),
                    -gWidth/32 + SineCalc.sineXCoords(hStep),
                    gHeight/2 - SineCalc.sineYCoords(i)
                );
            }
        }
        else if (rectPlacement == 3) {
            for (double i = bound1; i <= bound2;i+=hStep) {
                graphic.drawRect(
                    SineCalc.sineXCoords(i),
                    SineCalc.sineYCoords(i),
                    -gWidth/32 + SineCalc.sineXCoords(hStep),
                    gHeight/2 - SineCalc.sineYCoords(i)
                );
            }
        }
        else{
            throw new IllegalArgumentException(
                "\n0 < rectPlacement < 3, rectPlacement ∈ Z\n"+
                "i.e. rectPlacement must be between 1 and 3!"
            );
        }
    }
    
    public static int XCoordTrans(int xCoord, int gWidth) {
        int graphCoord = gWidth - xCoord;
        return graphCoord;
    } 
    public static int YCoordTrans(int yCoord, int gHeight) {
        int graphCoord = gHeight - yCoord;
        return graphCoord;
    } 
}
