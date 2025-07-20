public class Times implements AccumulationStrategy {
	@Override public double accumulate(double a, double b) {
		return a * b;
	}
}
