import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger implements Closeable {
    private static final String LOG_FILE_NAME = "_07_07_logger/log.txt";

    private static Logger instance;

    private FileOutputStream outputStream;

    private Logger(String logFilePath) {
        try {
            outputStream = new FileOutputStream(logFilePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger(LOG_FILE_NAME);
        }
        return instance;
    }

    public void log(String text) {
        PrintWriter pw = new PrintWriter(outputStream);
        pw.println(text);
        pw.close();
    }

    @Override
    public void close() throws IOException {
        outputStream.close();
    }
}
