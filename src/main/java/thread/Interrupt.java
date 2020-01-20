package thread;

public class Interrupt {
    public static void main(String[] args) throws Exception {  
        Thread t = new Thread(new Worker());  
        t.start();
          
        Thread.sleep(1);
        t.interrupt();  
          
        System.out.println("Main thread stopped.");  
    }  
      
    public static class Worker implements Runnable {
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("working");
            }
            System.out.println(Thread.interrupted());
            System.out.println(Thread.currentThread().isInterrupted());
        }  
    }  
}  