package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by andrew_yashin on 2/14/17.
 */
class Meal{
    private final int orderNumber;

    public Meal(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "Meal #" + orderNumber;
    }
}

class WaitPerson implements Runnable{
    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try{
           while (restaurant.count != 0) {
                if(restaurant.lock.tryLock()){
                    restaurant.lock.lock();
                    try {
                        while (restaurant.meal == null) {
                            restaurant.condition.await();
                        }

                        System.out.println("Person got his order... #" + restaurant.meal);
                        restaurant.meal = null;
                        restaurant.condition.signalAll();
                    } finally {
                        restaurant.lock.unlock();
                    }
                }
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class WaitCheff implements Runnable{
    private Restaurant restaurant;

    public WaitCheff(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            if(restaurant.lock.tryLock()){
                restaurant.lock.lock();
                try {
                    while (restaurant.count > 0) {
                        while (restaurant.meal != null) {
                            restaurant.condition.await();
                        }

                        System.out.println("Cheff Doing Meal...");
                        restaurant.meal = new Meal(10 - restaurant.count);
                        restaurant.count--;
                        TimeUnit.SECONDS.sleep(0);
                        restaurant.condition.signalAll();
                    }
                }finally {
                    restaurant.lock.unlock();
                }


                System.out.println("Out of MEAL!!!\nGOODBYE!!!");
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class Restaurant {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    int count = 10;
    Meal meal = null;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitCheff cheff = new WaitCheff(this);
    WaitPerson person = new WaitPerson(this);

    public Restaurant() {
        exec.execute(cheff);
        exec.execute(person);
        exec.shutdown();
    }

    public static void main(String... args){
        new Restaurant();
    }
}
