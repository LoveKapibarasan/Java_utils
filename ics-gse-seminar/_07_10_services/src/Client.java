import model.Order;

import java.util.List;

public class Client {
    public static void main(String[] args) throws IllegalAccessException {
        Gateway gateway = new Gateway();
        List<Order> orders = gateway.getPendingOrders("1234");
        System.out.println(orders);
    }
}
