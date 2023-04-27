package com.liuyi.learn.stream;

import java.util.stream.IntStream;

public class StreamTracer {
    public static void main(String[] args) {
        int[] result = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(i -> i % 2 == 0)
                .map(i -> i * 2)
                .toArray();
        System.out.println(result);
    }
}
