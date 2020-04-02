package com.home.henry.array_01;

/**
 * 299. Bulls and Cows
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows.
 * Please note that both secret number and friend's guess may contain duplicate digits.
 * Input: secret = "1807", guess = "7810"  Output: "1A3B"
 * Input: secret = "1123", guess = "0111"  Output: "1A1B"
 */
public class BullsAndCows_L299_006 {

    public String getHint(String secret, String guess) {
        if (secret.isEmpty() || guess.isEmpty()) {
            return "0A0B";
        }
        char[] s = secret.toCharArray();
        char[] t = guess.toCharArray();
        int aNum = 0;
        int[] count = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (s[i] == t[i]) {
                aNum++;
            }
            count[s[i] - '0']++;
            count[t[i] - '0']--;
        }
        int diff = 0;
        for (int c : count) {
            if (c != 0) {
                diff += Math.abs(c);
            }
        }
        // 注意这里的diff要除2
        int bNum = 4 - diff / 2 - aNum;
        return aNum + "A" + bNum + "B";
    }

}
