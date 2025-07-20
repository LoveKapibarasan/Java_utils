/**
 *  Context Class
*/

public class LockingSystem {
    private LockState state;
    int counter = 0;
    boolean authorized = false;

    public LockingSystem() {
        this.state = new ClosedState(); // initial state
    }

    public void setState(LockState state) {
        this.state = state;
    }

    public void open() {
        state.open(this);
    }

    public void close() {
        state.close(this);
    }

    public void lock() {
        state.lock(this);
    }

    public void unlock() {
        state.unlock(this);
    }

    public void authorize() {
        state.authorize(this);
    }

    public void abandon() {
        state.abandon(this);
    }
}
