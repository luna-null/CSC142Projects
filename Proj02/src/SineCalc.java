package Proj02.src;

public class SineCalc {
    
    public static int sineXCoords(double x) {
        int xCoord = (int) ((628/32)+(628-(628/16))*x/(2*Math.PI));     // (int) ((gWidth/32)+(gWidth-(gWidth/16))*theta/(2*Math.PI)),    
        int point = xCoord;                                             // (int) ((gWidth/32)+(gWidth-(gWidth/16))*(theta+h)/(2*Math.PI)),
        return point;
    }
    public static int sineYCoords(double y) {                           // (int) ((gHeight/2)-(gHeight)*Math.sin(theta)/2-1),
        int yCoord = (int) ((200/2)-(200)*Math.sin(y)/2);               // (int) ((gHeight/2)-(gHeight)*Math.sin(theta + h)/2)
        int point = yCoord;
        return point;
    }
    public static double calcArea(double width, double height) {
        double area = width * height;
        return area;
    }
    public static double riemannArea(
        double bound1, double bound2,
            int rectNum) {
            if (rectNum > 0 && rectNum <= 500 && bound1 >= 0 && bound2 >= 0 && bound1 != bound2) {
                double hStep = Math.PI/(rectNum);
                double areaSum = 0;
                for (int i=0;i<rectNum;i++) {
                    areaSum += calcArea(hStep, SineValue((hStep)*(1+2*i)/2));
                }
                return areaSum;
            }
            else if (rectNum <= 0 || rectNum > 500) {
                throw new IllegalArgumentException("There must be between 1 and 500 rectangeles!");
            }
            else if (bound1 < 0 || bound2 < 0 || bound1 >= bound2) {
                throw new IllegalArgumentException("Bounds cannot be less than zero or equal to each other!");
            }
            else {
                throw new IllegalArgumentException("Error:‌ Invalid arguments!");
            }
        }

    public static double SineValue(double xIn) {
        
        double sinValue = Math.sin(xIn);
        int yInt = (int) sinValue;
        double y4dec = sinValue*10000;
        int y4decInt = (int)y4dec;
        double yOut = ((double)(yInt) + (double)(y4decInt)/10000);
        
        return yOut;
    }
}

