package concurrency;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by andrew_yashin on 2/13/17.
 */
public class Task22 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        SimpleClass simpleClass = new SimpleClass(1);

        executorService.execute(new Runnable3(simpleClass));
        executorService.execute(new Runnable4(simpleClass));
        executorService.execute(new Runnable4(simpleClass));
        executorService.execute(new Runnable4(simpleClass));
        executorService.execute(new Runnable4(simpleClass));

        executorService.shutdown();

    }
}

class SimpleClass {
    private int i;
    private volatile boolean isWaiting = true;

    public SimpleClass(int i) {
        this.i = i;
    }

    public boolean isWaiting() {
        return isWaiting;
    }

    public void setWaiting(boolean waiting) {
        isWaiting = waiting;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}

class Runnable3 implements Runnable{
    private SimpleClass simpleClass;

    public Runnable3(SimpleClass simpleClass) {
        this.simpleClass = simpleClass;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            synchronized (simpleClass) {
                try {
                    if (!simpleClass.isWaiting()) {
                        System.out.println("Doing some job.... ");
                        TimeUnit.SECONDS.sleep(2);
                        simpleClass.setWaiting(true);
                        simpleClass.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Runnable4 implements Runnable{
    private SimpleClass simpleClass;

    public Runnable4(SimpleClass simpleClass) {
        this.simpleClass = simpleClass;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            synchronized (simpleClass) {
                try {
                    if (simpleClass.isWaiting()) {
                        System.out.println("Waiting.... ");
                        TimeUnit.SECONDS.sleep(2);
                        simpleClass.setWaiting(false);
                        simpleClass.wait();

                        System.out.println("After Waiting command");

                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
