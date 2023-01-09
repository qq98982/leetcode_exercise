package com.home.henry.dp_06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class L377_CombinationSumIV_008Test {

    @Test
    void testMain() {
        Assertions.assertEquals(7, L377_CombinationSumIV_008.Solution.combinationSum4(new int[] { 1, 2, 3 }, 4));
        Assertions.assertEquals(39882198, L377_CombinationSumIV_008.Solution.combinationSum4(new int[] { 1, 2, 4 }, 32));
    }
}
