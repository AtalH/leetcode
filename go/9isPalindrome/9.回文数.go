/*
 * @lc app=leetcode.cn id=9 lang=golang
 *
 * [9] 回文数
 */

// @lc code=start
func isPalindrome(x int) bool {
	if x < 0 {
		return false
	}
	s := strconv.Itoa(x)
	
	for l, r := 0, len(s) - 1; l < r; l, r = l + 1, r - 1 {
		if s[l] != s[r] {
			return false
		}
	}
	return true
}
// @lc code=end

