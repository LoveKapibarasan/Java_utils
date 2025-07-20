package machine;

public class GumballMachine {
    private int balls;
    private State currentState;

    public GumballMachine(int balls) {
        this.balls = balls;
        currentState = new NoQuarter(this);
    }

    public GumballMachine() {
        this(3);
    }

    void setState(State state) {
        this.currentState = state;
    }

    State getState() {
        return currentState;
    }

    void decrementBalls() {
        balls--;
    }

    public void insertQuarter() {
        currentState.insertQuarter();
    }

    public void ejectQuarter() {
        currentState.ejectQuarter();
    }

    public void turnCrank() {
        currentState.turnCrank();
    }

    public void dispense() {
        currentState.dispense();
    }

    public void refill(int n) {
        currentState.refill(n);
    }

    public void abandon() {
        currentState.abandon();
    }

    public int getBalls() {
        return balls;
    }
}
