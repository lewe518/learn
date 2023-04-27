package com.liuyi.learn.stream;

import java.util.Arrays;
import java.util.List;

public class Copliot {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 取中位数
        System.out.println(list.stream().sorted().skip(list.size() / 2).findFirst().get());
        // 取最大值
        System.out.println(list.stream().max((a, b) -> a - b).get());
        // 取最小值
        System.out.println(list.stream().min((a, b) -> a - b).get());
        // 取平均值
        
    }

    // 双重校验锁单例
    private static volatile Copliot instance;

    private Copliot() {
    }

    public static Copliot getInstance() {
        if (instance == null) {
            synchronized (Copliot.class) {
                if (instance == null) {
                    instance = new Copliot();
                }
            }
        }
        return instance;
    }
}
