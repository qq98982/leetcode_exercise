package com.home.henry.binary_search_08;

/**
 * 374. Guess Number Higher or Lower
 */
public class L374_GuessNumberHigherOrLower_016 extends GuessGame {

    public int guessNumber(int n) {
        int res = -1;
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int ret = guess(mid);
            if (ret == -1) {
                right = mid - 1;
            } else if (guess(mid) == 1) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return res;
    }

}
