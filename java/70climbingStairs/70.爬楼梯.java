/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if(n <= 2) {
            return n;
        }
        int n_1 = 1;
        int n_2 = 2;
        int n_i = 0;
        for (int i = 3; i <= n; i++) {
            n_i = n_2 + n_1;
            n_1 = n_2;
            n_2 = n_i;
        }
        return n_i;
    }
}
// @lc code=end

