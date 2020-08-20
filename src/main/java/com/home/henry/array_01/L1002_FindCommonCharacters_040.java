package com.home.henry.array_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1002. Find Common Characters
 *
 * Given an array A of strings made only from lowercase letters, return a list of all characters that show up
 * in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all
 * strings but not 4 times, you need to include that character three times in the final answer.
 * You may return the answer in any order.
 *
 * Input: ["bella","label","roller"] Output: ["e","l","l"]
 * Input: ["cool","lock","cook"] Output: ["c","o"]
 *
 * Note:
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] is a lowercase letter
 * 思路: bucket排序的方法, 每次循环后更新字母的数目的min值(第一次的时候是要和MAX比较, 要不出错), 最后如果有值, 输出到list中
 */
public class L1002_FindCommonCharacters_040 {

    static class Solution {
        public List<String> commonChars(String[] A) {
            List<String> res = new ArrayList<>();
            if (A == null || A.length == 0) {return res;}
            int[] count = new int[26];
            Arrays.fill(count, Integer.MAX_VALUE);
            for (String s : A) {
                int[] sCount = new int[26];
                for (int i = 0; i < s.length(); i++) {
                    sCount[s.charAt(i) - 'a']++;
                }
                for (int i = 0; i < 26; i++) {
                    count[i] = Math.min(count[i], sCount[i]);
                }
            }
            for (int i = 0; i < 26; i++) {
                while (count[i]-- > 0) {
                    // 不用String.valueOf()加入到list也可以
                    // char c = (char)('a' + i);
                    // res.add(c + "");
                    res.add(String.valueOf(i + 'a'));
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.commonChars(new String[] { "aa", "aa", "aa" }));
    }
}
