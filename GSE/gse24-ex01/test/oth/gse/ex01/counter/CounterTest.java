package oth.gse.ex01.counter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CounterTest {

    private Counter instance;

    @Before
    public void init() {
        instance = new Counter();
    }

    @Test
    public void initialValueIsZero() {
        assertEquals(0, instance.get());
    }

    @Test
    public void incrementingThenGettingReturnsUpdatedValue() {
        final int n = 42;
        for (int i = 0; i < 42; i++) {
            instance.increment();
        }
        assertEquals(n, instance.get());
    }

    @Test
    public void resettingAndGettingReturnsZero() {
        instance.increment();
        assertEquals(1, instance.get());
        instance.reset();
        assertEquals(0, instance.get());
    }


}
