package dry;

public class Fraction {
    private final int num;
    private final int denom;

    public enum Operation { ADD, SUB }

    public Fraction(int num, int denom) {
        this.num = num;
        this.denom = denom;
    }

    public Fraction calculate(Fraction other, Operation op) {
        if (other == null) return this;
        int op1 = this.num * other.denom;
        int op2 = this.denom * other.num;
        int num = switch (op) {
            case ADD -> op1 + op2;
            case SUB -> op1 - op2;
        };
        int denom = this.denom * other.denom;
        return new Fraction(num, denom);
    }
}
