package jvm;

import org.omg.CORBA.MARSHAL;
import org.openjdk.jol.info.ClassLayout;
import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public class Main {
//    private String name = "yuck";
//    private  int age = 24;

    static Object o1 = new Object();
    static Object o2 = new Object();

    public static void main(String[] args) throws Throwable {
        Main main = new Main();
        new Thread(() ->{
            try {
                main.deadLock1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() ->{
            try {
                main.deadLock2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    synchronized void lock() {
        System.out.println("enter lock");
        System.out.println(ClassLayout.parseInstance(this).toPrintable());
        String realHashCode = Integer.toHexString(this.hashCode());
        System.out.println(String.format("realHashCode : 0x%s\n", realHashCode));
    }

    void deadLock1() throws InterruptedException {
        synchronized (o1) {
            System.out.println("enter deadLock1");
            Thread.sleep(10000);
            deadLock2();
        }
    }

    void deadLock2() throws InterruptedException {
        synchronized (o2) {
            System.out.println("enter deadLock2");
            Thread.sleep(10000);
            deadLock1();
        }
    }
}