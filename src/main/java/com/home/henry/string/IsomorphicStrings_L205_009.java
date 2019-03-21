package com.home.henry.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 *
 * Input: s = "egg", t = "add"  Output: true
 * 第一种值放入map中, 如果重复, 会返回以前的value, 依靠这个特性判断是否不一样, 另外, 使用了Objects.equals()方法, 否则Null Pointer
 * 第二个方法速度快, 并且也很巧妙, Arrays.fill()初始化为-1 存储了字母的index
 */
public class IsomorphicStrings_L205_009 {

    public boolean isIsomorphic(String s, String t) {
        Map<Object, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!Objects.equals(map.put(s.charAt(i), i), map.put(t.charAt(i) + "", i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        if (null == s || null == t || s.length() != t.length()) { return false; }
        char[] sch = s.toCharArray();
        char[] tch = t.toCharArray();
        int[] m = new int[256];
        int[] n = new int[256];
        Arrays.fill(m, -1);
        Arrays.fill(n, -1);
        for (int i = 0; i < sch.length; i++) {
            if (m[sch[i]] != n[tch[i]]) {
                return false;
            }
            m[sch[i]] = i;
            n[tch[i]] = i;
        }
        return true;
    }
}
