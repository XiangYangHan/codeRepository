package chap2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class P61_TestUnsafe {

    static final Unsafe unsafe;

    static final long stateOffset;

    private volatile long state;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);

            stateOffset = unsafe.objectFieldOffset(P61_TestUnsafe.class.getDeclaredField("stateOffset"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        P61_TestUnsafe testUnsafe = new P61_TestUnsafe();

        boolean swapLong = unsafe.compareAndSwapLong(testUnsafe, stateOffset, 0, 1);
        System.out.println(swapLong);
    }
}
