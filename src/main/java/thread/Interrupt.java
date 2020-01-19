package thread;

import org.omg.PortableInterceptor.INACTIVE;

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
            System.out.println("Worker started.");


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }


            System.out.println("Worker stopped.");  
        }  
    }  
}  