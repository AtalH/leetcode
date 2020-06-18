/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingPoint = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingPoint = Math.max(maxEndingPoint + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingPoint);
        }
        return maxSoFar;
    }
}
// @lc code=end

