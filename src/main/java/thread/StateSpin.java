package thread;

import java.util.concurrent.atomic.AtomicInteger;

// 三个线程依次输出123456789
public class StateSpin {
    private final static int limit = 9;
    private volatile static int init = 1;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() ->{
            while (init <= limit) {
                while (init % 3 == 1) {
                    System.out.println(Thread.currentThread().getName()+ ">>>" +init);
                    init++;
                }
//                System.out.println("T1 inner " + init);
            }
            System.out.println("T1 end");
        });
        t1.setName("T1");

        Thread t2 = new Thread(() ->{
            while (init <= limit) {
                while (init % 3 == 2) {
                    System.out.println(Thread.currentThread().getName()+ ">>>" + init);
                    init++;
                }
//                System.out.println("T2 inner " + init);
            }
            System.out.println("T2 end");
        });
        t2.setName("T2");

        Thread t3 = new Thread(() ->{
            while (init <= limit) {
                while (init % 3 == 0) {
                    System.out.println(Thread.currentThread().getName()+ ">>>" + init);
                    init++;
                }
//                System.out.println("T3 inner " + init);
            }
            System.out.println("T3 end");
        });
        t3.setName("T3");

        t1.start();
        t2.start();
        t3.start();
    }

    /*
    new -> runnable -> wait -> time-wait -> block -> terminate
    * */

}
