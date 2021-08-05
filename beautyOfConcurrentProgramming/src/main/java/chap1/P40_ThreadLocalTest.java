package chap1;

import java.util.Date;

public class P40_ThreadLocalTest {

    static void print(String string) {
        System.out.println(string + ":" + localVariable.get());
        localVariable.remove();
    }

    static ThreadLocal<String> localVariable = new ThreadLocal<>();


    public static void main(String[] args) {
        System.out.println(new Date());
        System.out.println(new Date(System.currentTimeMillis()));
        System.out.println(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000));


        Thread t1 = new Thread(() -> {
            localVariable.set("t1 local variable.");

            print("t1");

            System.out.println("t1 after remove: " + localVariable.get());
        });
        Thread t2 = new Thread(() -> {
            localVariable.set("t2 local variable.");

            print("t2");

            System.out.println("t2 after remove: " + localVariable.get());
        });

        t1.start();
        t2.start();
    }
}
