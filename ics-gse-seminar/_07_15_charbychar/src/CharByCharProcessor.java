import java.util.function.Function;

public class CharByCharProcessor {
	private Function<Character, Character> strategy;
	public CharByCharProcessor(Function<Character, Character> strategy) {
		this.strategy = strategy;
	}
	public void setStrategy(Function<Character, Character> strategy) {
		this.strategy = strategy;
	}
	
	public String process(String s) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			sb.append(strategy.apply(c));
		}
		return sb.toString();
	}
}
