package com.home.henry.dp_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class L070_ClimbingStairs_001Test {

    @Test
    void testClimbStairs() {
        assertEquals(1, L070_ClimbingStairs_001.climbStairs(1));
        assertEquals(2, L070_ClimbingStairs_001.climbStairs(2));
        assertEquals(3, L070_ClimbingStairs_001.climbStairs(3));
        assertEquals(5, L070_ClimbingStairs_001.climbStairs(4));
        assertEquals(8, L070_ClimbingStairs_001.climbStairs(5));
    }

    @Test
    void testClimbStairsSec() {
        assertEquals(1, L070_ClimbingStairs_001.climbStairsSec(1));
        assertEquals(2, L070_ClimbingStairs_001.climbStairsSec(2));
        assertEquals(3, L070_ClimbingStairs_001.climbStairsSec(3));
        assertEquals(5, L070_ClimbingStairs_001.climbStairsSec(4));
        assertEquals(8, L070_ClimbingStairs_001.climbStairsSec(5));
    }

}
