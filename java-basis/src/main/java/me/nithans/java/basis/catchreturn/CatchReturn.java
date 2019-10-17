package me.nithans.java.basis.catchreturn;

public class CatchReturn {

    public static void main(String[] args) {
        System.out.println(testReturn());
    }

    private static double testReturn() {
        double result;
        try {
            int numerator = 1;
            int denominator = 1;
            result = numerator / 0;

            return result;
        } catch (ArithmeticException e) {
            System.exit(-1);
            return 2.0;
        } finally {

            return 0.0;
        }
    }

}
