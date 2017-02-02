package collections;

import java.util.*;

/**
 * Created by andrew_yashin on 1/23/17.
 */
public class TryMap<K,V> {
    private Object[][] map;
    private int index,
                length;

    public TryMap(int length){
        map = new Object[length][2];
        index = 0;
        this.length = length;
    }

    public void put(K key, V value){
        if(index > length){
            throw new ArrayIndexOutOfBoundsException();
        }

        map[index++] = new Object[]{ key, value };
    }

    public V get(K key){
        for(int i = 0; i < length; i++){
            if(key.equals(map[i][0])){
                return (V)map[i][1];
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(map);
    }

    public static void main(String... args){
        Map<Integer,String> myMap = new LinkedHashMap<Integer, String>();
        myMap.put(1,"Hi1");
        myMap.put(3,"Hi3");
        myMap.put(5,"Hi5");
        myMap.put(4,"Hi4");
        myMap.put(2,"Hi2");

        System.out.println(myMap);
    }
}
