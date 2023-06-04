package com.home.henry.math_03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class L412_FizzBuzz_017Test {

    private L412_FizzBuzz_017 l412FizzBuzz017UnderTest;

    @BeforeEach
    void setUp() {
        l412FizzBuzz017UnderTest = new L412_FizzBuzz_017();
    }

    @Test
    void testFizzBuzz() {
        assertEquals(List.of("1","2","Fizz"), l412FizzBuzz017UnderTest.fizzBuzz(3));
        assertEquals(List.of("1","2","Fizz","4","Buzz"), l412FizzBuzz017UnderTest.fizzBuzz(5));
        assertEquals(List.of("1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"), l412FizzBuzz017UnderTest.fizzBuzz(15));
        assertEquals(Collections.emptyList(), l412FizzBuzz017UnderTest.fizzBuzz(0));
    }
}
