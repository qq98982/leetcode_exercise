package com.home.henry.others.pramp;

class RootOfNumber {

    static double root(double x, int n) {
        // n is postive
        // 0.001
        double start = 0.0, end = x;
        double mid = end;
        while (mid - start > 0.001) {
            double temp = Math.pow(mid, n);
            if (temp > x) {
                end = mid;
            } else if (temp < x) {
                start = mid;
            } else {
                break;
            }
            mid = (end + start) / 2;
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(root(16, 4));
    }

}