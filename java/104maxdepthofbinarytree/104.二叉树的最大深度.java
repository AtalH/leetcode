/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return getDepth(root, 0);
    }
    
    public int getDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        depth++;
        int leftDepth = getDepth(node.left, depth);
        int rightDepth = getDepth(node.right, depth);
        if (leftDepth >= rightDepth) {
            return leftDepth;
        } else {
            return rightDepth;
        }
    }
}
// @lc code=end

