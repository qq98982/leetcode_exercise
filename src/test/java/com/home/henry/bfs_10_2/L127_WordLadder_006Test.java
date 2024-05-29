package com.home.henry.bfs_10_2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L127_WordLadder_006Test {

    private L127_WordLadder_006 l127WordLadder006UnderTest;

    @BeforeEach
    void setUp() {
        l127WordLadder006UnderTest = new L127_WordLadder_006();
    }

    @Test
    void testLadderLength() {
        assertEquals(5, l127WordLadder006UnderTest.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        assertEquals(0, l127WordLadder006UnderTest.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
    }

    @Test
    void testLadderLength2() {
        assertEquals(5, l127WordLadder006UnderTest.ladderLength2("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
        assertEquals(0, l127WordLadder006UnderTest.ladderLength2("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
    }
}
