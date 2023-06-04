package com.home.henry.topo_logical_13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L126_WordLadderII_002Test {

    private L126_WordLadderII_002 l126WordLadderII002UnderTest;

    @BeforeEach
    void setUp() {
        l126WordLadderII002UnderTest = new L126_WordLadderII_002();
    }

    @Test
    void testFindLadders() {
        assertEquals(
                List.of(List.of("hit", "hot", "lot", "log", "cog"), List.of("hit", "hot", "dot", "dog", "cog")),
                l126WordLadderII002UnderTest.findLadders("hit", "cog",
                                                         List.of("hot", "dot", "dog", "lot", "log", "cog")));
    }
}
