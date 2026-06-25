public class singletonPattern {

    static class Logger {

        private static Logger instance = new Logger();

        private Logger() {
        }

        public static Logger getInstance() {
            return instance;
        }

        public void log(String message) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application Started");
        logger2.log("Application Running");

        System.out.println("Same Instance: " + (logger1 == logger2));
        System.out.println("Logger1 HashCode: " + logger1.hashCode());
        System.out.println("Logger2 HashCode: " + logger2.hashCode());
    }
}