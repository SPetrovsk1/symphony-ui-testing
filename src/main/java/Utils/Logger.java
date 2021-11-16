package Utils;

import org.slf4j.LoggerFactory;


public class Logger {

    private static org.slf4j.Logger Log = LoggerFactory.getLogger("Log");

    public static void info(String message) {
        Log.info(message);
    }

    public static void error(String message) {
        Log.error(message);
    }

    private Logger() {
        throw new IllegalStateException("Utility class");
    }

}
