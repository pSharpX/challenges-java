package com.challenger.common.sortdesc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortDescTest {

    @Test
    public void test_01() {
        Assertions.assertEquals(0, SortDescChallenge.sortDesc(0));
    }

    @Test
    public void test_02() {
        Assertions.assertEquals(51, SortDescChallenge.sortDesc(15));
    }


    @Test
    public void test_03() {
        Assertions.assertEquals(987654321, SortDescChallenge.sortDesc(123456789));
    }

}
