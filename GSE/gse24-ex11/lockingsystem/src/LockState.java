public interface LockState {
    void open(LockingSystem ctx) throws UnsupportedOperationException;
    void close(LockingSystem ctx) throws UnsupportedOperationException;
    void lock(LockingSystem ctx) throws UnsupportedOperationException;
    void unlock(LockingSystem ctx) throws UnsupportedOperationException;
    void authorize(LockingSystem ctx);
    void abandon(LockingSystem ctx);
}
