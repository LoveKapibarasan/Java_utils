public class Species {
    private final String label;
    private final Species superType;

    public Species(String label, Species superType) {
        this.label = label;
        this.superType = superType;
    }

    @Override
    public String toString() {
        return label + (superType == null ? "" : " is a " + superType);
    }
}
