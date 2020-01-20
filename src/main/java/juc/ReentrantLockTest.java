package juc;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private static volatile int i = 0;
    static ReentrantLock reentrantLock = new ReentrantLock(true);

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            reentrantLock.lock();
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
        };
        new Thread(() -> {
            reentrantLock.lock();
            i++;
            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();
        }).start();
        new Thread(task, "t1").start();

        System.out.println(i);
    }
}
