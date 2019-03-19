package com.home.henry.array_01;

/**
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows.
 * Please note that both secret number and friend's guess may contain duplicate digits.
 * Input: secret = "1807", guess = "7810"  Output: "1A3B"
 * Input: secret = "1123", guess = "0111"  Output: "1A1B"
 */
public class BullsAndCows_L299_006 {

    public String getHint(String secret, String guess) {
        if ((null == secret || secret.length() == 0) || (guess == null || guess.length() == 0)) {
            return "0A0B";
        }
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        int aNum = 0;
        int bNum = 0;
        int[] count = new int[10];
        for (int i = 0; i < 10; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i] == g[i]) {
                aNum++;
            } else {
                count[s[i] - '0']++;
            }
        }
        for (int i = 0; i < g.length; i++) {
            if (g[i] != s[i] && count[g[i] - '0']-- > 0) {
                bNum++;
            }
        }
        return aNum + "A" + bNum + "B";
    }

}
