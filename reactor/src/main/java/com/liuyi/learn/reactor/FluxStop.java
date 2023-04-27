package com.liuyi.learn.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.Arrays;
import java.util.List;

public class FluxStop {

    public static void main(String[] args) {
        Flux.merge(mono11(), mono12())
                .last()
                .block();
        String result =
                Flux.zip(mono11(), mono12())
                        .last()
                        .flatMap(i -> mono2())
                        .flatMap(i -> Mono.empty())
                        .flatMap(i -> mono3())
                        .map(i -> i + "map")
                        .onErrorResume(e -> Mono.just("error"))
                        .block();
    }

    private static Mono<String> emptyMono() {
        System.out.println("emptyMono");
        return Mono.empty();
    }

    private static Mono<String> mono11() {
        return Mono.just("").flatMap(i -> {
            sleep(3);
            System.out.println("mono11");
            return Mono.just("mono11");
        }).subscribeOn(Schedulers.parallel());
    }

    private static Mono<String> mono12() {
        return Mono.just("").flatMap(i -> {
            sleep(3);
            System.out.println("mono12");
            return Mono.just("mono12");
        }).subscribeOn(Schedulers.parallel());
    }

    private static Mono<String> mono2() {
        return Mono.fromSupplier(() -> {
            sleep(1);
            System.out.println("mono2");
            return "mono2";
        });
    }

    private static Mono<String> mono3() {
        return Mono.fromSupplier(() -> {
            sleep(3);
            System.out.println("mono3");
            return "mono3";
        });
    }

    private static void sleep(int seconds) {
        try {
            System.out.println("sleep " + seconds + " seconds");
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
