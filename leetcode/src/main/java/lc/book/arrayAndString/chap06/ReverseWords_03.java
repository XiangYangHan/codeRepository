package lc.book.arrayAndString.chap06;

import java.util.Objects;

/**
 *  题目描述：
 *      给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *      https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWords_03 {

    public static void main(String[] args) {
        ReverseWords_03 instance = new ReverseWords_03();
        System.out.println(instance.reverseWords("Let's take LeetCode contest"));
        System.out.println(instance.reverseWords("  Let's  take LeetCode contest  "));
        System.out.println(instance.reverseWords(" "));
        System.out.println(instance.reverseWords("    "));
        System.out.println(instance.reverseWords(null));

    }

    public String reverseWords(String s) {
        if (Objects.isNull(s)) {
            return s;
        }
        char[] chars = s.toCharArray();
        int wordStart = 0, wordEnd = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                if (wordEnd > wordStart) {
                    reverseRange(chars, wordStart, wordEnd);
                }
                // 新单词从空格后面一位开始
                wordStart = i + 1;
            } else {
                wordEnd = i;
            }
        }
        if (wordEnd > wordStart) {
            reverseRange(chars, wordStart, wordEnd);
        }
        return new String(chars);
    }

    public void reverseRange(char[] chars, int l, int r) {
        while (l < r) {
            chars[l] ^= chars[r];
            chars[r] ^= chars[l];
            chars[l++] ^= chars[r--];
        }
    }
}
