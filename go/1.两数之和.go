/*
 * @lc app=leetcode.cn id=1 lang=golang
 *
 * [1] 两数之和
 */

// @lc code=start
func twoSum(nums []int, target int) []int {
	l := len(nums)
	fastIndex := 1
	for slowIndex := 0; slowIndex < l; {
		if nums[slowIndex] + nums[fastIndex] == target {
			return []int{slowIndex, fastIndex}
		}
		fastIndex++
		if fastIndex == l {
			slowIndex++
			fastIndex = slowIndex + 1
		}
	}
	panic("no target match")
}

// @lc code=end
