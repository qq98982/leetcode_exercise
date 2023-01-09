package com.home.henry.dp_06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class L354_RussianDollEnvelopes_016Test {

    @Test
    void maxEnvelopesTest() {
        Assertions.assertEquals(3, L354_RussianDollEnvelopes_016.Solution.maxEnvelopes(
                new int[][] { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } }));
    }
}
