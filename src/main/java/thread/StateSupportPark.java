package thread;


import java.util.concurrent.locks.LockSupport;

public class StateSupportPark {
    private final static int limit = 8;
    private volatile static int init = 1;
    private static Thread t1;
    private static Thread t2;

    // 线程依次输出1234...
    public static void main(String[] args) {


        t1= new Thread(() ->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (init <= limit) {
                System.out.println("t2 state>>>>" + t2.getState());
                System.out.println("t1>>>" + (init++));
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });

        t2= new Thread(() ->{
            while (init <= limit) {
                LockSupport.park();
                System.out.println("t1 state>>>>" + t1.getState());
                System.out.println("t2>>>>>>>>>>>>>>>>>>>" + (init++));
                LockSupport.unpark(t1);
            }
        });

        t1.start();
        t2.start();
    }
}
