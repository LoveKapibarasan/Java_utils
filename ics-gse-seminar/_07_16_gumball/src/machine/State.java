package machine;

public abstract class State {
    protected GumballMachine machine;
    protected State(GumballMachine machine) {
        this.machine = machine;
    }

    public void insertQuarter() {
        throw new UnsupportedOperationException();
    }

    public void ejectQuarter() {
        throw new UnsupportedOperationException();
    }

    public void turnCrank() {
        throw new UnsupportedOperationException();
    }

    public void dispense() {
        throw new UnsupportedOperationException();
    }

    public void refill(int n) {
        throw new UnsupportedOperationException();
    }

    public void abandon() {
        throw new UnsupportedOperationException();
    }
}
