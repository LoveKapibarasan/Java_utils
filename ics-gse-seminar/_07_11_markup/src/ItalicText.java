public class ItalicText implements TextDecorator {
	@Override public String decorate(String text) {
		return "<i>" + text + "</i>";
	}
}
