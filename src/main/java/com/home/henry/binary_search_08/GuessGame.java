package com.home.henry.binary_search_08;

public class GuessGame {

    private int num;

    GuessGame(int num) {
        this.num = num;
    }

    GuessGame() {
    }

    int guess(int pick) {
        if (this.num == pick) {
            return 0;
        } else if (pick < num) {
            return -1;
        } else {
            return 1;
        }
    }
}
