package chap2;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicLong;

public class P60_UnsafeOperation {

    static {
        try {
            Unsafe.getUnsafe().objectFieldOffset(AtomicLong.class.getDeclaredField("value"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("===");
    }
}
