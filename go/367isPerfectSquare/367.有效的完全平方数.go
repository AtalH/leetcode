/*
 * @lc app=leetcode.cn id=367 lang=golang
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
func isPerfectSquare(num int) bool {
	// 完全平方数是指 s = n*n, n 是整数
	// 解法1. 二分查找，时间复杂度 O(log n)
	// 解法2. 利用奇数数列和公式 1 + 3 + 5 + ... + (2N−1) = n*n , 时间复杂度 O(sqrt(N))
	odd := 1
	for num > 0 {
		num -= odd
		odd += 2
	}
	return num == 0
}
// @lc code=end

