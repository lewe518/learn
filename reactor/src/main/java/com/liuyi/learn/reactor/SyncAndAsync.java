package com.liuyi.learn.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class SyncAndAsync {
    public static void main(String[] args) {
        System.out.println("before mono");
        mono().subscribeOn(Schedulers.immediate()).subscribe(System.out::println);
        System.out.println("after mono");
    }

    private static Mono<String> mono() {
        return Mono.fromSupplier(() -> {
            System.out.println("mono1");
            System.out.println("Current thread is " + Thread.currentThread().getId());
            return "mono1";
        });
    }
}
