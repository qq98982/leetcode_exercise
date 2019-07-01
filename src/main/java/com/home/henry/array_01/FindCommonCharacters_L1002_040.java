package com.home.henry.array_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1002. Find Common Characters
 * 思路: bucket排序的方法, 每次循环后更新字母的数目的min值(第一次的时候是要和MAX比较, 要不出错), 最后如果有值, 输出到list中
 */
public class FindCommonCharacters_L1002_040 {

    static class Solution {
        public List<String> commonChars(String[] A) {
            List<String> res = new ArrayList<>();
            int[] count = new int[26];
            Arrays.fill(count, Integer.MAX_VALUE);
            for (String s : A) {
                int[] cnt = new int[26];
                for (int i = 0; i < s.length(); i++) {
                    cnt[s.charAt(i) - 'a']++;
                }
                for (int i = 0; i < count.length; i++) {
                    count[i] = Math.min(cnt[i], count[i]);
                }
            }
            for (char c = 'a'; c <= 'z'; c++) {
                while (count[c - 'a']-- > 0) {
                    res.add(c + "");
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
