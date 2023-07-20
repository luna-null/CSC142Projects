import java.awt.Color;
import java.awt.Graphics;

public class SineUI {
    private static final int GRAPH_WIDTH = 960;
    private static final int GRAPH_HEIGHT = 540;
    public static void main(String[] args) {
        DrawingPanel graph = new DrawingPanel(GRAPH_WIDTH, GRAPH_HEIGHT);
        Graphics graphics = graph.getGraphics();
        graphics.setColor(Color.BLACK);
        SineDraw.drawGraph(graphics, GRAPH_WIDTH, GRAPH_HEIGHT);    // paint it black

        Color color1 = Color.RED;
        graphics.setColor(color1);

        SineDraw.drawSineWave(graphics, GRAPH_WIDTH, GRAPH_HEIGHT, color1);
        
        int[][] RiemannSum = 
            SineCalc.convertStringToIntArray(
                SineCalc.RiemannSumRects(
                    (GRAPH_WIDTH/32), ((GRAPH_WIDTH/32)+(GRAPH_WIDTH-(GRAPH_WIDTH/16))/(2*Math.PI)), GRAPH_WIDTH/32,
                    2, GRAPH_WIDTH, GRAPH_HEIGHT));

        SineDraw.DrawRiemannRects(graphics, RiemannSum);
    }
}
