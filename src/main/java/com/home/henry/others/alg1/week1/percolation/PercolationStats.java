package com.home.henry.others.alg1.week1.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final int trials;

    private final int n;

    private double[] counts;

    private double mean;

    private static final double CONFIDENCE_96 = 1.96;

    private static final double SMALL_DOUBLE = 0.00000001;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.trials = trials;
        this.counts = new double[trials];
    }

    // sample mean of percolation threshold
    public double mean() {
        if (Math.abs(mean - 0) > SMALL_DOUBLE) {
            return mean;
        }
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            int count = 0;
            while (!percolation.percolates()) {
                final int x = StdRandom.uniform(1, n + 1);
                final int y = StdRandom.uniform(1, n + 1);
                if (!percolation.isOpen(x, y)) {
                    percolation.open(x, y);
                    count++;
                }
            }
            double c = (count * 1.0 / (double) (n * n));
            counts[i] = c;
        }
        this.mean = StdStats.mean(counts);
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        if (Math.abs(mean - 0) < SMALL_DOUBLE) {
            mean = mean();
        }
        return StdStats.stddev(this.counts);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        if (Math.abs(mean - 0) < SMALL_DOUBLE) {
            mean = mean();
        }
        return mean - (CONFIDENCE_96 * stddev() / Math.sqrt(counts.length));

    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        if (Math.abs(mean - 0) < SMALL_DOUBLE) {
            mean = mean();
        }
        return mean + (CONFIDENCE_96 * stddev() / Math.sqrt(counts.length));
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);

        PercolationStats stats = new PercolationStats(n, t);
        System.out.println("mean                    = " + stats.mean());
        System.out.println("stddev                  = " + stats.stddev());
        System.out.println(
                "95% confidence interval = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
    }

}
