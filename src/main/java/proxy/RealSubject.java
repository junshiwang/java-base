package proxy;

public class RealSubject implements Subject {

    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str) {
        rent();
        System.out.println("hello: " + str);
    }

    public void say(String msg) {
        System.out.println("say:" + msg);
    }
}