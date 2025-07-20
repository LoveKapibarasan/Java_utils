package common_interface;

public class Robot implements Worker {
    @Override public void work() {
        System.out.println("Robot is working.");
    }
    @Override public void eat() {
        throw new UnsupportedOperationException("Robot cannot eat.");
    }
}
