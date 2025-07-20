import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getInstance();
        logger.log("Hello");
        logger.close();
    }
}
