public class UnderlinedText implements TextDecorator {
	@Override public String decorate(String text) {
		return "<u>" + text + "</u>";
	}
}
