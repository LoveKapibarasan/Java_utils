import model.Order;
import model.User;
import services.AuthService;
import services.OrderService;
import services.UserDataService;

import java.util.List;

public class Gateway {
    private AuthService authService;
    private UserDataService userDataService;
    private OrderService orderService;

    public Gateway() {
        this.authService = new AuthService();
        this.userDataService = new UserDataService();
        this.orderService = new OrderService();
    }

    public List<Order> getPendingOrders(String userId) throws IllegalAccessException {
        User user = userDataService.getUser(userId);
        if (authService.isAuthorized(user)) {
            List<String> orderIds = orderService.getOrderIdsByUser(userId);
            List<Order> orders = orderService.getOrdersByIds(orderIds);
            return orders;
        } else {
            throw new IllegalAccessException(userId + " is not authorized.");
        }
    }
}
