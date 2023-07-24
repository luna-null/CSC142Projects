/**
 * Name: Autumn Roman
 * Date: 07/07/2023
 * Project 1: Draw Curves From Straight Lines
 * Description: Makes a graphic of an 8-pointed star with straight lines, and creates a painting I made.
*/

package Proj01.src;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import Proj01.lib.DrawingPanel;

public class GraphicsProject {
    public static final int DP_SIZE_1 = 400;
    public static final int DP_SIZE_2 = 600;
    // public static DrawingPanel backgroundColor=BACKGROUND_COLOR;

    public static void main(String[] args) {
        part1();
        part2();
    }

    // makes for loops for drawing lines and changing the color of each line
    public static void part1() {
        int DP45Deg = (int) (Math.sin(Math.PI/4)*(DP_SIZE_1/2));
        int step = 5;

        DrawingPanel drawPanel = new DrawingPanel(DP_SIZE_1, DP_SIZE_1);
        Graphics graphics = drawPanel.getGraphics();
        blackSquareBackground(graphics, DP_SIZE_1);
        // for making background black

        for (int counter = 0; counter < DP45Deg; counter+=step) {
            int colorVar = (counter*DP_SIZE_1/(2*DP45Deg));
            graphics.setColor(new Color(counter*DP45Deg/DP_SIZE_1,150-colorVar/2,colorVar*220/200));
            graphics.drawLine(
                DP_SIZE_1/2, counter*DP_SIZE_1/(2*DP45Deg),
                DP_SIZE_1/2+counter, DP_SIZE_1/2-counter);
        }
        for (int counter = 0; counter < DP45Deg; counter+=step) {
            int colorVar = (counter*DP_SIZE_1/(2*DP45Deg));
            graphics.setColor(new Color(counter*DP45Deg/DP_SIZE_1,150-colorVar/2,colorVar*220/200));
            graphics.drawLine(
                DP_SIZE_1 - counter * DP_SIZE_1/(2*DP45Deg), DP_SIZE_1/2,
                DP_SIZE_1/2 + counter, DP_SIZE_1/2 - counter);
        }
        for (int counter = 0; counter <= DP45Deg; counter+=step) {
            int colorVar = (counter*DP_SIZE_1/(2*DP45Deg));
            graphics.setColor(new Color(counter*DP45Deg/DP_SIZE_1,150-colorVar/2,colorVar*220/200));
            graphics.drawLine(
                DP_SIZE_1 - counter * DP_SIZE_1/(2*DP45Deg), DP_SIZE_1/2,
                DP_SIZE_1/2 + counter, DP_SIZE_1/2 + counter);
        }
        for (int counter = 0; counter <= DP45Deg; counter+=step) {
            int colorVar = (counter*DP_SIZE_1/(2*DP45Deg));
            graphics.setColor(new Color(counter*DP45Deg/DP_SIZE_1,150-colorVar/2,colorVar*220/200));
            graphics.drawLine(
                DP_SIZE_1/2, DP_SIZE_1 - counter * DP_SIZE_1/(2*DP45Deg),
                DP_SIZE_1/2 + counter, DP_SIZE_1/2 + counter);
        }
        for (int counter = 0; counter <= DP45Deg; counter+=step) {
            int colorVar = (counter*DP_SIZE_1/(2*DP45Deg));
            graphics.setColor(new Color(counter*DP45Deg/DP_SIZE_1,150-colorVar/2,colorVar*220/200));
            graphics.drawLine(
                DP_SIZE_1/2, DP_SIZE_1 - counter * DP_SIZE_1/(2*DP45Deg),
                DP_SIZE_1/2 - counter, DP_SIZE_1/2 + counter);
        }
        for (int counter = 0; counter <= DP45Deg; counter+=step) {
            int colorVar = (counter*DP_SIZE_1/(2*DP45Deg));
            graphics.setColor(new Color(counter*DP45Deg/DP_SIZE_1,150-colorVar/2,colorVar*220/200));
            graphics.drawLine(
                counter * DP_SIZE_1/(2*DP45Deg), DP_SIZE_1/2,
                DP_SIZE_1/2 - counter, DP_SIZE_1/2 + counter);
        }
        for (int counter = 0; counter <= DP45Deg; counter+=step) {
            int colorVar = (counter*DP_SIZE_1/(2*DP45Deg));
            graphics.setColor(new Color(counter*DP45Deg/DP_SIZE_1,150-colorVar/2,colorVar*220/200));
            graphics.drawLine(
                counter * DP_SIZE_1/(2*DP45Deg), DP_SIZE_1/2,
                DP_SIZE_1/2 - counter, DP_SIZE_1/2 - counter);
        }
        for (int counter = 0; counter <= DP45Deg; counter+=step) {
            int colorVar = (counter*DP_SIZE_1/(2*DP45Deg));
            graphics.setColor(new Color(counter*DP45Deg/DP_SIZE_1,150-colorVar/2,colorVar*220/200));
            graphics.drawLine(
                DP_SIZE_1/2, counter * DP_SIZE_1/(2*DP45Deg),
                DP_SIZE_1/2 - counter, DP_SIZE_1/2 - counter);
        }
    }

