package tasks;

import generics.Task20;
import inner.classes.Array;

import java.util.*;

/**
 * Created by andrew_yashin on 1/17/17.
 */
public class Task10{
    static String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma",
            "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };

    static int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };

    public static void main(String... args){
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();

        for(int i = 0; i < times.length; i++){
            map.put(times[i], names[i]);
        }

        System.out.println(map.get(map.firstKey()) + " = " + map.firstKey());

        int[] a = {1,2,3,4};
        change(a);
        System.out.println(Arrays.toString(a));

        System.out.println(Arrays.toString(getTask10(4)));
        System.out.println(Arrays.deepToString(getArray(4)));


    }

    static void change(int[] a){
        a[0] = 2;
    }

    static Task10[] getTask10(int size){
        Task10[] task10s = new Task10[size];
        for (int i = 0; i < size; i++){
            task10s[i] = new Task10();
        }

        return task10s;
    }

    static double[][][] getArray(int size){
        Random random = new Random();
        double[][][] array = new double[size][size][size];
//        for (int i = 0; i < size; i++){
//            for (int j = 0; j < size; j++) {
//                for (int k = 0; k < size; k++) {
//                    array[i][j][k] = random.nextDouble();
//                }
//            }
//        }

        return array;
    }
}
