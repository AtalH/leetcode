package main

import (
	"fmt"
	"strings"
)

/*
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */

func replaceSpace(s string) string {
	result := make([]string, 0, len(s)*2)
	for _, v := range []byte(s) {
		if v == ' ' {
			result = append(result, "%20")
		} else {
			result = append(result, string(v))
		}
	}
	return strings.Join(result, "")
}

func main() {
	s := "We are happy."
	fmt.Println(replaceSpace(s))
}
