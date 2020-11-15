package com.home.henry.stack_pq_11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.home.henry.stack_pq_11.L085_MaximalRectangle_010.Solution;

class L085_MaximalRectangle_010Test {

    @Test
    void maximalRectangle() {
        char[] a = { '1', '0', '1', '0', '0' };
        char[] b = { '1', '0', '1', '1', '1' };
        char[] c = { '1', '1', '1', '1', '1' };
        char[] d = { '1', '0', '0', '1', '0' };
        char[][] e = { a, b, c, d };
        Assertions.assertEquals(6, Solution.maximalRectangle(e));

    }
}