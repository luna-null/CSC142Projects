import java.awt.Graphics;
import java.awt.Color;

public class GraphicsProject {
    public static final int DP_SIZE_1 = 400;
    public static final int DP_SIZE_2 = 600;
    public static final Color STARTING_COLOR = Color.RED;
    public static final Color ENDING_COLOR = Color.BLUE;
    public static final Color BACKGROUND_COLOR = Color.BLACK;
    // public static DrawingPanel backgroundColor=BACKGROUND_COLOR;

    public static void main(String[] args) {
        int DP_45_DEG_1 = (int) (Math.sin(Math.PI/4)*(DP_SIZE_1/2));
        int step = 4;

        DrawingPanel drawPanel = new DrawingPanel(DP_SIZE_1, DP_SIZE_1);
        Graphics graphics = drawPanel.getGraphics();
        graphics.setColor(BACKGROUND_COLOR);
        graphics.fillRect(0,0,400,400);
        // for making background black

        graphics.setColor(STARTING_COLOR);
        graphics.drawLine(
            (DP_SIZE_1/2), 0,
            (DP_SIZE_1/2), DP_SIZE_1);
        graphics.drawLine(
            (DP_SIZE_1/2)-DP_45_DEG_1, (DP_SIZE_1/2)-DP_45_DEG_1,
            (DP_SIZE_1/2)+DP_45_DEG_1, (DP_SIZE_1/2)+DP_45_DEG_1);
        graphics.drawLine(
            0, (DP_SIZE_1/2),
            DP_SIZE_1, (DP_SIZE_1/2));
        graphics.drawLine(
            (DP_SIZE_1/2)-DP_45_DEG_1, (DP_SIZE_1/2)+DP_45_DEG_1,
            (DP_SIZE_1/2)+DP_45_DEG_1, (DP_SIZE_1/2)-DP_45_DEG_1);
        // graphics.drawLine(DP_SIZE_1, 0, DP_SIZE_1,DP_SIZE_1);
        for (int counter = 1; counter<=DP_SIZE_1/2; counter+=step) {
            graphics.drawLine(
                DP_SIZE_1/2, counter,
                DP_SIZE_1/2+counter, DP_SIZE_1/2-counter);
        }
    }

}
