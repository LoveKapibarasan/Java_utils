import java.util.List;

public class DoubleAccumulator {
	private AccumulationStrategy strategy;
	public DoubleAccumulator(AccumulationStrategy strategy) {
		this.strategy = strategy;
	}
	public void adapt(AccumulationStrategy strategy) {
		this.strategy = strategy;
	}

	public double accumulate(List<Double> values, double neutral) {
		double current = neutral;
		for (double v : values) {
			current = strategy.accumulate(current, v);
		}
		return current;
	}
}
