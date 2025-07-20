public class Client {
    public static void main(String[] args) {
        FormattedText hello = new FormattedText("Hello!");
        hello.addDecorator(new BoldText());
        hello.addDecorator(new ItalicText());
        hello.addDecorator(new UnderlinedText());
        System.out.println(hello.getText());
    }
}
