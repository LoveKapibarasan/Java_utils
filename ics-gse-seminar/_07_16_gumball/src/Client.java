import machine.GumballMachine;

public class Client {
    public static void main(String[] args) {
        GumballMachine machine = new GumballMachine();
        machine.insertQuarter();
        machine.ejectQuarter();
        machine.insertQuarter();
        machine.turnCrank();
        machine.dispense();
        machine.insertQuarter();
        machine.turnCrank();
        machine.dispense();
        System.out.println(machine.getBalls());
    }
}
