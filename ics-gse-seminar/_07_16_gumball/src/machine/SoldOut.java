package machine;

public class SoldOut extends State {
    public SoldOut(GumballMachine machine) {
        super(machine);
    }

    @Override
    public void refill(int n) {
        super.refill(n);
    }
}
