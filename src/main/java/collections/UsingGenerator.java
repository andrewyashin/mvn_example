package collections;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import test.StringGenerator;

import java.util.*;

/**
 * Created by andrew_yashin on 1/19/17.
 */
public class UsingGenerator {


    public static void main(String... args){
        Set<String> strings = new LinkedHashSet<String>();
        SortedSet<Integer> set = new TreeSet<Integer>();
        for (int i = 1; i < 11; i++){
            set.add(i);
        }

        System.out.println(getNextElement(set,3));
        System.out.println(getPrevElements(set,5));

        HashMap<Integer, String> m = new LinkedHashMap<Integer, String>();
        m.put(5,"a");
        m.put(4,"b");
        m.put(3,"c");
        m.put(2,"d");
        m.put(1,"e");
        m.put(0,"f");
        System.out.println(m);


        MySortedSet<Integer> sortedSet = new MySortedSet<Integer>(Arrays.asList(1,2,3,4,5));
        System.out.println(sortedSet);
        sortedSet.add(1);
        System.out.println(sortedSet);
        sortedSet.remove(5);
        System.out.println(sortedSet);


    }

    public static Integer getNextElement(Set<Integer> set, Integer elem){
        boolean ind = false;
        for (Integer integer: set){
            if(ind) return integer;
            if(integer.equals(elem)) ind = true;
        }

        return 0;
    }

    public static Set<Integer> getPrevElements(Set<Integer> set, Integer elem){
        Set<Integer> set1 = new HashSet<Integer>();
        for (Integer integer: set){
            set1.add(integer);
            if(integer.equals(elem)) return set1;
        }

        return null;
    }

    static class MySortedSet<T> implements SortedSet<T>{
        private LinkedList<T> linkedList;

        public MySortedSet(){
            linkedList = new LinkedList<T>();
        }
        public MySortedSet(Collection<T> collection){
            linkedList = new LinkedList<T>(collection);
        }

        @Nullable
        public Comparator<? super T> comparator() {
            return null;
        }

        @NotNull
        public SortedSet<T> subSet(T fromElement, T toElement) {
            int fromIndex = linkedList.indexOf(fromElement);
            int toIndex = linkedList.indexOf(toElement);
            return new TreeSet<T>(linkedList.subList(fromIndex, toIndex));
        }

        @NotNull
        public SortedSet<T> headSet(T toElement) {
            return new TreeSet<T>(linkedList.subList(linkedList.indexOf(linkedList.getFirst()),
                    linkedList.indexOf(toElement)));
        }

        @NotNull
        public SortedSet<T> tailSet(T fromElement) {
            return new TreeSet<T>(linkedList.subList(linkedList.indexOf(fromElement),
                    linkedList.indexOf(linkedList.getLast())));
        }

        public T first() {
            return linkedList.getFirst();
        }

        public T last() {
            return linkedList.getLast();
        }

        public int size() {
            return linkedList.size();
        }

        public boolean isEmpty() {
            return linkedList.isEmpty();
        }

        public boolean contains(Object o) {
            return linkedList.contains(o);
        }

        @NotNull
        public Iterator<T> iterator() {
            return linkedList.iterator();
        }

        @NotNull
        public Object[] toArray() {
            return linkedList.toArray();
        }

        @NotNull
        public <T1> T1[] toArray(@NotNull T1[] a) {
            return linkedList.toArray(a);
        }

        public boolean add(T t) {
            if(!linkedList.contains(t))
                return linkedList.add(t);
            else return false;
        }

        public boolean remove(Object o) {
            return linkedList.remove(o);
        }

        public boolean containsAll(@NotNull Collection<?> c) {
            return linkedList.containsAll(c);
        }

        public boolean addAll(@NotNull Collection<? extends T> c) {
            return linkedList.addAll(c);
        }

        public boolean retainAll(@NotNull Collection<?> c) {
            return linkedList.retainAll(c);
        }

        public boolean removeAll(@NotNull Collection<?> c) {
            return linkedList.removeAll(c);
        }

        public void clear() {
            linkedList.clear();
        }

        @Override
        public String toString() {
            return linkedList.toString();
        }
    }
}
