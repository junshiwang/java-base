package thread;

public class ThreadStateTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {

            }
        });


        t1.start();;
        t1.join();
        new Thread(() -> {
            try {
                Thread.sleep(100);
                System.out.println("1111 " + t1.getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println(t1.getState());
        Thread.sleep(10);
        System.out.println(t1.getState());
    }
}
