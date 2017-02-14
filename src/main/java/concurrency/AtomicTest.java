package concurrency;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by andrew_yashin on 2/12/17.
 */
public class AtomicTest implements Runnable{
    private AtomicInteger i = new AtomicInteger(0);
    public synchronized int getI() { return i.get(); }
    public synchronized void increment() {
        i.addAndGet(1);
        i.addAndGet(1); }

    @Override
    public void run() {
        while (true){
            increment();
        }
    }

    public static void main(String[] args) {
        AtomicTest atomicTest = new AtomicTest();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(atomicTest);




        InterruptThread thread = new InterruptThread();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++){
            executorService.execute(thread);
        }
        executorService.shutdown();
    }
}

class InterruptThread implements Runnable{
    private double d = 0;
    @Override
    public void run() {
        print();
    }

    public synchronized void print(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + " before wait()");
        try {
            wait(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread() + " after wait()");
    }
}

