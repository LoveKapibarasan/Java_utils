public class Plus implements AccumulationStrategy {
	@Override public double accumulate(double a, double b) {
		return a + b;
	}
}
