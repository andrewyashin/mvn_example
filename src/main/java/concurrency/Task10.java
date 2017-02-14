package concurrency;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by andrew_yashin on 2/3/17.
 */
public class Task10 {
    public Future<Integer> runTask(final int countNumbers){
        ExecutorService executorService =
                Executors.newCachedThreadPool();

        return executorService.submit(
                new Callable<Integer>() {
                    private ArrayList<Integer> list = new ArrayList<Integer>();

                    public Integer call() throws Exception {
                        return new MakeFibonacci(countNumbers).call();
                    }
                }
        );
    }

    public static void main(String... args) throws Exception{
        System.out.println(new Task10().runTask(10).get());
    }
}
