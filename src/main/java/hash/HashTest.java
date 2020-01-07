package hash;

public class HashTest {

    public static void main(String[] args) {
        System.out.println(">>>>>>" + (new Integer(1)).hashCode());


        System.out.println(HashTest.hash(1));
        System.out.println(HashTest.hash(2));
        System.out.println(HashTest.hash(3));
        System.out.println(HashTest.hash(4));
        System.out.println(HashTest.hash(5));

    }

    static final int hash(Object key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ h >>> 16;
    }
}
