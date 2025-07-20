public class ParensToGraph {
    public static Object run(String input) {
        Logger logger = new Logger();
        logger.log("Main module is setting up pipeline ...");
        Tokenizer tokenizer = new Tokenizer(logger);
        tokenizer.setInput(input);
        Parser parser = new Parser(logger);
        Visualizer visualizer = new Visualizer(logger);
        Control control = new Control(logger, tokenizer, parser, parser, visualizer);
        logger.log("Main module runs control.");
        return control.run();
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Example args: (()(())((()()))");
        }
        run(args[0]);
    }
}
