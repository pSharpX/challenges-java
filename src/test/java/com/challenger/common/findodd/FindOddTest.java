package com.challenger.common.findodd;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindOddTest {

    private static void doTest(int[] input, int expected) {
        String message = String.format("for array = %s\n", Arrays.toString(input));
        int actual = FindOdd.findIt2(input);
        assertEquals(expected, actual, message);
    }

    @Test
    public void sampleTests() {
        doTest(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}, 5);
        doTest(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5}, -1);
        doTest(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}, 5);
        doTest(new int[]{10}, 10);
        doTest(new int[]{1,1,1,1,1,1,10,1,1,1,1}, 10);
        doTest(new int[]{5,4,3,2,1,5,4,3,2,10,10}, 1);
    }

}
