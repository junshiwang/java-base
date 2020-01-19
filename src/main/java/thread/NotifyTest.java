package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class NotifyTest {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static volatile boolean stop = true;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() ->{
            lock.lock();
            while (stop) {
                try {
                    System.out.println("1-stop");
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("1-end");
            lock.unlock();
        }).start();

        new Thread(() ->{
            lock.lock();
            while (stop) {
                try {
                    System.out.println("2-stop");
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("2-end");
            lock.unlock();
        }).start();

         Thread thread3 = new Thread(() ->{
             try {
                 lock.lock();
                 System.out.println("3-start");
                 stop = false;
                 condition.signalAll();
             }finally {
                 System.out.println("3-end");
                 lock.unlock();
             }
        });
         Thread.sleep(100);
         thread3.start();
    }
}
