package com.home.henry.stack_pq_11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L071_SimplifyPath_005Test {

    private L071_SimplifyPath_005 l071SimplifyPath005UnderTest;

    @BeforeEach
    void setUp() {
        l071SimplifyPath005UnderTest = new L071_SimplifyPath_005();
    }

    @Test
    void testSimplifyPath() {
        assertEquals("/home", l071SimplifyPath005UnderTest.simplifyPath("/home/"));
        assertEquals("/", l071SimplifyPath005UnderTest.simplifyPath("/../"));
        assertEquals("/home/foo", l071SimplifyPath005UnderTest.simplifyPath("/home//foo/"));
    }
}
