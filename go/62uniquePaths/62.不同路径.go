/*
 * @lc app=leetcode.cn id=62 lang=golang
 *
 * [62] 不同路径
 */

// @lc code=start
func uniquePaths(m int, n int) int {
	if m < 1 || n < 1 {
		return 0
	}
	return dfs(1, 1, m, n, 0)
}

// time exceeded
func dfs(x int, y int, m int, n int, result int) int {
	if x == m && y == n {
		result++
		return result
	}
	if x < m {
		result = dfs(x+1, y, m, n, result)
	}
	if y < n {
		result = dfs(x, y+1, m, n, result)
	}
	return result
}
// @lc code=end

