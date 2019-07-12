package com.home.henry.others;

/**
 *
 * Q: Return the length of the longest substring that contains at most x unique characters.
 * Example: aaababcxyz with x = 3 should return 7 (aaababc)
 * https://leetcode.com/discuss/interview-question/332807/Uber-or-Phone-screen-or-Longest-substring-with-x-unique-characters
 */
public class LongestSubstringWithXUniqueCharactersUber {

    /**
     * 思路:
     * 使用一个sliding window实现
     * char[] 从头loop到尾, 变量cnt存储substring的长度, mulCnt存储是否超过x
     * 一进循环, 如果是新的, mulCnt+1, 同时count++, cnt++
     * 如果mulCnt大于x了, 第一个字母删掉, 直到mulCnt<=x, 在这个过程中cnt--, count也要--
     */
    public static class Solution {
        public int longestSubstring(String s, int x) {
            int res = 0;
            if (s == null || s.length() == 0) {return res;}
            char[] c = s.toCharArray();
            int[] count = new int[26];
            int cnt = 0, mulCnt = 0;
            for (int i = 0; i < c.length; i++) {
                if (count[c[i] - 'a'] == 0) {
                    mulCnt++;
                }
                count[c[i] - 'a']++;
                cnt++;
                // 这里用while理论上是可以的, 但还要更改i的值和cnt的值, 否则第三个答案不对了, 所以用if更好点
                if (mulCnt > x) {
                    // remove first character in pre string and cnt--
                    // till mulCnt == x
                    cnt--;
                    count[c[i - cnt] - 'a']--;
                    if (count[c[i - cnt] - 'a'] == 0) {
                        mulCnt--;
                    }
                }

                // mulCnt有可能循环完成一直小于x
                if (mulCnt <= x) {
                    res = Math.max(cnt, res);
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestSubstring("ababbcbxyz", 3)); // 7
        System.out.println(s.longestSubstring("abcabc", 5)); // 6
        System.out.println(s.longestSubstring("abababab", 1)); // 1
        System.out.println(s.longestSubstring("aabbabab", 1)); // 2
        System.out.println(s.longestSubstring(null, 1)); // 0
    }
}
