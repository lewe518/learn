package com.liuyi.learn.leetcode.binarysearch

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class BinarySearchTest extends Specification {
    def binarySearch = new BinarySearch()

    def "test search"() {
        expect:
        result == binarySearch.search(nums as int[], target)
        where:
        nums                 | target || result
        [2]                  | 2      || 0
        [2]                  | 3      || -1
        [-1, 0, 3, 5, 9, 12] | 9      || 4
        [-1, 0, 3, 5, 9, 12] | 2      || -1
    }
}
