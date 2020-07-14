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
	dp := make([][]int, n)
	for i, _ := range dp {
		dp[i] = make([]int, m)
	}
	for i := 0; i < n; i++ {
		dp[i][0] = 1
	}
	for j := 0; j < m; j++ {
		dp[0][j] = 1
	}
	for i := 1; i < n; i++ {
		for j := 1; j < m; j++ {
			dp[i][j] = dp[i-1][j] + dp[i][j-1]
		}
	}
	return dp[n - 1][m - 1]
}
// @lc code=end

