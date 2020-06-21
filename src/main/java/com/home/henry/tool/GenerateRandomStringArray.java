package com.home.henry.tool;

import java.util.Random;

/**
 * 创建长度10000的String数组
 */
public class GenerateRandomStringArray {

    public static String[] generateStringArray() {
        return generateStringArray(10000);
    }

    public static String[] generateStringArray(int num) {
        return generateStringArray(num, 1, 10000);
    }

    public static String[] generateStringArray(int num, int minLength, int maxLength) {
        String[] res = new String[num];
        for (int i = 0; i < num; i++) {
            StringBuilder sb = new StringBuilder();
            int random = getRandomNum(minLength, maxLength);
            for (int j = 0; j < random; j++) {
                int letter = getRandomNum(0, 1);
                if (letter == 0) {
                    sb.append((char) (getRandomNum(0, 25) + 'a'));
                } else {
                    sb.append((char) (getRandomNum(0, 25) + 'A'));
                }
            }
            res[i] = sb.toString();
        }
        return res;
    }

    /**
     * 获得随机Integer, Inclusive
     */
    public static int getRandomNum(int start, int end) {
        Random random = new Random();
        return random.nextInt((end - start) + 1) + start;
    }

}
