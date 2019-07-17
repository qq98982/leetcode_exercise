package com.home.henry.others.alg1.week1.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] matrix;
    private final WeightedQuickUnionUF uf;
    private int wCount;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        // init n * n matrix
        matrix = new boolean[n][n];

        // init quick union object
        uf = new WeightedQuickUnionUF(n * n + 2);

        // init matrix data from 1 to n * n (inclusive)
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = false;
            }
        }

        // matrix connected value
        wCount = 0;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 1 || col < 1) {
            throw new IllegalArgumentException();
        }
        if (row > matrix.length || col > matrix[0].length) {
            throw new IllegalArgumentException();
        }
        // if it is opened, ignore
        if (isOpen(row, col)) {
            return;
        }
        // change matrix value
        matrix[row - 1][col - 1] = true;

        // update opened number
        wCount++;

        // index in uf
        int index = getUFIndex(matrix[0].length, row, col);

        // if it is on first row, connect to visual point 1
        if (row == 1) {
            uf.union(index, matrix.length * matrix[0].length);
        }
        // if it is on last row, connect to visual point 2
        if (row == matrix.length) {
            uf.union(index, matrix.length * matrix[0].length + 1);
        }
        // connect to up direction
        if (row > 1) {
            if (isOpen(row - 1, col)) {
                uf.union(index, index - matrix[0].length);
            }
        }
        // connect to left direction
        if (col > 1) {
            if (isOpen(row, col - 1)) {
                uf.union(index, index - 1);
            }
        }
        // connect to right direction
        if (col < matrix[0].length) {
            if (isOpen(row, col + 1)) {
                uf.union(index, index + 1);
            }
        }
        // connect to down direction
        if (row < matrix.length) {
            if (isOpen(row + 1, col)) {
                uf.union(index, index + matrix[0].length);
            }
        }
    }

    private int getUFIndex(int n, int row, int col) {
        return (row - 1) * n + col - 1;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 1 || col < 1) {
            throw new IllegalArgumentException();
        }
        if (row > matrix.length || col > matrix[0].length) {
            throw new IllegalArgumentException();
        }
        return matrix[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 1 || col < 1) {
            throw new IllegalArgumentException();
        }
        if (row > matrix.length || col > matrix[0].length) {
            throw new IllegalArgumentException();
        }
        // if is not opened, return
        if (!isOpen(row, col)) {return false;}
        // connected to the top row is full
        return uf.connected(getUFIndex(matrix.length, row, col), (matrix.length) * (matrix[0].length));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return wCount;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.connected(matrix.length * matrix[0].length, matrix.length * matrix[0].length + 1);
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation p = new Percolation(20);
        p.open(1, 1);
        System.out.println(p.isFull(2, 1));
        System.out.println(p.isFull(1, 1));
    }
}