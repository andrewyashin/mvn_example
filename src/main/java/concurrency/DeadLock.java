package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by andrew_yashin on 2/13/17.
 */
public class DeadLock {
    public static void main(String[] args) {
        Account account = new Account();
        Account account1 = new Account();

        ExecutorService exec = Executors.newCachedThreadPool();
        Run1 run1 = new Run1(account,account1);
        Run1 run2 = new Run1(account1,account);

        exec.execute(run1);
        exec.execute(run2);

        exec.shutdown();

    }
}

class Run1 implements Runnable{
    Account account, account1;

    public Run1(Account account, Account account1) {
        this.account = account;
        this.account1 = account1;
    }

    @Override
    public void run() {
//        synchronized (account){
//            System.out.println("get synchronized on " + account);
//            try{
//                Thread.sleep(2000);
//            } catch (InterruptedException e){
//                e.printStackTrace();
//            }
//
//            synchronized (account1){
//                System.out.println("get synchronized on " + account1 + account);
//            }
//        }
        if (account1.getLock().tryLock()) {
            try {
                if (account.getLock().tryLock()) {
                    try {
                        System.out.println("Win");
                    } finally {
                        account.getLock().unlock();
                    }
                }
            } finally {
                account1.getLock().unlock();
            }
        }
    }
}

class Account{
    Lock lock = new ReentrantLock();

    public Lock getLock() {
        return lock;
    }
}
