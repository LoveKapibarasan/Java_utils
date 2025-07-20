public class Client {
    public static void main(String[] args) {
        Species vertebrates = new Species("Vertebrate", null);
        Species mammals = new Species("Mammal", vertebrates);
        Species canines = new Species("Canine", mammals);
        Species dog = new Species("Dog", canines);
        Species wolf = new Species("Wolf", canines);
        Animal waldo = new Animal("Waldo", dog);
        Animal teddy = new Animal("Teddy", wolf);
        System.out.println(waldo);
        System.out.println(teddy);
    }
}
