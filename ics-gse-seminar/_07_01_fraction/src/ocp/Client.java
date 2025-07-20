package ocp;

public class Client {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(2, 4);
        Fraction f2 = new Fraction(3, 5);
        Fraction f3 = f1.calculate(f2, Fraction.ADD);
        Fraction f4 = f1.calculate(f2, Fraction.SUB);
        Fraction f5 = f1.calculate(f2, (o1, o2) -> o1 * o2);
    }
}
