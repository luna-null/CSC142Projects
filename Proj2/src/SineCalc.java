public class SineCalc {

    // makes a Riemann rectangle with the current x value being the left-most point on the rectangle
    // @param  hStep   step size
    // @param  x       the x-coords of where the rectangle starts
    // @return rectCoords   A string of 4 points representing the points on a triangle:
    //                      (x1,y1), (x1,y2), (x2,y1),(x2,y2)
    public static String LeftRiemannRect( double x0, double hStep,int xOriginPixl,int yOriginPixl) {
        lessThanEqualZeroCond(hStep);
            double x1 = x0;
            double x2 = x0 +‌ hStep;
            double y1 = (yOriginPixl/2);     // y coords of points on rectangle
            double y2 = (yOriginPixl/2)-(yOriginPixl*Math.E)*Math.sin(x0+hStep)/(2*Math.PI);
            String rectCoords = String.format(
                "%d %d, %d %d, %d %d, %d %d",
                (int)(x1),(int)(y1),
                (int)(x1),(int)(y2),
                (int)(x2),(int)(y2),
                (int)(x2),(int)(y1)
                );

        return rectCoords;
    }
    public static String MidRiemannRect(double x, double hStep‌,int xOriginPixl,int yOriginPixl) {
        return LeftRiemannRect(x - hStep‌/2, hStep‌, xOriginPixl, yOriginPixl);
    }
    
    public static String RightRiemannRect(double x, double hStep, int xOriginPixl, int yOriginPixl) {
        return LeftRiemannRect(x - hStep, hStep, xOriginPixl, yOriginPixl);
    }

    /**
     * Creates a string with the coordinates to Riemann rectangles created
     * @param       bound1                      the lower bound
     * @param       bound2                      the upper bound
     * @param       hStep                       the step in between each rectangle
     * @param       rectPlacement               1 for LeftRiemannRect placement
     *                                          2 for MidRiemannRect placement
     *                                          3 for RightRiemannRect placement
     * @throws      IllegalArgumentException    if bound1, bound2 are less than zero or the same,
     *                                          or if hStep is less than or equal to zero
     * @return      rectCoords                  string representing the
     *                                          coordinates to rectangles for every 4 numbers
     * */
    public static String RiemannSumRects(double bound1, double bound2, double hStep, int rectPlacement, int xOriginPixl, int yOriginPixl) {
        equalToEachOther(bound1,bound2);
        lessThanZeroCond(bound1);
        lessThanZeroCond(bound2);
        lessThanEqualZeroCond(hStep);
        String rectCoords = "";      // conditionals

        switch(rectPlacement){
            case 1:
                for (double x = bound1; x <= bound2; x += hStep) {
                    rectCoords += LeftRiemannRect(x, hStep, xOriginPixl, yOriginPixl) + " ";
                }
                return rectCoords;
            case 2:
                for (double x=bound1;x<=bound2;x+=hStep) {
                    rectCoords += MidRiemannRect(x, hStep, xOriginPixl, yOriginPixl) + " ";
                }
                return rectCoords;
            case 3:
            for (double x=bound1;x<=bound2;x+=hStep) {
                rectCoords += RightRiemannRect(x, hStep, xOriginPixl, yOriginPixl) + " ";
            }
            return rectCoords;
            default:
                throw new IllegalArgumentException("invalid rectPlacement: Must be 1 (Left), 2 (Mid), or 3 (Right)");
        }
            
        
    }

    public static void equalToEachOther(double number1, double number2) {
        if (number1 == number2) {
            throw new IllegalArgumentException("Bounds cannot be the same!");
        }
    }

    public static void lessThanZeroCond(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Bounds cannot be the same or less than zero!");
        }
        
    }
    public static void lessThanEqualZeroCond(double number) {
        if (number <= 0) {
            throw new IllegalArgumentException("bounds cannot be the same or less than zero!");
        }
        
    }
    public static int[][]  convertStringToIntArray(String string) {
        String[] pointStringArray = string.split(", ");
        int[][] pointArray = new int[pointStringArray.length][2];

        for (int i = 0; i < pointStringArray.length; i++) {
            String point = pointStringArray[i];
            String[] coordArray = point.split(" ");

            String coordStrX = coordArray[0];
            String coordStrY = coordArray[1];

            int xCoord = Integer.parseInt(coordStrX);
            int yCoord = Integer.parseInt(coordStrY);
            
            pointArray[i][0] = xCoord;
            pointArray[i][1] = yCoord;
        }
        return pointArray;
    }
}

