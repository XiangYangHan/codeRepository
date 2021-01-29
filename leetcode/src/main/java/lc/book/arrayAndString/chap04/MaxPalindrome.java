package lc.book.arrayAndString.chap04;

/**
 *  题目描述：
 *      给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *      https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class MaxPalindrome {

    public static void main(String[] args) {
        MaxPalindrome maxPalindrome = new MaxPalindrome();
        System.out.println(maxPalindrome.longestPalindrome(""));
        System.out.println(maxPalindrome.longestPalindrome("a"));
        System.out.println(maxPalindrome.longestPalindrome("ab"));
        System.out.println(maxPalindrome.longestPalindrome("abc"));
        System.out.println(maxPalindrome.longestPalindrome("aba"));
        System.out.println(maxPalindrome.longestPalindrome("aa"));
        System.out.println(maxPalindrome.longestPalindrome("aaa"));
        System.out.println(maxPalindrome.longestPalindrome("aabaa"));
        System.out.println(maxPalindrome.longestPalindrome("aabbaa"));
        System.out.println(maxPalindrome.longestPalindrome("aaabbaac"));
    }

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int startIndex = 0;
        int maxLength = 0, halfLength = 0;
        for (int i = 0; i < chars.length; i++) {
            halfLength = modeA(chars, i);
            if (halfLength * 2 + 1 > maxLength) {
                maxLength = halfLength * 2 + 1;
                startIndex = i - halfLength;
            }
            halfLength = modeB(chars, i);
            if (halfLength * 2 > maxLength) {
                maxLength = halfLength * 2;
                startIndex = i + 1 - halfLength;
            }
        }
        return new String(chars, startIndex, maxLength);
    }

    /*
        奇数长度回文
     */
    public int modeA(char[] chars, int center) {
        int i = 1;
        while (true) {
            if (center - i < 0 || center + i >= chars.length) {
                break;
            }
            if (chars[center - i] != chars[center + i]) {
                break;
            }
            i++;
        }
        return i - 1;
    }

    /*
        偶数长度回文
     */
    public int modeB(char[] chars, int center) {
        int i = 0;
        while (true) {
            if (center - i < 0 || center + 1 + i >= chars.length) {
                break;
            }
            if (chars[center - i] != chars[center + 1 + i]) {
                break;
            }
            i++;
        }
        return i;
    }
}
