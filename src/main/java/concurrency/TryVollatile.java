package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by andrew_yashin on 2/6/17.
 */
public class TryVollatile {

    public static void main(String... args){
        Data data = new Data(0,0);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Thread1(data));
        exec.execute(new Thread2(data));
        exec.shutdown();
    }
}

class Thread1 implements Runnable{
    private Data data;

    public Thread1(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for(int i = 2; i < 20000; i++) {
            data.setA(i);
            data.setB(i+1);

            System.out.println();
        }
    }
}


class Thread2 implements Runnable{
    private Data data;

    public Thread2(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println(data.getA());
        System.out.println(data.getB());
    }
}

class Data {
    int a;
    int b;

    public Data(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
