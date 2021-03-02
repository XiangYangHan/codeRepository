package chap6;

import java.util.concurrent.locks.LockSupport;

public class P119 {

    public static void main(String[] args) {

        P119 p119 = new P119();
        p119.testPark();

    }

    public void testPark() {
        LockSupport.park(this);
        LockSupport.park();
//        LockSupport.parkNanos(10000);
    }

}
