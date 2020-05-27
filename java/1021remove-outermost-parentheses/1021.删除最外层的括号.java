/*
 * @lc app=leetcode.cn id=1021 lang=java
 *
 * [1021] 删除最外层的括号
 */

// @lc code=start
class Solution {
    public String removeOuterParentheses(String S) {
        if (S == null || S.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder(S.length());
        int opended = 0;
        for (char c : S.toCharArray()) {
            if(c == '(' && opended++ > 0) {
                result.append(c);
            }
            if(c == ')' && opended-- > 1) {
                result.append(c);
            }
        }
        return result.toString();
    }
}
// @lc code=end

