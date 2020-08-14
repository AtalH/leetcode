import java.util.Map;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        // '('，')'，'{'，'}'，'['，']'
        if(s == null || s.isEmpty()) {
            return true;
        }
        int len = s.length();
        if((len & 1) == 1) {
            return false;
        }
        char[] stack = new char[len/2+1];
        int i = 0;
        for (int j = 0; j < len; j++) {
            char c = s.charAt(j);
            if(c == '(' || c == '[' || c == '{') {
                stack[i++] = c;
                continue;
            }
            if(i == 0 || i > (len-j)) {
                return false;
            }
            char sc = stack[--i];
            if((sc == '(' && c == ')')
            || (sc == '[' && c == ']')
            || (sc == '{' && c == '}')) {
                continue;
            }
            return false;
        }
        return i==0;
    }
}
// @lc code=end

