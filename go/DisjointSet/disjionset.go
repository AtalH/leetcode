package main

import "fmt"

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

func main() {
	unionFind := CreateUnionFind(6)
	unionFind.union(0, 2)
	unionFind.union(0, 1)
	root := unionFind.Find(2)
	fmt.Println("root of 2", root)
	root = unionFind.Find(0)
	fmt.Println("root of 0", root)
}
