package com.home.henry.others.pramp;

public class DecryptMessage {
    static String decrypt(String word) {
        if (word == null || word.isEmpty()) {
            return "";
        }
        char[] chars = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        char first = (char) (chars[0] - 1);
        sb.append(first);

        int count = chars[0];
        for (int i = 1; i < chars.length; i++) {
            int c = toRange(chars[i] - count);
            count = (char) c + count;
            sb.append((char) c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(decrypt("dnotq"));
    }

    static int toRange(int num) {
        while (num < 97 || num > 122) {
            if (num < 97) {
                num += 26;
            } else {
                num -= 26;
            }
        }
        return num;
    }
}
