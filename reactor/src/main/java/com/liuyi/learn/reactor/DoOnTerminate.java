package com.liuyi.learn.reactor;

import reactor.core.publisher.Mono;

public class DoOnTerminate {
    private static ThreadLocal<String> LOCAL = new InheritableThreadLocal();

    public DoOnTerminate() {
    }

    public static void main(String[] args) {
       /* Flux.range(1, 10)
                .map(i -> {
                    System.out.print("now is ");
                    return i;
                })
                .map(i -> {
                    System.out.println(i);
                    return i;
                })
                .doOnTerminate(() -> System.out.println("terminate"))
                .subscribe();*/
        LOCAL.set("ThreadLocal");
        Mono.just("")
                .flatMap(i -> mono1())
                .flatMap(i -> mono2())
                .flatMap(i -> mono3())
                .map(i -> {
                    System.out.print("now is ");
                    return i;
                })
                .doOnTerminate(() -> System.out.println("terminate"))
                .subscribe();
    }

    private static Mono<String> mono1() {
        return Mono.fromSupplier(() -> {
            System.out.println("mono1");
            System.out.println("ThreadLocal is " + LOCAL.get());
            System.out.println("Current thread is " + Thread.currentThread().getId());
            return "mono1";
        });
    }

    private static Mono<String> mono2() {
        return Mono.fromSupplier(() -> {
            System.out.println("mono2");
            System.out.println("ThreadLocal is " + LOCAL.get());
            System.out.println("Current thread is " + Thread.currentThread().getId());
            return "mono2";
        });
    }

    private static Mono<String> mono3() {
        return Mono.fromSupplier(() -> {
            System.out.println("mono3");
            System.out.println("ThreadLocal is " + LOCAL.get());
            System.out.println("Current thread is " + Thread.currentThread().getId());
            return "mono3";
        });
    }
}
