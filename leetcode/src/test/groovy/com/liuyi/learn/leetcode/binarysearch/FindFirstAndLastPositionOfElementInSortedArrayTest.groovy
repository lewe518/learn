package com.liuyi.learn.leetcode.binarysearch

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class FindFirstAndLastPositionOfElementInSortedArrayTest extends Specification {
    def findFirstAndLastPositionOfElementInSortedArray = new FindFirstAndLastPositionOfElementInSortedArray()

    def "test searchRange"() {
        expect:
        result as int[] == findFirstAndLastPositionOfElementInSortedArray.searchRange(nums as int[], target)
        where:
        nums                | target || result
        [5, 7, 7, 8, 8, 10] | 8      || [3, 4]
        [5, 7, 7, 8, 8, 10] | 6      || [-1, -1]
        []                  | 0      || [-1, -1]
    }
}
