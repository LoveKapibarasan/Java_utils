import java.util.List;

public class Client {
    public static void main(String[] args) {
        DoubleAccumulator a = new DoubleAccumulator(new Plus());
        List<Double> values = List.of(1.0, 2.0, 3.0, 4.0, 5.0);
        System.out.println(a.accumulate(values, 0.0));
        a.adapt(new Times());
        System.out.println(a.accumulate(values, 1.0));
    }
}
