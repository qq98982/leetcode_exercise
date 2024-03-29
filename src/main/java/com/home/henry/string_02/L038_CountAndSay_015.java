package com.home.henry.string_02;

/**
 * 38. Count and Say
 *
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. You can do so
 * recursively, in other words from the previous member read off the digits, counting the number of digits
 * in groups of the same digit.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * Input: 1 Output: "1"
 * Explanation: This is the base case.
 *
 * Input: 4 Output: "1211"
 * Explanation: For n = 3 the term was "21" in which we have two groups "2" and "1", "2" can be read as "12"
 * which means frequency = 1 and value = 2, the same way "1" is read as "11", so the answer is the
 * concatenation of "12" and "11" which is "1211".
 *
 * 第二个方法是递归解法
 */
public class L038_CountAndSay_015 {

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
