package machine;

public class HasQuarter extends State {
    public HasQuarter(GumballMachine machine) {
        super(machine);
    }

    @Override public void ejectQuarter() {
        machine.setState(new NoQuarter(machine));
    }

    @Override public void turnCrank() {
        machine.setState(new Sold(machine));
    }
}
