package juc;

import java.util.concurrent.atomic.AtomicBoolean;

public class CAS {

    private static MyLock myLock = new MyLock();
    private static volatile int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            while (i < 10) {
                if(myLock.acquire()) {
                    System.out.println("acquire success " + Thread.currentThread().getName());
                    i++;
                    if(myLock.release()) {
                    }else {
                        System.out.println("release failure");
                    }
                }else {
                    System.out.println("acquire loss " + Thread.currentThread().getName());
                }
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

class MyLock {
    private AtomicBoolean locked = new AtomicBoolean(false);

    public boolean acquire() {
        return locked.compareAndSet(false, true);
    }

    public boolean release() {
        return locked.compareAndSet(true, false);
    }

}
