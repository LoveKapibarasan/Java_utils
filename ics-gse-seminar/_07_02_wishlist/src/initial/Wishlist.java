package initial;

public class Wishlist {
    public String[] elements = new String[10];
}

class ClientCode {
    public static void main(String[] args) {
        Wishlist w = new Wishlist();
        w.elements[0] = "peace";
        w.elements[1] = "successful students";
        w.elements[2] = "happy children";
        w.elements[3] = "a new TV";
    }
}
