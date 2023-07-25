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
    }


    }
