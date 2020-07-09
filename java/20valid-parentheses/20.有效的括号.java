/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int len = s.length();
        if(len % 2 == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        int stackCapacity = len >> 1;
        char[] stack = new char[stackCapacity];
        int top = 0;
        for (char c : chars) {
            if(c == '(' || c == '{' || c == '[') {
                if(top < stackCapacity) {
                    stack[top++] = c;
                } else {
                    return false;
                }
            } else if(c == ')') {
                if(top == 0 || stack[--top] != '(') {
                    return false;
                }
            } else if(c == '}') {
                if(top == 0 || stack[--top] != '{') {
                    return false;
                }
            } else if(c == ']') {
                if (top == 0 || stack[--top] != '[') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return top == 0;
    }
}
// @lc code=end

