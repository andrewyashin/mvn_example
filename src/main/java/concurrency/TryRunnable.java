package concurrency;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

/**
 * Created by andrew_yashin on 2/2/17.
 */
public class TryRunnable implements Runnable {

    private static int taskCount = 0;
    private final int taskNumber = ++taskCount;
    private int count = 10;

    public void run() {
        while(count-- > 0){
            System.out.println(" #" + taskNumber + " : Hello");
        }

    }


    public static void main(String... args){
        Thread thread = new Thread(new MyThread());
        thread.setDaemon(true);
        thread.start();


        MyAbstClass.hi();







        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new TryRunnable());
        executor.execute(new TryRunnable());
        executor.execute(new TryRunnable());
        executor.execute(new TryRunnable());
        executor.execute(new TryRunnable());
        executor.shutdown();

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new MakeFibonachi(10));
        exec.execute(new MakeFibonachi(14));
        exec.execute(new MakeFibonachi(15));
        exec.execute(new MakeFibonachi(11));
        exec.shutdown();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Task6());
        executorService.execute(new Task6());
        executorService.execute(new Task6());
        executorService.execute(new Task6());
        executorService.execute(new Task6());
        executorService.execute(new Task6());
        executorService.shutdown();

    }
}

class CaughtThreadExceptions implements Thread.UncaughtExceptionHandler{
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(e.getMessage());
    }
}

class MyThreadFactory implements ThreadFactory{
    public Thread newThread(@NotNull Runnable r) {
        Thread task1 = new Thread(r);
        task1.setUncaughtExceptionHandler(new CaughtThreadExceptions());
        return task1;
    }
}

class MyThread implements Runnable{
    public void run(){
        int i = 0;
        while (true){
            System.out.println(i++);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

interface MyInterface {
    default void hi(){
        System.out.println("default");
    }
}

abstract class MyAbstClass{
    static void hi(){
        System.out.println("hi static void");
    }
}

