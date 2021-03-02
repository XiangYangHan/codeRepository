package chap6;

import java.util.concurrent.locks.LockSupport;

public class P118 {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("child thread begin park.");

            while (!Thread.currentThread().isInterrupted()) {
                LockSupport.park();
                System.out.println("exit park.");
            }

            System.out.println("child thread end park.");
        });

        t.start();

        Thread.sleep(1000);
        System.out.println("main thread begin unpark.");
        LockSupport.unpark(t);
        Thread.sleep(100);
        LockSupport.unpark(t);
        Thread.sleep(100);
        LockSupport.unpark(t);
        Thread.sleep(100);

        System.out.println("main thread begin interrupt t.");
        t.interrupt();
    }

}
