/*
 * @lc app=leetcode.cn id=104 lang=golang
 *
 * [104] 二叉树的最大深度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0;
	}
	depth := dfs(root, 0)
	return depth
}

func dfs(node *TreeNode, level int) int {
	if node == nil {
		return level
	}
	left := dfs(node.Left, level + 1)
	right := dfs(node.Right, level + 1)
	if left >= right {
		return left
	} else {
		return right
	}
}
// @lc code=end

