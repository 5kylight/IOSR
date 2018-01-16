package com.wiet.math.core.dividers.service;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DividersServiceTest {

    @Test
    public void testPositive() throws Exception {
        DividersService ds = new DividersService();

        assertListEquals(ds.getDividers(0), 0);
        assertListEquals(ds.getDividers(1), 1);
        assertListEquals(ds.getDividers(2), 1, 2);
        assertListEquals(ds.getDividers(24), 1, 2, 3, 4, 6, 8, 12, 24);
    }

    private void assertListEquals(List<Integer> actual, int... expected) {
        if (actual != null && expected != null) {
            assertEquals(expected.length, actual.size());
            for (int i = 0; i < expected.length; i++) {
                assertEquals(actual.get(i).intValue(), expected[i]);
            }
        } else {
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testNegative() throws Exception {
        DividersService ds = new DividersService();

        assertListEquals(ds.getDividers(0), 0);
        assertListEquals(ds.getDividers(-1), 1);
        assertListEquals(ds.getDividers(-2), 1, 2);
        assertListEquals(ds.getDividers(-24), 1, 2, 3, 4, 6, 8, 12, 24);
    }
}
