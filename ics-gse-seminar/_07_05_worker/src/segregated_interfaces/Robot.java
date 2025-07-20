package segregated_interfaces;

public class Robot implements Workable {
    @Override public void work() {
        System.out.println("Robot is working.");
    }
}
