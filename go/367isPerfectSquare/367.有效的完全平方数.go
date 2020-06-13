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
	// 解法3. 牛顿迭代法，利用 s = n*n --> x = (x + s/x)/2 使得 x 不断收敛于 n
	if num < 0 {
		return false
	} else if num <= 1 {
		// 0 & 1
		return true
	}
	// 初始值选取
	x := num / 2
	for x * x > num {
		x = (x + num / x) / 2
	}
	return x * x == num
}
// @lc code=end

