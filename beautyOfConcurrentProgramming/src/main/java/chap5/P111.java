package chap5;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class P111 {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();

        arrayList.add("hello");
        arrayList.add("world!");

        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            arrayList.add("lalal");
            System.out.println(iterator.next());
        }
    }
}
