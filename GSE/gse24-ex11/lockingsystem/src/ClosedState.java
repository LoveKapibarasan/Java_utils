public class ClosedState implements LockState {
    @Override
    public void open(LockingSystem ctx) {
        ctx.counter++;
        ctx.setState(new OpenedState());
    }

    @Override
    public void lock(LockingSystem ctx) {
        if (!ctx.authorized) throw new UnsupportedOperationException("Unauthorized");
        ctx.counter++;
        ctx.setState(new LockedState());
    }

    @Override
    public void unlock(LockingSystem ctx) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void close(LockingSystem ctx) {}

    @Override
    public void authorize(LockingSystem ctx) {
        ctx.authorized = true;
    }

    @Override
    public void abandon(LockingSystem ctx) {
        ctx.authorized = false;
    }
}
