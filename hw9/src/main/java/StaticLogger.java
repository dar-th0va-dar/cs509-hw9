public class StaticLogger {
    public enum Level {
        COMMENT,
        WARNING,
        ERROR
    }

    private StaticLogger() {

    }

    public static void log(Level level, String message) {
        if (level == Level.COMMENT) {
            comment(message);
        } else if (level == Level.WARNING) {
            warning(message);
        } else if (level == Level.ERROR) {
            error(message);
        }

    }

    private static void comment(String message) {
        System.out.println("Comment: " + message);
    }

    private static void warning(String message) {
        System.out.println("\u001B[33m" + "Warning: " + message);
    }

    private static void error(String message) {
        System.out.println("\u001B[31m" + "Error: " + message);
        System.exit(0);
    }

    public static void main(String[] args) {
        StaticLogger.log(Level.COMMENT, "expand on this code");
        StaticLogger.log(Level.WARNING, "possible unwanted override of variables");
        StaticLogger.log(Level.ERROR, "divide by 0");
    }
}
