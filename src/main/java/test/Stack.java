package test;

import inner.classes.Array;

import java.lang.ref.Reference;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created by andrew_yashin on 1/8/17.
 */
public class Stack<T> {
    private LinkedList<T> linkedList;

    public Stack() {
        this.linkedList = new LinkedList<T>();
    }

    public void push(T t) { linkedList.addFirst(t); }
    public T peek() { return linkedList.getFirst(); }
    public T pop() { return linkedList.removeFirst(); }
    public String toString() { return linkedList.toString(); }
    public boolean isEmpty() { return linkedList.isEmpty(); }

    public static void main(String... args){
        Stack<Character> stack = new Stack<Character>();
        String string = "+U+n+c---+e+r+t---+a-+i-+n";

        boolean flag = false;
        for(Character character: string.toCharArray()){
            if (character == '+') {
                flag = true;
                continue;
            } else if (character == '-'){
                flag = false;
            }



            if (flag) {
                stack.push(character);
            } else System.out.println(stack.pop());

        }


        TreeSet<Person> treeSet = new TreeSet<Person>();

        String string1 = "Andrew";
        String string2 = "werdnA";

        System.out.println(string1.hashCode() == string2.hashCode());


    }
}


class Person implements Comparable<Person>{
    private int i;

    public Person(int i) {
        this.i = i;
    }

    public int compareTo(Person o) {
        if (this.i > o.i) return 1;
        else if (this.i == o.i) return 0;
        else return -1;
    }

}


