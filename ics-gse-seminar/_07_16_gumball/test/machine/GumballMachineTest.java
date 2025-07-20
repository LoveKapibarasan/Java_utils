package machine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GumballMachineTest {
    private GumballMachine instance;

    @Before
    public void setUp() {
        instance = new GumballMachine(1);
    }

    @Test
    public void testStateTransition() {
        assertEquals(NoQuarter.class, instance.getState().getClass());
        assertEquals(1, instance.getBalls());

        instance.insertQuarter();

        assertEquals(HasQuarter.class, instance.getState().getClass());
        assertEquals(1, instance.getBalls());

        instance.turnCrank();

        assertEquals(Sold.class, instance.getState().getClass());
        assertEquals(1, instance.getBalls());

        instance.dispense();

        assertEquals(SoldOut.class, instance.getState().getClass());
        assertEquals(0, instance.getBalls());
    }
}


