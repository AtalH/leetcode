/*
 * @lc app=leetcode.cn id=83 lang=golang
 *
 * [83] 删除排序链表中的重复元素
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func deleteDuplicates(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	node := head.Next
	lastNode := head
	for node != nil {
		if lastNode.Val == node.Val {
			lastNode.Next = node.Next
		} else {
			lastNode = node
		}
		node = node.Next
	}
	return head
}
// @lc code=end

