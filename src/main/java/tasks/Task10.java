package tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by andrew_yashin on 1/17/17.
 */
public class Task10 {
    static String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma",
            "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };

    static int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };

    public static void main(String... args){
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();

        for(int i = 0; i < times.length; i++){
            map.put(times[i], names[i]);
        }

        System.out.println(map.get(map.firstKey()) + " = " + map.firstKey());
    }
}
