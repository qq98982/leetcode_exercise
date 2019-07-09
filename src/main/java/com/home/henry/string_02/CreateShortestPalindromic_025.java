package com.home.henry.string_02;

/**
 * 根据一个String, 生成一个最短的Palindrome, 比如abc12321 -> abc12321cba
 * Manachar算法, 时间复杂度为O(n)
 * 思路: 求出包含最后一个字母的最长的Palindrome, 然后加上这个Palindrome前面字母的倒序
 */
public class CreateShortestPalindromic_025 {

    public static String createShortestPalindrome(String str) {
        char[] charArray = new char[str.length() * 2 + 1];
        char[] c = str.toCharArray();
        createManacherCharArray(charArray, c);

        // find max palindrome length including last letter
        int len = findMaxPalindromeRightMax(charArray);
        char[] res = new char[str.length() - len];
        for (int i = 0; i < res.length; i++) {
            res[res.length - 1 - i] = c[i];
        }
        return str + String.valueOf(res);
    }

    private static int findMaxPalindromeRightMax(char[] charArray) {
        int[] pArr = new int[charArray.length * 2 + 1];
        int R = -1;
        int C = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != charArray.length; i++) {
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < charArray.length && i - pArr[i] > -1) {
                if (charArray[i + pArr[i]] == charArray[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            if (R == charArray.length) {
                max = pArr[i];
                break;
            }
        }
        return max - 1;
    }

    private static void createManacherCharArray(char[] res, char[] c) {
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : c[index++];
        }
    }

    public static void main(String[] args) {
        System.out.println("abc12321cba -> " + createShortestPalindrome("abc12321"));
        System.out.println("abcba -> " + createShortestPalindrome("abcba"));
    }
}
