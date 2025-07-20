import java.util.Collection;

public class Client {
    public static void main(String[] args) {
        Collection<String> orderedUniqueStrings = new CollectionFactory().createCollection(true, true);
        orderedUniqueStrings.add("A");
        orderedUniqueStrings.add("B");
        orderedUniqueStrings.add("B");
        orderedUniqueStrings.add("C");
        System.out.println(orderedUniqueStrings); // [A, B, C]
    }
}
