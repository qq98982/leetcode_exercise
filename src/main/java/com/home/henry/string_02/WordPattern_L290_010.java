package com.home.henry.string_02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * Input: pattern = "abba", str = "dog cat cat dog" Output: true
 * Input: pattern = "abba", str = "dog cat cat fish" Output: false
 * 思路是放入map返回的值和当前值是否相同, 注意的是要判定pattern的个数和word的个数是否相同, 第一次放入返回空
 * 也可以使用第二个方法的containsValue判断相同值
 */
public class WordPattern_L290_010 {

    public boolean wordPattern(String pattern, String str) {
        if (null == pattern || null == str || pattern.length() == 0 || str.length() == 0) { return false; }
        String[] s = str.split(" ");
        if (s.length != pattern.length()) { return false; }
        Map<Character, String> map = new HashMap<>();
        char[] p = pattern.toCharArray();
        Set<Character> pSet = new HashSet<>();
        for (char c : p) {
            pSet.add(c);
        }
        Set<String> sSet = new HashSet<>(Arrays.asList(s));
        if (sSet.size() != pSet.size()) {
            return false;
        }
        for (int i = 0; i < p.length; i++) {
            String in = map.put(p[i], s[i]);
            if (null != in && in.length() > 0) {
                if (!in.equals(s[i])) { return false; }
            }
        }
        return true;
    }

    public boolean wordPattern2(String pattern, String str) {
        if (null == pattern || null == str || pattern.length() == 0 || str.length() == 0) { return false; }
        String[] s = str.split(" ");
        if (s.length != pattern.length()) { return false; }
        Map<Character, String> map = new HashMap<>();
        char[] p = pattern.toCharArray();
        for (int i = 0; i < p.length; i++) {
            if (map.containsKey(p[i]) && !map.get(p[i]).equals(s[i])) {
                return false;
            }
            if (!map.containsKey(p[i]) && map.containsValue(s[i])) {
                return false;
            }
            map.put(p[i], s[i]);
        }
        return true;
    }

}