    public static void part2() {
        DrawingPanel drawPanel2 = new DrawingPanel(DP_SIZE_2, DP_SIZE_2);
        Graphics graphics2 = drawPanel2.getGraphics();
        blackSquareBackground(graphics2, DP_SIZE_2);

        Color neb1Color = new Color(0,200,75,240);
        Color neb2Color = new Color(50,200,200,150);
        Color neb3Color = new Color(100,0,200,40);
        Color neb4Color = new Color(150,0,200,100);

        Color spaceShipColor1 = new Color(255,100,0);
        Color spaceShipColor2 = new Color(255,100,255);

        Color sunColor = new Color(123, 170, 255);

        drawShootingStars(graphics2, new Color(255,255,255,100));

        drawStars(graphics2, Color.WHITE);

        drawSun(graphics2, 50, 50, 50, sunColor);

        drawNebula(graphics2, 200, 200, 300, neb1Color, neb2Color, neb3Color,neb4Color);

        drawSpaceShip(graphics2, 150, 450, 300, spaceShipColor1, spaceShipColor2);


    }

    public static void drawNebula(Graphics graphic, int x, int y, int size, Color color1, Color color2, Color color3, Color color4) {
        graphic.setColor(color2);
        graphic.fillOval(x/4-10, y-5, size*2+10, size+10);
        graphic.setColor(color4);
        graphic.fillOval(x*2/3, y*6/5, size*3/2, size*4/5);
        graphic.setColor(color1);
        graphic.fillOval(x, y, size, size);
        graphic.setColor(new Color(255,255,0,150));
        graphic.fillOval(x+100, y+90, size/3+3, size/3);
        graphic.setColor(color3);
        Random rng = new java.util.Random();
        for (int lineCnt=0;lineCnt<=50;lineCnt++) {
            graphic.drawLine(
                (int) (3*DP_SIZE_2*rng.nextGaussian()/(Math.sqrt(x))+x*5/3),
                (int) (3*DP_SIZE_2*rng.nextGaussian()/(Math.sqrt(y))+y*5/3),
                (int) (3*DP_SIZE_2*rng.nextGaussian()/(Math.sqrt(x))+x*5/3),
                (int) (3*DP_SIZE_2*rng.nextGaussian()/(Math.sqrt(y))+y*5/3)
                );
        }
    }

    public static void drawStars(Graphics graphic,Color color1) {
        graphic.setColor(color1);
        Random rng = new java.util.Random();
        for (int starCnt=0;starCnt<=1000;starCnt++) {
            graphic.fillOval(((int) (DP_SIZE_2*rng.nextDouble())), (int) (DP_SIZE_2*rng.nextDouble()), 1, 1);
        }
    }

    public static void drawShootingStars(Graphics graphic,Color color1) {
        graphic.setColor(color1);
        Random rng = new java.util.Random();
        for (int starCnt=0;starCnt<2;starCnt++) {
            graphic.drawLine(
                rng.nextInt(600),
                rng.nextInt(200),
                rng.nextInt(600),
                rng.nextInt(200)
            );
        }
    }

    public static void drawSpaceShip(Graphics graphic, int x, int y, int size, Color color1, Color color2) {
        graphic.setColor(color1);

        int[] x_coordsTri = {
            x+(int)((100+Math.sqrt(6000))/2),
            x,
            x+(int)((100+Math.sqrt(6000))/2)+20
        };
        int[] y_coordsTri = {
            y+(int)((100+Math.sqrt(6000))/2),
            y,
            y+(int)((100-Math.sqrt(6000))/2)-30
        };

        int[] x_coordsRect = {
            x+(int)((100+Math.sqrt(6000))/2)+1,
            x+1,
            x-200,
            x-40
        };

        int[] y_coordsRect = {
            y+(int)((100+Math.sqrt(6000))/2)-1,
            y-1,
            y+200,
            y+(int)((100+Math.sqrt(6000))/2)+135
        };

        graphic.fillPolygon(x_coordsTri,y_coordsTri,3);

        graphic.fillPolygon(x_coordsRect, y_coordsRect, 4);
        graphic.setColor(new Color(74, 4, 4));
        graphic.drawLine(
            x,
            y,
            x+(int)((100+Math.sqrt(6000))/2)-65,
            y+(int)((100+Math.sqrt(6000))/2)-65
        );
        graphic.drawLine(
            x+(int)((100+Math.sqrt(6000))/2)-25,
            y+(int)((100+Math.sqrt(6000))/2)-25,
            x+(int)((100+Math.sqrt(6000))/2),
            y+(int)((100+Math.sqrt(6000))/2)
        );

        graphic.setColor(new Color(0,0,255,225));
        graphic.fillOval(x+14,y+14,60,60);

}

    public static void drawSun(Graphics graphic, int x, int y, int size, Color color1) {
        graphic.setColor(color1);
        graphic.fillOval(x, y, size, size);
        for (int angle=0;angle<10;angle++) {
            graphic.drawLine(
                (int) (x+size/2 + x*Math.cos(angle*Math.PI/5)),
                (int) (y+size/2 + y*Math.sin(angle*Math.PI/5)),
                (int) (x+size/2 + 50*x*Math.cos(angle*Math.PI/5)),
                (int) (y+size/2 + 50*y*Math.sin(angle*Math.PI/5))
            );
        }
    }

    public static void blackSquareBackground(Graphics graphic, int size) {
        graphic.setColor(Color.BLACK);
        graphic.fillRect(0,0,size,size);
    }
}
