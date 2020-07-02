/*
 * @lc app=leetcode.cn id=53 lang=golang
 *
 * [53] 最大子序和
 */

// @lc code=start
func maxSubArray(nums []int) int {
	len := len(nums);
	if len == 0 {
		return 0;
	}
	dp := make([]int, len)
	dp[0] = nums[0]
	max := dp[0]
	for i := 1; i < len; i++ {
		dp[i] =  maxInt(dp[i-1], 0) + nums[i]
		if dp[i] > max {
			max = dp[i]
		}
	}
	return max
}

func maxInt(a int, b int) int {
	if a >= b {
		return a
	} else {
		return b
	}
}
// @lc code=end

