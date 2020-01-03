package juc;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private static volatile int i = 0;
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            while (i < 10) {
                reentrantLock.lock();
                i++;
                reentrantLock.unlock();
            }
        };
        new Thread(task, "t0").start();
        new Thread(task, "t1").start();
        new Thread(task, "t2").start();
        new Thread(task, "t3").start();
        new Thread(task, "t4").start();
        new Thread(task, "t5").start();
        new Thread(task, "t6").start();
        new Thread(task, "t7").start();
        new Thread(task, "t8").start();
        new Thread(task, "t9").start();

        Thread.sleep(1000L);
        System.out.println(i);
    }
}
