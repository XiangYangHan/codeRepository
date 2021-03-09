package chap5;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTest {

    public static void main(String[] args) {
/*
        Object[] objs = {"123", "123"};
        System.out.println(objs.getClass());
        objs[0] = 123;
        System.out.println(Arrays.toString(objs));

        String[] strs = {"123", "123"};
        System.out.println(strs.getClass());
        strs[0] = "111";
        System.out.println(Arrays.toString(strs));
        objs = strs;
        System.out.println(objs.getClass());
        objs[0] = "222";
        System.out.println(Arrays.toString(objs));
//        objs[0] = 222; // java.lang.ArrayStoreException
        System.out.println(Arrays.toString(objs));
*/

//        ================================================

        ArrayList<Object> objs = new ArrayList<>();
        objs.add(123);
        objs.add("123");
        System.out.println(objs);
        Object[] objArr = objs.toArray();
        System.out.println(objArr.getClass());
        objArr[0] = 111;
        System.out.println(Arrays.toString(objArr));
        System.out.println();

        List<String> strList = Arrays.asList("123", "123");
        System.out.println(strList);
        Object[] strListArr = strList.toArray();
        System.out.println(strListArr.getClass());
//        strListArr[0] = 123; // java.lang.ArrayStoreException
        System.out.println(Arrays.toString(strListArr));
        System.out.println();

        List<? extends Serializable> list = Arrays.asList("123", 123);
        System.out.println(list);
        Object[] listArr = list.toArray();
        System.out.println(listArr.getClass());
        listArr[0] = 1.23;
        listArr[1] = LocalDateTime.now();
        System.out.println(Arrays.toString(listArr));
        System.out.println();
    }
}
