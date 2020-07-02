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

