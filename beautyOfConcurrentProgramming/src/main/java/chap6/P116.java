package chap6;

import java.util.concurrent.locks.LockSupport;

/*
    note：
        一次 unpark 调用只能对应一次 park 调用，并且没有顺序关系。
        unpark 调用不会累积调用次数

        park 方法退出时，可能是由于其它线程调用了 unpark 方法，也可能是由于中断、虚假唤醒造成，因此需要在 park 返回后检测条件是否已经获得满足
 */
public class P116 {
    public static void main(String[] args) throws InterruptedException {
        testUnpark();

        Thread t = new Thread(() -> {
            System.out.println("child thread begin park.");

            LockSupport.park();

            System.out.println("child thread end park.");
        });

        t.start();

        Thread.sleep(100);

        System.out.println("main thread begin unpark.");

        LockSupport.unpark(t);
//        t.interrupt();
    }

    private static void testUnpark() {
        System.out.println("begin park");

        LockSupport.unpark(Thread.currentThread());
        LockSupport.unpark(Thread.currentThread());

        LockSupport.park();
//        LockSupport.park(); // 一次 unpark 只能对应一次 park

        System.out.println("end park");
    }
}
