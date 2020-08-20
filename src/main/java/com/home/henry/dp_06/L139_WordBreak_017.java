package com.home.henry.dp_06;

import java.util.List;

/**
 * 139. Word Break
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * Note: The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 */
public class L139_WordBreak_017 {

    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (wordDict.size() == 0 || s == null || s.length() == 0) {
                return false;
            }
            int max = getMaxLength(wordDict);
            int n = s.length();
            boolean[] f = new boolean[n + 1];
            f[0] = true;

            for (int i = 1; i <= n; i++) {
                for (int j = i - 1; j >= 0 && i - j <= max; j--) {
                    if (f[j] && wordDict.contains(s.substring(j, i))) {
                        f[i] = true;
                        break;
                    }
                }
            }
            return f[n];
        }

        int getMaxLength(List<String> wordDict) {
            int max = 0;
            for (String s : wordDict) {
                max = Math.max(max, s.length());
            }
            return max;
        }
    }
}
