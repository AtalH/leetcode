package main

import "fmt"

// unsortedIndex 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
func unsortedIndex(array []int) int {
	count := len(array)
	if count < 2 {
		return 0
	} else if count == 2 && array[0] > array[1] {
		return 1
	}
	left, right := 0, count-1
	for left <= right {
		mid := left/2 + right/2
		if array[mid] > array[mid-1] && array[mid] > array[mid+1] {
			return mid + 1
		} else if array[mid] > array[mid-1] {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return 0
}

func main() {
	// test case
	// array := []int{0, 3, 2}
	// array := []int{3, 2}
	array := []int{4, 5, 6, 7, 0, 1, 2}
	// array := []int{0, 1, 2, 3, 7, 6, 5}
	// array := []int{0, 1, 2, 9, 8, 7, 6, 5, 4, 3, 2, 1}
	i := unsortedIndex(array)
	fmt.Println(i)
}
