package concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by andrew_yashin on 2/3/17.
 */
public class Task11 implements Runnable {
    private static int i = 1;
    private static String string = "null";

    public void set(){
        string += i;
        i++;

        get();
    }

    public void get(){
        System.out.println("String = " + string + " i = " + i);
    }

    @Override
    public void run() {
        set();
    }


    public static void main(String... args){
        ExecutorService execc= Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++){
            execc.execute(new Task11());
        }
        execc.shutdown();



    }

    public interface In{
        int a =5;
    }
}

class A {
    private int i;
    private int j;

    public A(int i, int j){
        this.i = i;
        this.j = j;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        A a = (A) o;

        if (i != a.i) return false;
        return j == a.j;
    }

    @Override
    public int hashCode() {
        int result = i;
        result = 31 * result + j;
        return result;
    }
}

