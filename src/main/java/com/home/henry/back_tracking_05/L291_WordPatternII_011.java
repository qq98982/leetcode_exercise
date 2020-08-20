package com.home.henry.back_tracking_05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 291. Word Pattern II
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty
 * substring in str.(i.e if a corresponds to s, then b cannot correspond to s. For example, given pattern = "ab"
 * str = "ss", return false.)
 *
 * pattern = "abab" str = "redblueredblue" Output: true
 * pattern = "aabb" str = "xyzabcxzyabc" Output: false
 * pattern = "aaaa" str = "asdasdasdasd" Output: true
 * 也是用back tracking方法去解
 * The time complexity then is f(n) = n*(n-1)*... *1=n^n.
 */
public class L291_WordPatternII_011 {
    static class Solution {
        public boolean wordPatternII(String pattern, String str) {
            if (pattern.length() == 0 && str.length() == 0) {return true;}
            if (pattern.length() == 0) {return false;}
            Map<Character, String> map = new HashMap<>();
            Set<String> set = new HashSet<>();

            return helper(pattern, str, 0, 0, map, set);
        }

        // 使用一个Map和Set, 储存对应的String
        // i是pattern的index, j是str的index, k从str的index + 1开始, 直到等于str.length()
        // helper中参数变化为i + 1, j + 1, 后面继续递归调用
        private boolean helper(String pattern, String str, int i, int j, Map<Character, String> map,
                               Set<String> set) {
            if (i == pattern.length() && j == str.length()) { return true;}
            if (i >= pattern.length() || j >= str.length()) { return false;}
            char c = pattern.charAt(i);
            for (int k = j + 1; k <= str.length(); k++) {
                String sub = str.substring(j, k);
                if (!map.containsKey(c) && !set.contains(sub)) {
                    map.put(c, sub);
                    set.add(sub);
                    if (helper(pattern, str, i + 1, k, map, set)) {
                        return true;
                    }
                    map.remove(c);
                    set.remove(sub);
                } else if (map.containsKey(c) && map.get(c).equals(sub)) {
                    if (helper(pattern, str, i + 1, k, map, set)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.wordPatternII("abab", "redblueredblue"));
        System.out.println(s.wordPatternII("aabb", "xyzabcxzyabc"));
        System.out.println(s.wordPatternII("aaaa", "asdasdasdasd"));
    }
}
