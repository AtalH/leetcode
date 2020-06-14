/*
 * @lc app=leetcode.cn id=169 lang=golang
 *
 * [169] 多数元素
 */

// @lc code=start
func majorityElement(nums []int) int {
	m := len(nums)/2
    countMap := make(map[int]int, m)
    for _, v := range nums {
        count := countMap[v]
        count++
        if count > m {
            return v
        } else {
            countMap[v] = count
        }
    }
    panic("majority element dose not exist")
}
// @lc code=end

