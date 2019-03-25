package com.home.henry.string;

public class MinimumWindowSubstring_L76_022 {

    public String minWindow(String s, String t) {
        int[] cnt = new int[128];
        for (char c : t.toCharArray()) {
            cnt[c]++;
        }
        int min = Integer.MAX_VALUE;
        int from = 0;
        int total = t.length();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i)]-- > 0) total--;
            while (total == 0) {
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    from = j;
                }
                if (++cnt[s.charAt(j++)] > 0) total++;
            }
        }

        return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);
    }
}
