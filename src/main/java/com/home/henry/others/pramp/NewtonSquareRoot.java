package com.home.henry.others.pramp;

/**
 * square root of a number using Newtons method
 */
class NewtonSquareRoot {

    static double squareRoot(double n, double l) {
        //        This code works too
        //        double ret = 1;
        //        while (Math.abs(n - ret * ret) > l) {
        //            ret = ret / 2 + n / (2 * ret);
        //        }
        //        return ret;

        // Assuming the sqrt of n as n only
        double x = n;

        // The closed guess will be stored in root
        double root;

        while (true) {
            // Calculate more closed x
            root = 0.5 * (x + (n / x));

            // Check for closeness
            if (Math.abs(root - x) < l) { break; }

            // Update root
            x = root;
        }
        return root;
    }

    public static void main(String[] args) {
        double n = 9;
        double l = 0.00001;
        System.out.println(squareRoot(n, l));
    }
} 