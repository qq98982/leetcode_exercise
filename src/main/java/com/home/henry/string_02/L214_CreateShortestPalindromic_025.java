package com.home.henry.string_02;

/**
 * 214. Shortest Palindrome
 *
 * 根据一个String, 生成一个最短的Palindrome, 比如abc12321 -> abc12321cba
 * Manacher算法, 时间复杂度为O(n)
 * 思路: 求出包含最后一个字母的最长的Palindrome, 然后加上这个Palindrome前面字母的倒序
 */
public class L214_CreateShortestPalindromic_025 {

    public static String createShortestPalindrome(String s) {
        char[] ch = new char[s.length() * 2 + 1];
        char[] c = s.toCharArray();
        createManacherCharArray(ch, c);

        // find max palindrome length including first letter
        int len = findMaxPalindromeLeftMax(ch);
        String left = s.substring(len);
        StringBuilder sb = new StringBuilder(left).reverse().append(s);
        return sb.toString();
    }

    private static int findMaxPalindromeLeftMax(char[] ch) {
        int[] p = new int[ch.length];
        int R = -1;
        int C = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != ch.length; i++) {
            p[i] = R > i ? Math.min(p[2 * C - i], R - i) : 1;
            while (i + p[i] < ch.length && i - p[i] > -1) {
                if (ch[i + p[i]] == ch[i - p[i]]) {
                    p[i]++;
                } else {
                    break;
                }
            }
            if (i + p[i] > R) {
                R = i + p[i];
                C = i;
            }
        }
        // The basic idea is to use Manacher algorithm.
        // And after you get the dp[] array, add one more loop to search the array from right to
        // left to find the first(longest) char whose palindrome length equal to its
        // postion or position-1(remove the leading #).
        // i - p[i] == 1 or == 0 说明是以开始位置为起点的最长palindrome, 另外, 是从最后位置起计算
        for (int i = ch.length - 1; i >= 0; i--) {
            int diff = p[i] - 1 - i;
            if (diff == 0 || diff == 1) {
                return p[i] - 1;
            }
        }
        return 0;
    }

    private static void createManacherCharArray(char[] res, char[] c) {
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : c[index++];
        }
    }

    public static void main(String[] args) {
        System.out.println("abc12321cba -> " + createShortestPalindrome("12321cba"));
        System.out.println("abcba -> " + createShortestPalindrome("abcba"));
        System.out.println("aaacecaaa -> " + createShortestPalindrome("aacecaaa"));
        System.out.println("dcbabcd -> " + createShortestPalindrome("abcd"));
    }
}
