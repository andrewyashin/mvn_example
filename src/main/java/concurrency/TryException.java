package concurrency;

import java.sql.SQLDataException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by andrew_yashin on 2/13/17.
 */
public class TryException implements Runnable {
    private String string;

    public String getString() { return string; }

    @Override
    public void run() {
        int i = 1;
        i = i/0;
    }

    public static void main(String... args){
        TryException runnable = new TryException();
        Thread thread  = new Thread(runnable);
        thread.setUncaughtExceptionHandler(new CaughtThreadExceptions());
        thread.start();

        System.out.println(runnable.getString());

    }

    class CaughtException implements Thread.UncaughtExceptionHandler{
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(e.getMessage());
        }
    }
}
