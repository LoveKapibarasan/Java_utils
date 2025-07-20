package machine;

public class NoQuarter extends State {
    public NoQuarter(GumballMachine gumballMachine) {
        super(gumballMachine);
    }

    @Override public void insertQuarter() {
        machine.setState(new HasQuarter(machine));
    }
}
