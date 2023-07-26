/**
* Project 3: Sunflower
*
* Creates a sunflower in the drawing panel with a specified amount of petals.
*
* @author Autumn Roman
*/

package Proj03.src;

import java.awt.Color;

public class Main {

    public static final Color COLOR_BACKGROUND_TOP = new Color(218, 227, 243);
    public static final Color COLOR_BACKGROUND_BOTTOM = new Color(143, 170, 220);

/**
 * Initializes the program.
 */
    public static void main(String[] args) {

        int drawingSize = 400;      // Drawing Size

        Sunflower sunflower = new Sunflower(drawingSize, (int)(drawingSize/4), 9);

        sunflower.draw();
    }


    }
