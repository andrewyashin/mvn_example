package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by andrew_yashin on 2/13/17.
 */
public class Task21 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Runnable1 run1 = new Runnable1();
        Runnable2 run2 = new Runnable2(run1);

        exec.execute(run1);
        exec.execute(run2);

        try{
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("get out of main()");
        exec.shutdownNow();
        exec.shutdown();
    }
}

class Runnable1 implements Runnable{


    @Override
    public void run() {
        synchronized (this) {
            try {
                while (!Thread.interrupted()) {
                    System.out.println("Runnable 1 before wait");
                    wait();
                    System.out.println("Runnable 1 after wait");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Get out of Runnable 1");
        }
    }
}

class Runnable2 implements Runnable{
    Runnable runnable;
    Runnable2(Runnable run) { runnable = run; }

    @Override
    public void run() {
        synchronized (runnable) {
            try {
                while (!Thread.interrupted()) {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("Runnable notifyAll()");
                    runnable.notifyAll();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("getOut of Runnable 2");
        }
    }
}
