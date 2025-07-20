public class BoldText implements TextDecorator {
	@Override public String decorate(String text) {
		return "<b>" + text + "</b>";
	}
}
