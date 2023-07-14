import java.awt.*;

public class SineDraw {

    public static void drawSineWave(Graphics graphic, int gWidth, int gHeight) {
       double h = Math.PI/65536;
        for (double theta = 0; theta <= 2*Math.PI; theta += h) {
            graphic.drawLine(
                (int) ((gWidth/32)+(gWidth-(gWidth/16))*theta/(2*Math.PI)-1),
                (int) ((gHeight/2)-(gHeight*Math.E)*Math.sin(theta)/(2*Math.PI)-1),
                (int) ((gWidth/32)+(gWidth-(gWidth/16))*(theta + h)/(2*Math.PI)),
                (int) ((gHeight/2)-(gHeight*Math.E)*Math.sin(theta + h)/(2*Math.PI))
            );
        }
    }
    public static void drawGraph(Graphics graphic, int gWidth, int gHeight) {
        graphic.drawLine(               // x-axis
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
        for (int x=0; x<=4; x++) {      // labels
            graphic.drawLine(
                (int) ((gWidth/32)+(gWidth-(gWidth/16))*x/4),
                (int) ((gHeight/2)+(gHeight/64)),
                (int) ((gWidth/32)+(gWidth-(gWidth/16))*x/4),
                (int) ((gHeight/2)-(gHeight/64))
            );
            switch(x) {
                case 0:
                    graphic.drawString(String.format("(0,0)",2*x),
                    (int) ((gWidth/32)+(gWidth-(gWidth/16))*x/4 - (15*gWidth/512)),
                    (int) ((gHeight/2)) //+(gHeight/32))
                );break;
                case 1:
                    graphic.drawString(String.format("\u03C0/2"),
                    (int) ((gWidth/32)+(gWidth-(gWidth/16))*x/4 - (15*gWidth/512)),
                    (int) ((gHeight/2)+(gHeight/32))
                );break;
                case 2:
                    graphic.drawString(String.format("\u03C0"),
                    (int) ((gWidth/32)+(gWidth-(gWidth/16))*x/4 - (15*gWidth/512)),
                    (int) ((gHeight/2)+(gHeight/32))
                );break;
                case 3:
                    graphic.drawString(String.format("%x\u03C0/2",x),
                    (int) ((gWidth/32)+(gWidth-(gWidth/16))*x/4 - (15*gWidth/512)),
                    (int) ((gHeight/2)+(gHeight/32))
                );break;
                case 4:
                    graphic.drawString(String.format("2\u03C0"),
                    (int) ((gWidth/32)+(gWidth-(gWidth/16))*x/4 - (15*gWidth/512)),
                    (int) ((gHeight/2)+(gHeight/32))
                );break;
            }
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
        for (int y=0; y<=8; y++) {      // labels
            if (y != 4) {
                graphic.drawLine(
                        (int) ((gWidth/32)-(gWidth/64)),
                        (int) ((gHeight/2)*(1+((Math.E)/(Math.PI)))-(y*gHeight*Math.E)/(8*Math.PI)),
                        (int) ((gWidth/32)+(gWidth/64)),
                        (int) ((gHeight/2)*(1+((Math.E)/(Math.PI)))-(y*gHeight*Math.E)/(8*Math.PI))
                    );
            }
            switch(y) {
                    case 0:
                        graphic.drawString(String.format("%.2f",((float)(y)/4-1)),
                        (int) ((gWidth/32) - (15*gWidth/512)),
                        (int) ((gHeight/2)*(1+((Math.E)/(Math.PI)))-(y*gHeight*Math.E)/(4*Math.PI))-(gWidth/256)
                        );break;
                    case 1:
                        graphic.drawString(String.format("%.2f",((float)(y)/4-1)),
                        (int) ((gWidth/32) - (15*gWidth/512)),
                        (int) ((gHeight/2)*(1+((Math.E)/(Math.PI)))-(y*gHeight*Math.E)/(8*Math.PI))-(gWidth/256)
                        );break;
                    case 2:
                        graphic.drawString(String.format("%.2f",((float)(y)/4-1)),
                        (int) ((gWidth/32) - (15*gWidth/512)),
                        (int) ((gHeight/2)*(1+((Math.E)/(Math.PI)))-(y*gHeight*Math.E)/(8*Math.PI))-(gWidth/256)
                        );break;
                    case 3:
                        graphic.drawString(String.format("%.2f",((float)(y)/4-1)),
                        (int) ((gWidth/32) - (15*gWidth/512)),
                        (int) ((gHeight/2)*(1+((Math.E)/(Math.PI)))-(y*gHeight*Math.E)/(8*Math.PI))-(gWidth/256)
                        );break;
                    case 5:
                        graphic.drawString(String.format("%.2f",((float)(y)/4-1)),
                        (int) ((gWidth/32) - (7*gWidth/256)),
                        (int) ((gHeight/2)*(1+((Math.E)/(Math.PI)))-(y*gHeight*Math.E)/(8*Math.PI))-(gWidth/256)
                        );break;
                    case 6:
                        graphic.drawString(String.format("%.2f",((float)(y)/4-1)),
                        (int) ((gWidth/32) - (7*gWidth/256)),
                        (int) ((gHeight/2)*(1+((Math.E)/(Math.PI)))-(y*gHeight*Math.E)/(8*Math.PI))-(gWidth/256)
                        );break;
                    case 7:
                        graphic.drawString(String.format("%.2f",((float)(y)/4-1)),
                        (int) ((gWidth/32) - (7*gWidth/256)),
                        (int) ((gHeight/2)*(1+((Math.E)/(Math.PI)))-(y*gHeight*Math.E)/(8*Math.PI))-(gWidth/256)
                        );break;
                    case 8:
                        graphic.drawString(String.format("%.2f",((float)(y)/4-1)),
                        (int) ((gWidth/32) - (7*gWidth/256)),
                        (int) ((gHeight/2)*(1+((Math.E)/(Math.PI)))-(y*gHeight*Math.E)/(8*Math.PI))-(gWidth/256)
                        );break;
            }
        }
        graphic.drawString("y", (5*gWidth/128), gHeight/8);
    }
}
