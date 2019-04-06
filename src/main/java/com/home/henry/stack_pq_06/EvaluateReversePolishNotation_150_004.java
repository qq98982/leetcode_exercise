package com.home.henry.stack_pq_06;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 */
public class EvaluateReversePolishNotation_150_004 {

    public int evalRPN(String[] tokens) {
        int a, b;
        Stack<Integer> st = new Stack<>();
        for (String s : tokens) {
            switch (s) {
                case "+":
                    st.add(st.pop() + st.pop());
                    break;
                case "-":
                    a = st.pop();
                    b = st.pop();
                    st.add(b - a);
                    break;
                case "*":
                    st.add(st.pop() * st.pop());
                    break;
                case "/":
                    a = st.pop();
                    b = st.pop();
                    st.add(b / a);
                    break;
                default:
                    st.push(Integer.valueOf(s));
                    break;
            }
        }
        return st.pop();
    }

}
