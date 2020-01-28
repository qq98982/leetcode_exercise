package com.home.henry.string_02;

/**
 * 38. Count and Say
 *
 * 第二个方法是递归解法
 */
public class CountAndSay_L038_015 {

    public String countAndSay(int n) {
        int i = 1;
        String res = "1";
        while (i < n) {
            int count = 0;
            final StringBuilder sb = new StringBuilder();
            char c = res.charAt(0);
            for (int j = 0; j <= res.length(); j++) {
                if (j != res.length() && c == res.charAt(j)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(c);
                    if (j != res.length()) {
                        count = 1;
                        c = res.charAt(j);
                    }
                }
            }
            res = sb.toString();
            i++;
        }
        return res;
    }

    public static String countAndSay2(int n) {
        if (n == 1) { return "1"; }

        final StringBuilder res = new StringBuilder();

        // recursively call for (n-1) th number, "a" is only for the edge case at the end of the loop with `s.charAt(i+1)`
        final String s = countAndSay2(n - 1) + "a";

        for (int i = 0, c = 1; i < s.length() - 1; i++, c++) {
            // if next digit is different, then append the count so far `c` and the digit itself, then set count `c` to zero
            if (s.charAt(i + 1) != s.charAt(i)) {
                res.append(c).append(s.charAt(i));
                c = 0;
            }
        }

        return res.toString();
    }

}
