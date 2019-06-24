package com.home.henry.stack_pq_11;

import java.util.Stack;

/**
 * 394. Decode String
 */
public class DecodeString_L394_007 {

    public static String decodeString(String s) {
        if (s == null || s.length() == 0) {return "";}
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> values = new Stack<>();
        values.push(new StringBuilder());
        int num = 0;
        char[] c = s.toCharArray();
        for (Character ch : c) {
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                values.push(new StringBuilder());
                counts.push(num);
                // reset for next nums
                num = 0;
            } else if (ch == ']') {
                String toAppend = values.pop().toString();
                int count = counts.pop();
                StringBuilder nsb = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    nsb.append(toAppend);
                }
                values.push(values.pop().append(nsb.toString()));
            } else {
                // peek()的东西可以更改的
                values.peek().append(ch);
            }
        }
        return values.pop().toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
}
