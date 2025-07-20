package refactored;

import java.util.ArrayList;
import java.util.List;

public class Wishlist {
    public List<String> elements = new ArrayList<>();
}

class ClientCode {
    public static void main(String[] args) {
        Wishlist w = new Wishlist();
        w.elements.add("peace");
        w.elements.add("successful students");
        w.elements.add("happy children");
        w.elements.add("a new TV");
    }
}
