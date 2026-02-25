// package dsa.oops;

public class Oop_09 {
    public static void main(String[] args) {
        // Usage
        Logger logger = Logger.getInstance();
        logger.logMessage("This is a log message.");

    }

}

class Logger {
    private static Logger loggerInstance = null;

    private Logger() {
        // Private constructor to restrict instantiation
    }

    public static Logger getInstance() {
        if (loggerInstance == null) {
            loggerInstance = new Logger();
        }
        return loggerInstance;
    }

    public void logMessage(String message) {
        System.out.println(message);
    }
}
