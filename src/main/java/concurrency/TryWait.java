package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by andrew_yashin on 2/13/17.
 */
public class TryWait {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Dish dish = new Dish();

        executorService.execute(new Wash(dish));
        executorService.execute(new Dry(dish));

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdownNow();


    }
}

class Dish {
    private boolean washOn = false;

    public synchronized void washDish(){
        if(washOn == false) {
            System.out.println("Wash ");
            washOn = true;
            notifyAll();
        }
    }

    public synchronized void dryDish(){
        if(washOn) {
            System.out.println("Dry ");
            washOn = false;
            notifyAll();
        }
    }

    public synchronized void waitingForWashing()
            throws InterruptedException{
        if (washOn) wait();
    }

    public synchronized void waitingForDry()
        throws InterruptedException{
        if (!washOn) wait();
    }
}

class Wash implements Runnable{
    Dish dish;
    public Wash(Dish d){ dish = d;}
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(10);
                dish.washDish();
                dish.waitingForDry();
            }
        } catch (InterruptedException e) {
            System.out.println("Exit from Dry InterruptException");
        }
        System.out.println("End Wash");
    }
}

class Dry implements Runnable{
    Dish dish;
    public Dry(Dish d){ dish = d;}
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(10);
                dish.dryDish();
                dish.waitingForWashing();
            }
        } catch (InterruptedException e) {
            System.out.println("Exit from Dry InterruptException");
        }
        System.out.println("End Dry");
    }
}
