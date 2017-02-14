package concurrency;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
 * Created by andrew_yashin on 2/3/17.
 */
public abstract class IntGenerator {
    private boolean canceled = false;

    abstract int next();

    public void cancel(){
        canceled = true;
    }

    public boolean isCanceled(){
        return canceled;
    }

}

class EvenGenerator extends IntGenerator implements Runnable {
    private static int number = 0;
    @Override
    int next() {
            ++number;
            ++number;
            return number;

    }

    public void run(){
        if(next() % 2 != 0){
            System.out.println("Not even");
        }
    }

    public static void main(String... args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 500; i ++){
            exec.execute(new EvenGenerator());

        }

        exec.shutdown();

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,8,7));

        list.forEach(integer -> System.out.println(integer));

        try{
            InetAddress inet4 = Inet4Address.getByAddress(new byte[]{8,8,8,8});
            System.out.println(inet4.getHostName() );
        } catch (UnknownHostException e){
            e.printStackTrace();
        }
    }
}
