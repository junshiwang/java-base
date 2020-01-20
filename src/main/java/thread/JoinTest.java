package thread;

public class JoinTest {

    public static void main(String[] args) throws InterruptedException {

        Thread  t1 = new Thread(() -> {
            System.out.println("t1 start");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 end");
        });

        t1.start();
        t1.join();
        System.out.println("main thread end");
    }
}
