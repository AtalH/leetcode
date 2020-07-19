/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode lastNode = head;
        ListNode node = head.next;
        while(node != null) {
            if(node.val == lastNode.val) {
                lastNode.next = node.next;
            } else {
                lastNode = node;
            }
            node = node.next;
        }
        return head;
    }
}
// @lc code=end

