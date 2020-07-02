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
		temp =  maxInt(temp, 0) + nums[i]
		if temp > max {
			max = temp
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

