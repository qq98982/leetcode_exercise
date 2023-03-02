package com.home.henry.others.pramp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NewtonSquareRootTest {

    @Test
    void testSquareRoot() {
        assertEquals(1.4142135623746899, NewtonSquareRoot.squareRoot(2.0, 0.0001), 0.00000001);
        assertEquals(1.7320508100147274, NewtonSquareRoot.squareRoot(3.0, 0.0001), 0.00000001);
        assertEquals(2.000000000000002, NewtonSquareRoot.squareRoot(4.0, 0.0001), 0.00000001);
    }

}
