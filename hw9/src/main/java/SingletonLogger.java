public class SingletonLogger {
    public enum Level {
        COMMENT,
        WARNING,
        ERROR
    }

    static SingletonLogger instance;

    private SingletonLogger() {

    }

    public void log(Level level, String message) {
        if (level == Level.COMMENT) {
            comment(message);
        } else if (level == Level.WARNING) {
            warning(message);
        } else if (level == Level.ERROR) {
            error(message);
        }

    }

    private void comment(String message) {
        System.out.println("Comment: " + message);
    }

    private void warning(String message) {
        System.out.println("\u001B[33m" + "Warning: " + message);
    }

    private void error(String message) {
        System.out.println("\u001B[31m" + "Error: " + message);
        System.exit(0);
    }

    public static SingletonLogger Instance() {
        if (instance == null)
        {
            instance = new SingletonLogger();
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonLogger logger = SingletonLogger.Instance();

        logger.log(Level.COMMENT, "expand on this code");
        logger.log(Level.WARNING, "possible unwanted override of variables");
        logger.log(Level.ERROR, "divide by 0");
    }
}
