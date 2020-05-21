/*
 * @lc app=leetcode.cn id=24 lang=golang
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func swapPairs(head *ListNode) *ListNode {
	pre := &ListNode{Val:-1}
	dummy := pre
	pre.Next = head
	for ; pre.Next != nil && pre.Next.Next != nil; {
		a := pre.Next
		b := a.Next
		pre.Next, a.Next, b.Next = b, b.Next, a
		pre = a
	}
	return dummy.Next
}
// @lc code=end