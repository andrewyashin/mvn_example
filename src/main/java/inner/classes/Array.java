package inner.classes;

/**
 * Created by andrew_yashin on 1/5/17.
 */
interface Iterator{
    boolean hasNext();
    Object current();
    void next();
    Array getOuter();
}

public class Array {
    private int length = 10;
    private Object[] array;
    private int next = 0;

    Array(){
        array = new Object[length];
    }

    public void add(Object item){
        if (next < array.length){
            array[next++] = item;
        } else {
            length += 1;
            Object[] objects = new Object[length];
            for (int i = 0; i < length - 1; i++){
                objects[i] = array[i];
            }

            array = objects;
            array[next++] = item;
        }
    }

    public Object get(int i) throws ArrayIndexOutOfBoundsException {
        if (i > array.length) throw new ArrayIndexOutOfBoundsException("There is no " + i + " element");
        return array[i];
    }

    public String toString(){
        return array.toString();
    }
    private class ArrayIterator implements Iterator{
        private int i = 0;

        public void next() {
            if (i < array.length) i++;
        }

        public Object current() {
            return array[i];
        }

        public boolean hasNext() {
            return i != array.length;
        }

        public Array getOuter(){
            return Array.this;
        }
    }

    public Iterator getIterator(){
        return new ArrayIterator();
    }

    public static void main(String ... args){
        Array array = new Array();
        for (int i = 0; i < 40; i++){
            array.add(i+3);
        }

        System.out.println(array.get(400));

        Iterator iterator = array.getIterator();

        while(iterator.hasNext()){
            System.out.println(iterator.current());
            iterator.next();
        }

    }
}
