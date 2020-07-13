/*
 * @lc app=leetcode.cn id=350 lang=golang
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
func intersect(nums1 []int, nums2 []int) []int {
	l1, l2 := len(nums1), len(nums2)
	if l1 == 0 || l2 == 0 {
		return []int{}
	}
	result := make([]int, 0)
	if l1 > l2 {
		l1, l2 = l2, l1
		nums1, nums2 = nums2, nums1
	}
	nums2Map := make(map[int]int, l2)
	for _, v := range nums2 {
		count := nums2Map[v]
		count++
		nums2Map[v] = count
	}
	for _, v := range nums1 {
		if count, ok := nums2Map[v]; ok {
			result = append(result, v)
			if count > 1 {
				count--
				nums2Map[v] = count
			} else {
				delete(nums2Map, v)
			}
		}
	}
	return result
}
// @lc code=end

