/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode pre = null;
        ListNode newHead = second;
        while(second != null) {
            ListNode temp = second.next;
            second.next = first;
            first.next = temp;
            
            if(pre != null) {
                pre.next = second;
            }
            pre = first;

            first = temp;
            if(first != null) {
                second = first.next;
            } else {
                break;
            }
        }
        return newHead;
    }
}
// @lc code=end

