package chap5;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class P113 {

    static volatile List<String> arrayList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        arrayList.add("hello");
        arrayList.add("world.");
        arrayList.add("welcome");
        arrayList.add("to");
        arrayList.add("earth");

        Thread t1 = new Thread(() -> {
            arrayList.set(1, "lalal");
            arrayList.remove(2);
            arrayList.remove(3);

            Iterator<String> ite = arrayList.iterator();

            while (ite.hasNext()) {
                System.out.println(ite.next());
            }
        });

        Iterator<String> ite = arrayList.iterator();
        t1.start();

        t1.join();
        System.out.println("====================");
        while (ite.hasNext()) {
            System.out.println(ite.next());
        }

    }
}
