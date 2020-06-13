/*
 * @lc app=leetcode.cn id=367 lang=golang
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
func isPerfectSquare(num int) bool {
	// 完全平方数是指 s = n*n, n 是整数
	// 解法1. 使用二分查找法
	if num < 0 {
		return false
	} else if num <= 1 {
		return true
	}
	// s = n*n --> n < s/2 + 1
	left, right := 0, num/2 + 1
	for left <= right {
		mid := (left + right) / 2
		s := mid * mid
		if s == num {
			return true
		} else if (s > num) {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return false
}
// @lc code=end

