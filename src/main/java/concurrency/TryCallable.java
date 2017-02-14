package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by andrew_yashin on 2/2/17.
 */
public class TryCallable implements Callable<String> {
    private final int i;

    public TryCallable(int i){
        this.i = i;
    }
    public String call() throws Exception {
        return "Task #" + i;
    }

    public static void main(String... args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();


        ArrayList<Future<String>> list =
                new ArrayList<Future<String>>();

        for(int i = 0; i < 5; i++){
            list.add(exec.submit(new TryCallable(i)));
        }

        for(Future<String> item: list){
            System.out.println(item.get());
        }

        List<Future<Integer>> list1 =
                new ArrayList<Future<Integer>>();

        Random random = new Random();
        for(int i = 0; i < 5; i++){
            list1.add(exec.submit(new MakeFibonacci(i + 5)));
        }

        for(Future<Integer> item: list1){
            System.out.println(" Sum : " + item.get());
        }

    }
}
