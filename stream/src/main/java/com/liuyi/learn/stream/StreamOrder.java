package com.liuyi.learn.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * StreamOrder
 *
 * @author xc_liuyi
 * Create at: 2023/1/16
 */
public class StreamOrder {
    public static void main(String[] args) {
        System.out.println(Stream.of("1", "2", "3")
                .filter(i -> {
                    System.out.println(i);
                    return true;
                })
                .collect(Collectors.toList()));
    }
}
