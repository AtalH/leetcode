/*
 * @lc app=leetcode.cn id=167 lang=golang
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
func twoSum(numbers []int, target int) []int {
	n := len(numbers)
	if n < 2 {
		return []int{}
	}
	for i, j := 0, n - 1; i < j; {
		temp := numbers[i] + numbers[j]
		if temp == target {
			return []int{i+1, j+1}
		} else if temp > target {
			j--
		} else {
			i++
		}
	}
	return []int{}
}
// @lc code=end

