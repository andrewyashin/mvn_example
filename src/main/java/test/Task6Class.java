package test;

import inner.classes.Array;
import inner.classes.Task6;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.*;

/**
 * Created by andrew_yashin on 1/5/17.
 */
public class Task6Class {

    int i;

    private String hello = "Hello";
    private void printMessage(){
        System.out.println("Hello World");
    }

    protected class Test6 implements Task6{
        public void printMessage() {
            Task6Class.this.printMessage();
            System.out.println(hello);
        }
    }

    public static void main(String ... args){
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(
                1,2,3,4,5,6,7
        ));



        arrayCreate();

        Inter.A a = new Inter.A();
        a.a();

        print(fill(new ArrayList<String>()));
        print(fill(new HashSet<String>()));

    }

    public void printDouble(List<? extends Number> list){
        for (Number number: list){
            System.out.println(number.doubleValue());
        }
    }

    public static <T> List<T> printHi(T obj){
        return new ArrayList<T>(Arrays.asList(obj,obj,obj,obj));
    }

    @SuppressWarnings("unchecked")
    public static void arrayCreate(){
        List list = new ArrayList();

        list.add(new Integer(5));
        list.add(new Double(3));
        list.add(4);

        Map<Integer, String> map = new TreeMap<Integer, String>();

        Task6Class task6Class = new Task6Class();
        Task6Class task6Class1 = new Task6Class();

        task6Class.i = 0;
        task6Class1.i = 0;



        Collections.addAll(list, 1,2,3,4,4,5,6,7,8);

        print(list);
    }

    interface Inter {
        void a();
        class A implements Inter{
            public void a() {
                System.out.println("a");
            }
        }
    }

    public static void printList(List list){
        for (Object item: list){
            System.out.println(item);
        }


    }

    @SuppressWarnings("unchecked")
    public static Collection fill(Collection collection){
        collection.add("hello");
        collection.add("hell");
        collection.add("hello");
        collection.add("hell");
        collection.add("hello");
        collection.add("he");
        return collection;
    }

    public static void print(Object object){
        System.out.println(object);
    }

}
