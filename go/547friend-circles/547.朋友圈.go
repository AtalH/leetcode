/*
 * @lc app=leetcode.cn id=547 lang=golang
 *
 * [547] 朋友圈
 */

// @lc code=start
func findCircleNum(M [][]int) int {
	count := len(M)
	if count < 2 {
		return count
	}
	unionFind := CreateUnionFind(count)
	for i := 0; i < count; i++ {
		for j := 0; j < count; j++ {
			if i != j && M[i][j] == 1 {
				unionFind.union(i, j)
			}
		}
	}
	return unionFind.count
}

// UnionFind 并查集
type UnionFind struct {
	count  int
	parent []int
}

// CreateUnionFind 创建拥有 n 个元素的并查集
func CreateUnionFind(n int) *UnionFind {
	parentN := make([]int, n)
	for i := 0; i < n; i++ {
		parentN[i] = i
	}
	return &UnionFind{count: n, parent: parentN}
}

// Find 查找领头元素
func (unionFind *UnionFind) Find(p int) int {
	for p != unionFind.parent[p] {
		unionFind.parent[p] = unionFind.parent[unionFind.parent[p]]
		p = unionFind.parent[p]
	}
	return p
}

func (unionFind *UnionFind) union(p, q int) {
	rootP := unionFind.Find(p)
	rootQ := unionFind.Find(q)
	if rootP == rootQ {
		return
	}
	unionFind.parent[rootP] = rootQ
	unionFind.count--
}
// @lc code=end

