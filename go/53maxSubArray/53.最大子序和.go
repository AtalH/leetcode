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
	// 最大值问题，首先考虑是否适合使用DP
	// dp status: dp[i] = max(nums[i], nums[i] + dp[i - 1])
	// 如果当前元素加上之前的子序和更大，则加上，否则只用当前元素作为新的子序和
	max, temp := nums[0], nums[0]
	for i := 1; i < len; i++ {
		if temp >= 0 {
			temp += nums[i]
		} else {
			temp = nums[i]
		}
		if temp > max {
			max = temp
		}
	}
	return max
}
// @lc code=end

