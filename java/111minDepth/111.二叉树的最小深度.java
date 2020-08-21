import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 1;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> nextQ = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node;
            while((node = q.poll()) != null) {
                if (node.left == null && node.right == null) {
                    return result;
                } 
                if (node.left != null) {
                    nextQ.offer(node.left);
                }
                if ( node.right != null) {
                    nextQ.offer(node.right);
                }
            }
            result++;
            Queue<TreeNode> tmpQ = q;
            q = nextQ;
            nextQ = tmpQ;
        }
        return result;
    }
}
// @lc code=end

