/*
 * @lc app=leetcode.cn id=122 lang=golang
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
func maxProfit(prices []int) int {
	n := len(prices)
    if(n <= 1) {
        return 0;
    }
	// 将所有股价上升期的价格差累加即可
    income := 0
    for l, r := 1, n - 1; l <= r; l, r = l+1, r-1 {
        if prices[l] > prices[l-1] {
            income += prices[l] - prices[l-1]
        }
        if prices[r] > prices[r-1] && l != r{
            income += prices[r] - prices[r-1]
        }
    }
    return income
}
// @lc code=end

