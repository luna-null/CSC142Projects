import java.awt.*;

public class SineUI {
    private static final int GRAPH_WIDTH = 960;
    private static final int GRAPH_HEIGHT = 540;
    public static void main(String[] args) {
        DrawingPanel graph = new DrawingPanel(GRAPH_WIDTH, GRAPH_HEIGHT);
        Graphics graphics = graph.getGraphics();
        graphics.setColor(Color.BLACK);
        SineDraw.drawGraph(graphics, GRAPH_WIDTH, GRAPH_HEIGHT);
        graphics.setColor(Color.RED);
        SineDraw.drawSineWave(graphics, GRAPH_WIDTH, GRAPH_HEIGHT);
    }
}
