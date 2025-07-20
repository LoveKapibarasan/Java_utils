package machine;

public class Sold extends State {
    public Sold(GumballMachine machine) {
        super(machine);
    }

    @Override public void dispense() {
        machine.decrementBalls();
        if (machine.getBalls() == 1) {
            machine.setState(new SoldOut(machine));
        } else {
            machine.setState(new NoQuarter(machine));
        }
    }

    @Override public void abandon() {
        machine.setState(null);
    }
}
