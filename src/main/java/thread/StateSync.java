package thread;

public class StateSync {

    private final static int limit = 9;
    private volatile static int init = 1;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() ->{
            while (init <= limit) {
                synchronized (StateSync.class) {
                    if (init % 3 == 1) {
                        System.out.println(Thread.currentThread().getName()+ ">>>" +init);
                        init++;
                        try {
                            StateSync.class.notifyAll();
                            StateSync.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    StateSync.class.notifyAll();
                }
            }
            System.out.println("T1 end");
        });
        t1.setName("T1");

        Thread t2 = new Thread(() ->{
            while (init <= limit) {
                synchronized (StateSync.class) {
                    if (init % 3 == 2) {
                        System.out.println(Thread.currentThread().getName()+ ">>>" + init);
                        init++;
                        try {
                            StateSync.class.notifyAll();
                            StateSync.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    StateSync.class.notifyAll();
                }
            }
            System.out.println("T2 end");
        });
        t2.setName("T2");

        Thread t3 = new Thread(() ->{
            while (init <= limit) {
                synchronized (StateSync.class) {
                    if (init % 3 == 0) {
                        System.out.println(Thread.currentThread().getName()+ ">>>" + init);
                        init++;
                        try {
                            StateSync.class.notifyAll();
                            StateSync.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    StateSync.class.notifyAll();
                }
            }
            System.out.println("T3 end");
        });
        t3.setName("T3");

        t1.start();
        t2.start();
        t3.start();
    }
}
