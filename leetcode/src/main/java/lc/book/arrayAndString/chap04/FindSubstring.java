package lc.book.arrayAndString.chap04;

import java.time.LocalDate;
import java.util.Arrays;

/**
 *  题目描述：
 *      给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 *      https://leetcode-cn.com/problems/implement-strstr/
 */
public class FindSubstring {

    public static void main(String[] args) {
        LocalDate.now().minusMonths(1).withDayOfMonth(1);
        FindSubstring instance = new FindSubstring();
        System.out.println(Arrays.toString(instance.prefixSuffixSameLength("abcdabcd".toCharArray())));
        System.out.println(Arrays.toString(instance.prefixSuffixSameLength("abcdabcda".toCharArray())));
        System.out.println(Arrays.toString(instance.prefixSuffixSameLength("aba".toCharArray())));
        System.out.println(Arrays.toString(instance.prefixSuffixSameLength("abab".toCharArray())));
        System.out.println(Arrays.toString(instance.prefixSuffixSameLength("ababa".toCharArray())));

        System.out.println(instance.strStr("ababa", "a"));
        System.out.println(instance.strStr("ababa", "ab"));
        System.out.println(instance.strStr("ababa", "aba"));
        System.out.println(instance.strStr("ababa", "ba"));
        System.out.println(instance.strStr("ababa", "bab"));
        System.out.println(instance.strStr("ababa", ""));
        System.out.println(instance.strStr("", ""));
        System.out.println(instance.strStr("", "a"));
        System.out.println(instance.strStr("abcd", "abce"));
        System.out.println(instance.strStr("abcd", "abcde"));
        System.out.println(instance.strStr("aaaaa", "a"));
        System.out.println(instance.strStr("aaaaa", "ab"));
    }


    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }

        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        int[] sameHeadTailLength = this.prefixSuffixSameLength(needleChars);

        int needleIndex = 0, haystackIndex = 0;
        while (haystackIndex < haystackChars.length && needleIndex < needleChars.length) {
            if (haystackChars[haystackIndex] == needleChars[needleIndex]) {
                haystackIndex++;
                needleIndex++;
            } else if (needleIndex == 0) {
                haystackIndex++;
            } else {
                needleIndex = sameHeadTailLength[needleIndex - 1]; // 前边已匹配子串的最大前缀后缀长度
            }
        }
        if (needleIndex == needleChars.length) {
            return haystackIndex - needleIndex;
        } else {
            return -1;
        }
    }

    public int[] prefixSuffixSameLength(char[] needleChars) {
        int[] prefixSuffixSameLength = new int[needleChars.length];
        for (int i = 1; i < needleChars.length; i++) {
            char needleChar = needleChars[i];
            int prevCharSameLength = prefixSuffixSameLength[i - 1];
            if (needleChar == needleChars[prevCharSameLength]) {
                prefixSuffixSameLength[i] = prevCharSameLength + 1;
            }
        }
        return prefixSuffixSameLength;
    }

}
