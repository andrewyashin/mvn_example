package concurrency;

import com.kpi.ipk.InterAbstr;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by andrew_yashin on 2/2/17.
 */
public class Task6 implements Runnable {
    private static int taskCount = 0;
    private final int numberTask = ++taskCount;

    public void run() {
        Random rand = new Random();
        long timeSleep = Integer.toUnsignedLong(rand.nextInt(10));
        try {
            TimeUnit.SECONDS.sleep(timeSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("#" + numberTask + " : Waiting time - " + timeSleep);
    }
}
