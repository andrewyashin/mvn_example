package concurrency;

import inner.classes.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by andrew_yashin on 2/5/17.
 */
public class SynchronizedByObject implements Runnable {
    private static int i = 0;
    String string = "String";

    public void f(){
        synchronized (this){
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + ": f()");
        }
    }

    public void g(){
        synchronized (this){
            System.out.println(Thread.currentThread() + ": g()");
        }
    }

    public void v(){
        synchronized (this){
            System.out.println(Thread.currentThread() + ": v()");
        }
    }

    @Override
    public void run() {
        f();
//        g();
//        v();
    }

    public static void main(String... args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SynchronizedByObject());
        }

        List<Runnable> list = exec.shutdownNow();
        System.out.println(list);

        exec.shutdown();
    }
}

class Task {
    public void onSleep(){
        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Task2 implements Runnable{
    @Override
    public void run() {
        new Task().onSleep();
    }

    public static void main(String... args){
        Thread thread = new Thread(new Task2());
        thread.interrupt();
    }
}


