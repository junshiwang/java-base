package juc;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest1 {

    private static Thread mainThread;

    public static void main(String[] args) {

        new ThreadA("t1").start();
        // 获取主线程
        mainThread = Thread.currentThread();

        System.out.println(Thread.currentThread().getName()+" start ta");
        System.out.println(Thread.currentThread().getName()+" block");
        // 主线程阻塞
        LockSupport.park();
        System.out.println(mainThread.isInterrupted());
        System.out.println(Thread.currentThread().getName()+" continue");
    }

    static class ThreadA extends Thread{

        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            try {
                Thread.sleep(100);
                mainThread.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}