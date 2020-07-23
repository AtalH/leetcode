/*
 * @lc app=leetcode.cn id=917 lang=java
 *
 * [917] 仅仅反转字母
 */

// @lc code=start
class Solution {
    public String reverseOnlyLetters(String S) {
        if(S == null || S.length() <= 1) {
            return S;
        }
        int len = S.length();
        int i = 0, j = len - 1;
        char[] chars = S.toCharArray();
        while(i < j) {
            while(!Character.isLetter(chars[i]) && i < j) {
                i++;
            }
            while(!Character.isLetter(chars[j]) && i < j) {
                j--;
            }
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }
}
// @lc code=end

