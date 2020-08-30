/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        if (s == null ||  s.isEmpty()) {
            return s;
        }
        char[] chars = s.toCharArray();
        int wordStart = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ' || i == chars.length - 1) {
                if (i == chars.length - 1) {
                    i += 1;
                }
                for (int j = i - 1; j > wordStart; wordStart++, j--) {
                    char tmp = chars[j];
                    chars[j] = chars[wordStart];
                    chars[wordStart] = tmp;
                }
                wordStart = i + 1;
            }
        }
        return new String(chars);
    }
}
// @lc code=end

