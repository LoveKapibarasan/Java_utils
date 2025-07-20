import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LockingSystemTest {
    private LockingSystem system;
    @Before public void setUp() {
        system = new LockingSystem();
    }

    @Test
    public void testStateCoverage() {
        // Initial: Closed
        system.authorize(); // now authorized = true
        assertTrue(system.authorized);

        system.open();      // Closed → Opened
        assertEquals(1, system.counter);

        system.close();     // Opened → Closed
        assertEquals(2, system.counter);

        system.lock();      // Closed → Locked (authorized)
        assertEquals(3, system.counter);

        system.unlock();    // Locked → Closed
        assertEquals(4, system.counter);
    }

    @Test
    public void testTransitionCoverage() {
        // Covers all transitions, including abandon()
        system.authorize();           // no state change, sets flag
        assertTrue(system.authorized);

        system.open();                // Closed → Opened
        assertEquals(1, system.counter);

        system.close();              // Opened → Closed
        assertEquals(2, system.counter);

        system.lock();               // Closed → Locked
        assertEquals(3, system.counter);

        system.unlock();             // Locked → Closed
        assertEquals(4, system.counter);

        system.abandon();            // sets authorized = false
        assertFalse(system.authorized);
    }
}
