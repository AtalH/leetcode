package main

import "fmt"

func bubbleSort(array []int) []int {
	n := len(array)
	if n <= 1 {
		return array
	}
	for i := 0; i < n-1; i++ {
		for j := 0; j < n-1-i; j++ {
			if array[j] > array[j+1] {
				array[j], array[j+1] = array[j+1], array[j]
			}
		}
	}
	return array
}

func main() {
	array := []int{1, 4, 212, 14, 5, 3}
	array = bubbleSort(array)
	fmt.Println(array)
}
