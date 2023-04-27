package com.liuyi.learn.leetcode.binarysearch

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class SearchInRotatedSortedArrayTest extends Specification {
    def searchInRotatedSortedArray = new SearchInRotatedSortedArray()

    def "test search"() {
        expect:
        result == searchInRotatedSortedArray.search(nums as int[], target)
        where:
        nums                  | target || result
        [4, 5, 6, 7, 0, 1, 2] | 0      || 4
        [4, 5, 6, 7, 0, 1, 2] | 3      || -1
        [1]                   | 0      || -1
    }
}
