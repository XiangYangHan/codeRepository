package lc.book.arrayAndString.chap05;

import java.util.Arrays;
import java.util.Objects;

/**
 *  题目描述：
 *      编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 *      https://leetcode-cn.com/problems/reverse-string
 */
public class ReverseString {

    public static void main(String[] args) {
        ReverseString instance = new ReverseString();
        char[] chars = {'1', '2'};
        instance.reverseString(chars);
        System.out.println(Arrays.toString(chars));

    }

    public void reverseString(char[] s) {
        if (Objects.nonNull(s)) {
            int l = 0, r = s.length - 1;
            while (l < r) {
                s[l] ^= s[r];
                s[r] ^= s[l];
                s[l] ^= s[r];
                l++;
                r--;
            }
        }
    }
}
