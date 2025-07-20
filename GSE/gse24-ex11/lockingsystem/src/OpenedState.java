public class OpenedState implements LockState {
    @Override
    public void open(LockingSystem ctx) {}

    @Override
    public void close(LockingSystem ctx) {
        ctx.counter++;
        ctx.setState(new ClosedState());
    }

    @Override
    public void lock(LockingSystem ctx) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void unlock(LockingSystem ctx) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void authorize(LockingSystem ctx) {
        ctx.authorized = true;
    }

    @Override
    public void abandon(LockingSystem ctx) {
        ctx.authorized = false;
    }
}
