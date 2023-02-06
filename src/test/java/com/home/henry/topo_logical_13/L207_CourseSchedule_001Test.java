package com.home.henry.topo_logical_13;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class L207_CourseSchedule_001Test {

    @Test
    void testCanFinishDFS() {
        assertFalse(L207_CourseSchedule_001.canFinishDFS(2, new int[][] { { 1, 0 }, { 0, 1 } }));
        assertTrue(L207_CourseSchedule_001.canFinishDFS(2, new int[][] { { 1, 0 } }));
    }

    @Test
    void testCanFinishBFS() {
        assertFalse(L207_CourseSchedule_001.canFinishBFS(2, new int[][] { { 1, 0 }, { 0, 1 } }));
        assertTrue(L207_CourseSchedule_001.canFinishBFS(2, new int[][] { { 1, 0 } }));
    }
}
