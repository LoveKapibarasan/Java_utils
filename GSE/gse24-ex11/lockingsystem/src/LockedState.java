public class LockedState implements LockState {
    @Override
    public void unlock(LockingSystem ctx) {
        if (!ctx.authorized) throw new UnsupportedOperationException("Unauthorized");
        ctx.counter++;
        ctx.setState(new ClosedState());
    }

    @Override
    public void open(LockingSystem ctx) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void close(LockingSystem ctx) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void lock(LockingSystem ctx) {}

    @Override
    public void authorize(LockingSystem ctx) {
        ctx.authorized = true;
    }

    @Override
    public void abandon(LockingSystem ctx) {
        ctx.authorized = false;
    }
}
