package lc.book.arrayAndString.chap04;

import java.util.ArrayList;
import java.util.List;

/**
 *  题目描述：
 *      给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *      https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class ReverseWord {

    public static void main(String[] args) {
        ReverseWord reverseWord = new ReverseWord();
        System.out.println(reverseWord.reverseWords("the sky is blue"));
        System.out.println(reverseWord.reverseWords("blue is sky the"));
        System.out.println(reverseWord.reverseWords("  hello world!  "));
        System.out.println(reverseWord.reverseWords(" a good   example"));
        System.out.println(reverseWord.reverseWords("  Bob    Loves  Alice   "));
        System.out.println(reverseWord.reverseWords("Alice does not even like bob"));
    }

    public String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        char[] chars = s.toCharArray();
        int wordStart = 0;
        int wordLength = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                if (wordLength > 0) {
                    words.add(new String(chars, wordStart, wordLength));
                    wordLength = 0;
                }
                continue;
            }
            if (wordLength == 0) {
                wordStart = i;
            }
            wordLength++;
        }
        if (wordLength > 0) {
            words.add(new String(chars, wordStart, wordLength));
        }
        if (words.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = words.size() - 1; i >= 0; i--) {
            sb.append(" ").append(words.get(i));
        }
        return sb.substring(1);
    }

}
