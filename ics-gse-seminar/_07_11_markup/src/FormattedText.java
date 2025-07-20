import java.util.ArrayList;
import java.util.List;

public class FormattedText {
	private String text;
	private List<TextDecorator> decorators = new ArrayList<>();

	public FormattedText(String text) {
		this.text = text;
	}
	
	public void addDecorator(TextDecorator decorator) {
		decorators.add(decorator);
	}
	
	public String getText() {
		String res = text;
		for (TextDecorator decorator : decorators) {
			res = decorator.decorate(res);
		}
		return res;
	}
}
