package concurrency;

import inner.classes.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andrew_yashin on 2/2/17.
 */
public class MakeFibonachi implements Runnable {
    private static int taskNumber = 0;
    private final int taskCount = ++taskNumber;
    private int countFibonacci;

    private ArrayList<Integer> list;


    public MakeFibonachi(int count){
        this.countFibonacci = count;
        this.list = new ArrayList<Integer>();
    }
    public void run() {
//        list.addAll(Arrays.asList(1,2,3,5));
//        int number = 7;
//        while (list.size() < countFibonacci){
//            if((number % 2 != 0) && (number % 3 != 0) && (number % 5 != 0)){
//                list.add(number);
//            }
//            number++;
//        }
        list.add(1);
        list.add(1);
        int index = 2;

        while (list.size() < countFibonacci){
            list.add(list.get(index - 1) + list.get(index - 2));
            index++;
        }

        System.out.println("#" + taskCount + " --- " + list);
    }
}
