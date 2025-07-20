package initial;

public class Fraction {
    private final int num;
    private final int denom;

    public Fraction(int num, int denom) {
        this.num = num;
        this.denom = denom;
    }

    public Fraction add(Fraction other) {
        if (other == null) return this;
        int op1 = this.num * other.denom;
        int op2 = this.denom * other.num;
        int num = op1 + op2;
        int denom = this.denom + other.denom;
        return new Fraction(num, denom);
    }

    public Fraction subtract(Fraction other) {
        if (other == null) return this;
        int op1 = this.num * other.denom;
        int op2 = this.denom * other.num;
        int num = op1 - op2;
        int denom = this.denom * other.denom;
        return new Fraction(num, denom);
    }
}
