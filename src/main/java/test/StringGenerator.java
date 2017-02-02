package test;

import java.util.*;

/**
 * Created by andrew_yashin on 1/7/17.
 */
public class StringGenerator {
    private static String[] names = {"Bruce", "John", "Andrew", "Michel"};
    private Random random = new Random();
    private int size;

    public StringGenerator(int size){
        this.size = size;
    }
    public Collection<String> getRandomCollection(Collection<String> collection){
        for (int i = 0; i < size; i++){
            collection.add(names[random.nextInt(names.length)]);
        }

        return collection;
    }

    public static Collection<String> getRandomCollection(int size){
        Random random = new Random();
        ArrayList<String> list = new ArrayList<String>(size);
        for (int i = 0 ; i < size; i ++){
            list.add(names[random.nextInt(names.length)]);
        }

        return list;
    }

    public static void main(String... args){
        StringGenerator stringGenerator = new StringGenerator(10);
        print(stringGenerator.getRandomCollection(new ArrayList<String>()));
        print(stringGenerator.getRandomCollection(new LinkedList<String>()));
        print(stringGenerator.getRandomCollection(new HashSet<String>()));
        print(stringGenerator.getRandomCollection(new LinkedHashSet<String>()));

        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        ListIterator<Integer> iterator = list.listIterator(list.size());
        List<Integer> reverseList = new ArrayList<Integer>();

        while (iterator.hasPrevious())
            reverseList.add(iterator.previous());

        print(list);
        print(reverseList);
    }

    public static void print(Object object){
        System.out.println(object);
    }
}
