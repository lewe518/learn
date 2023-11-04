package com.liuyi.learn.time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * InstantUtils
 *
 * @author xc_liuyi
 * Create at: 2023/6/19
 */
public class InstantUtils {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> result = list.stream()
                .filter(i -> i > 2)
                .filter(i -> i > 3)
                .filter(i -> i > 4)
                .filter(i -> i > 5)
                .collect(Collectors.toList());
        System.out.println("result = " + result);
    }

}
