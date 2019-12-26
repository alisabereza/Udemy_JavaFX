package sample;



public class MathOps {
    public static String addition (double x, double y) {
        return x + " + " + y + " = " + (x+y);
    }
    public static String substraction (double x, double y) {
        return x + " - " + y + " = " + (x-y);
    }
    public static String multiplication (double x, double y) {
        return x + " * " + y + " = " + (x*y);
    }
    public static String division (double x, double y) {
        if (y==0) {
            return "Can't divide by 0.";
        }
        else {
            return x + " / " + y + " = " + (x/y);
        }
    }
    public static String reminder (double x, double y) {
        if (y==0) {
             return "Can't divide by 0.";
        }
        else {
            return x + " % " + y + " = " + (x%y);
        }
    }
    public static String  equality (double x, double y) {
        return x + " == " + y + " : " + (x==y);
    }
    public static String  moreThan (double x, double y) {
        return x + " > " + y + " ? " + (x>y);
    }
    public static String  lessThan (double x, double y) {
        return x + " < " + y + " ? " + (x<y);
    }

}

