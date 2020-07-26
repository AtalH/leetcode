/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    // wrong answer
    public int numDecodings(String s) {
        if(s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        if(n == 1) {
            return 1;
        }
        int last = 1;
        int curr = 1;
        for(int i = 1; i < n; i++) {
            int temp = curr;
            if(s.charAt(i) == '0') {
                if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2') {
                    curr = last;
                } else {
                    return 0;
                }
            }else if(s.charAt(i-1) == '1' || (s.charAt(i-1) == 2 && s.charAt(i) <= 6)) {
                curr += last;
            }
            last = temp;
        }
        return curr;
    }
}
// @lc code=end

