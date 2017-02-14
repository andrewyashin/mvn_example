package concurrency;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * Created by andrew_yashin on 2/2/17.
 */
public class MakeFibonacci implements Callable<Integer> {

    private static int countTask = 0;
    private final int numberTask = ++countTask;
    private final int countNumbers;
    private ArrayList<Integer> list;

    public MakeFibonacci(int countNumbers){
        this.countNumbers = countNumbers;
        list = new ArrayList<Integer>(countNumbers);
    }

    public Integer call() throws Exception {
        list.add(1);
        list.add(1);
        int index = 2;
        while (list.size() < countNumbers) {
            list.add(list.get(index - 1) + list.get(index - 2));
            index++;
        }

        int sum = 0;

        for(Integer number: list){
            sum+=number;
        }

        System.out.println(list);
        return sum;
    }
}
