package main

import (
	"fmt"
	"regexp"
)

/*
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */

func replaceSpace(s string) string {
	space := regexp.MustCompile(" ")
	return space.ReplaceAllString(s, "%20")
}

func main() {
	s := "We are happy."
	fmt.Println(replaceSpace(s))
}
