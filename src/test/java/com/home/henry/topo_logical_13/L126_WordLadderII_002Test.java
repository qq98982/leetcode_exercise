package com.home.henry.topo_logical_13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
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
        final List<String> list1 = new ArrayList<>();
        list1.addAll(Arrays.asList("hit", "hot", "lot", "log", "cog"));
        final List<String> list2 = new ArrayList<>();
        list2.addAll(Arrays.asList("hit", "hot", "dot", "dog", "cog"));
        final List<String> list3 = new ArrayList<>();
        list3.addAll(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        assertEquals(
                Arrays.asList(list2, list1),
                l126WordLadderII002UnderTest.findLadders("hit", "cog",
                                                         list3));
    }
}
