package main

import "fmt"

func selectionSort(arr []int) []int {
	n := len(arr)
	if n <= 1 {
		return arr
	}
	for i := 0; i < n-1; i++ {
		min := i
		for j := i + 1; j < n; j++ {
			if arr[j] < arr[min] {
				min = j
			}
		}
		arr[i], arr[min] = arr[min], arr[i]
	}
	return arr
}

func main() {
	array := []int{1, 4, 212, 14, 5, 3}
	array = selectionSort(array)
	fmt.Println(array)
}
