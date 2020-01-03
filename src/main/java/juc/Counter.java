package juc;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger count = new AtomicInteger();
    public int getCount(){
        return count.get();
    }
    public void increase(){
        count.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        new Thread(() ->{
            counter.increase();
        }, "t0").start();
        new Thread(() ->{
            counter.increase();
        }, "t1").start();
        new Thread(() ->{
            counter.increase();
        }, "t2").start();
        new Thread(() ->{
            counter.increase();
        }, "t3").start();
        Thread.sleep(1000L);
        System.out.println(counter.getCount());
    }
}