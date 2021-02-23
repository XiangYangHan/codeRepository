package chap6;

import sun.reflect.Reflection;

import java.util.concurrent.locks.LockSupport;

public class P115 {

    public static void main(String[] args) {
        System.out.println(Reflection.getCallerClass(0));

        System.out.println("begin park!");

        LockSupport.park();

        System.out.println("end park!");
    }
}
