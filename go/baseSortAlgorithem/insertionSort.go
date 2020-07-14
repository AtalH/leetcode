package main

import "fmt"

func insertionSort(arr []int) []int {
	n := len(arr)
	if n <= 1 {
		return arr
	}
	for i := 1; i < n; i++ {
		pre, cur := i-1, arr[i]
		for pre >= 0 && arr[pre] > cur {
			arr[pre+1] = arr[pre]
			pre--
		}
		arr[pre+1] = cur
	}
	return arr
}

func main() {
	array := []int{1, 4, 212, 14, 5, 3}
	array = insertionSort(array)
	fmt.Println(array)
}
