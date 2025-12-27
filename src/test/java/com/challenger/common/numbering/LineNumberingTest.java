package com.challenger.common.numbering;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LineNumberingTest {

    @Test
    public void basicTests() {
        Assertions.assertIterableEquals(Arrays.asList(), LineNumberingChallenge.number(Arrays.asList()));
        Assertions.assertIterableEquals(Arrays.asList("1: a", "2: b", "3: c"), LineNumberingChallenge.number(Arrays.asList("a", "b", "c")));
        Assertions.assertIterableEquals(Arrays.asList("1: ", "2: ", "3: ", "4: ", "5: "), LineNumberingChallenge.number(Arrays.asList("", "", "", "", "")));
    }

}
