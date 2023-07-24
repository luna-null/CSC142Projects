package Proj02.src;

import java.awt.Graphics;
import java.util.InputMismatchException;
import java.util.Scanner;

import Proj02.lib.DrawingPanel;

public class SineUI {
    private static final int GRAPH_WIDTH = 628;
    private static final int GRAPH_HEIGHT = 200;
    public static void main(String[] args) {
        FrontEnd();
    }
    public static int FrontEnd() {

        Scanner scanner1 = new Scanner(System.in);
        int option = MainMenu(scanner1);
            
            switch (option) {
                case 1:
                    System.out.println("Enter value for x in radians:‌ ");
                    double xIn = scanner1.nextDouble();
                    double yOut = 0;
                    try {
                        yOut = SineCalc.SineValue(xIn);
                    }
                    catch (Exception InputMismatchException) {
                        throw new InputMismatchException("Error: Must input a number!");
                    }
                    System.out.println("sin(" + xIn + ") = " + yOut + "\n");
                    break;
                    
                case 2:
                    System.out.println(
                        "Enter number of rectangles for Riemann Sum\n"+
                        "(range 1 to 500): ");
                        int rectIn = scanner1.nextInt();
                        double rArea = 0;
                    try {
                        rArea = SineCalc.riemannArea(0, Math.PI, rectIn);
                    }
                    catch (Exception InputMismatchException) {
                        throw new InputMismatchException("Error: Must input a number!");
                    }
                    System.out.println("Estimated Area: " + rArea +"\n");
                    break;

                case 3:
                    System.out.println(
                        "Enter number of rectangles for Riemann Sum\n"+
                        "(range 1 to 500): ");
                        int gRectIn = scanner1.nextInt();
                    try {
                        DrawingPanel graph = new DrawingPanel(GRAPH_WIDTH, GRAPH_HEIGHT);
                        Graphics graphics = graph.getGraphics();
                        SineDraw.drawGraph(graphics, GRAPH_WIDTH, GRAPH_HEIGHT);
                        SineDraw.DrawRiemannRects(
                            graphics,
                            0,
                            Math.PI,
                            gRectIn,
                            2,
                            GRAPH_WIDTH,
                            GRAPH_HEIGHT
                            
                        );
                        SineDraw.drawSineWave(graphics, GRAPH_WIDTH, GRAPH_HEIGHT);
                    }
                    catch (Exception InputMismatchException) {
                        throw new InputMismatchException("Error: Must input a number!");
                    }
                    break;
            }
                return option;

            }
            
    public static int MainMenu(Scanner scanner1) {
        System.out.println("---------------------------------------------");
        System.out.println("                Sine WaveMenu                ");
        System.out.println("---------------------------------------------"+"\n");
        System.out.println("1.  Find y value for specified radians x");
        System.out.println("2.  Estimate area for O <= x <= PI");
        System.out.println("3.  Draw curve with area estimation rectangles"+"\n");
        System.out.println("0.  EXIT the program"+"\n");
        System.out.println("Enter your choice:  ");
        int input = scanner1.nextInt();
        while (input != 0 && input != 1 && input != 2 && input != 3) {
            System.out.println("Error:‌ Invalid Input");
            System.out.println("---------------------------------------------");
            System.out.println("                Sine WaveMenu                ");
            System.out.println("---------------------------------------------"+"\n");
            System.out.println("1.  Find y value for specified radians x");
            System.out.println("2.  Estimate area for O <= x <= PI");
            System.out.println("3.  Draw curve with area estimation rectangles"+"\n");
            System.out.println("0.  EXIT the program"+"\n");
            System.out.println("Enter your choice:  ");
            input = scanner1.nextInt();
        }
        return input;
    }
}
