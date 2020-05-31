/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int fastIndex = 0;
        int slowIndex = 0;
        int len = nums.length;
        for (; fastIndex < len; fastIndex++) {
            if (nums[fastIndex] != 0) {
                // swap
                int temp = nums[slowIndex];
                nums[slowIndex] = nums[fastIndex];
                nums[fastIndex] = temp;
                slowIndex++;
            }
        }
    }
}
// @lc code=end

