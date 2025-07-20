package designed_for_change;

public class Wishlist {
    private int current = 0;
    private String[] elements = new String[10];
    public void addElement(String element) {
        elements[current++] = element;
    }
}

class ClientCode {
    public static void main(String[] args) {
        Wishlist w = new Wishlist();
        w.addElement("peace");
        w.addElement("successful students");
        w.addElement("happy children");
        w.addElement("a new TV");
    }
}
