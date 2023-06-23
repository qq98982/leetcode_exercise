package com.home.henry.stack_pq_11;

import java.util.Stack;

/**
 * 394. Decode String
 */
public class L394_DecodeString_007 {

    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> stack = new Stack<>();
        stack.push(new StringBuilder());
        int num = 0;
        char[] c = s.toCharArray();
        for (Character ch : c) {
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                stack.push(new StringBuilder());
                counts.push(num);
                // reset for next nums
                num = 0;
            } else if (ch == ']') {
                String append = stack.pop().toString();
                int count = counts.pop();
                StringBuilder nsb = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    nsb.append(append);
                }
                stack.push(stack.pop().append(nsb.toString()));
            } else {
                // peek()的东西可以更改的
                stack.peek().append(ch);
            }
        }
        return stack.pop().toString();
    }

}
