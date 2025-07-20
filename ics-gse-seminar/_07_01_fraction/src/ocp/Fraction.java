package ocp;

public class Fraction {
    private final int num;
    private final int denom;

    public interface Operation {
        public int apply(int op1, int op2);
    }

    public static final Operation ADD = (op1, op2) -> op1 + op2;
    public static final Operation SUB = (op1, op2) -> op1 - op2;

    public Fraction(int num, int denom) {
        this.num = num;
        this.denom = denom;
    }

    public Fraction calculate(Fraction other, Operation op) {
        if (other == null) return this;
        int op1 = this.num * other.denom;
        int op2 = this.denom * other.num;
        int num = op.apply(op1, op2);
        int denom = this.denom + other.denom;
        return new Fraction(num, denom);
    }
}
