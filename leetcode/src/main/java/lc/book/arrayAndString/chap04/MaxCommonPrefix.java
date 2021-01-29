package lc.book.arrayAndString.chap04;

/**
 *  题目描述：
 *      编写一个函数来查找字符串数组中的最长公共前缀。
 *      如果不存在公共前缀，返回空字符串 ""。
 *
 *      https://leetcode-cn.com/leetbook/read/array-and-string/ceda1/
 */
public class MaxCommonPrefix {

    public static void main(String[] args) {
        MaxCommonPrefix maxCommonPrefix = new MaxCommonPrefix();
        String[] strs = new String[]{};
        strs = new String[]{"abc"};
        System.out.println(maxCommonPrefix.longestCommonPrefix(strs));
        strs = new String[]{"abc", ""};
        System.out.println(maxCommonPrefix.longestCommonPrefix(strs));
        strs = new String[]{"abc", "ab", "abcd", "a"};
        System.out.println(maxCommonPrefix.longestCommonPrefix(strs));
        strs = new String[]{"abc", "", "abc"};
        System.out.println(maxCommonPrefix.longestCommonPrefix(strs));
        strs = new String[]{"flower","flow","flight"};
        System.out.println(maxCommonPrefix.longestCommonPrefix(strs));
    }



    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String baseStr = strs[0];
        int maxLength = baseStr.length();
        for (int i = 1; i < strs.length; i++) {
            String curStr = strs[i];
            if (curStr.length() < maxLength) {
                maxLength = curStr.length();
            }
            int sameLength = 0;
            while (sameLength < maxLength) {
                if (baseStr.charAt(sameLength) != curStr.charAt(sameLength)) {
                    break;
                }
                sameLength++;
            }
            if (sameLength < maxLength) {
                maxLength = sameLength;
            }
            if (maxLength == 0) {
                break;
            }
        }
        return baseStr.substring(0, maxLength);
    }
}
