public class Animal {
    private final String name;
    private final Species species;

    public Animal(String name, Species species) {
        this.name = name;
        this.species = species;
    }

    @Override
    public String toString() {
        return name + " is a " + species;
    }
}
