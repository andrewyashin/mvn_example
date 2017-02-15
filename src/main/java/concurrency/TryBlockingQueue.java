package concurrency;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by andrew_yashin on 2/14/17.
 */
public class TryBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1000);
        ExecutorService exec = Executors.newCachedThreadPool();

        exec.execute(new Add(queue));
        exec.execute(new Get(queue));

        exec.shutdown();
    }
}

class Add implements Runnable{
    private BlockingQueue<Integer> queue;
    private Random random = new Random();

    public Add(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try{
                queue.put(random.nextInt());
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Get implements Runnable{
    private BlockingQueue<Integer> queue;

    public Get(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println("get from BlockingQueue = " + queue.take());
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
