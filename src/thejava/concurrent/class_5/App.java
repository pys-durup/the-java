package thejava.concurrent.class_5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Future만으로는 비동기적인 작업들을 이어서 처리하는 것이 힘들었다
        // 비동기 적인 작업들을 연결하는 것 자체가 힘들었다 - callback을 줄 수 없었기 때문에
        // 비동기 작업들끼리 연관관계가 있는경우
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });


        CompletableFuture<String> future = hello.thenCompose(s -> getWorld(s));
        System.out.println(future.get());


    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return message + "World";
        });
    }
}
