package thejava.concurrent.class_4;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Callback

        // Callback이 파라미터를 받고 리턴값이 있는 경우
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "durup";
        }).thenApply((s) -> { // callback을 get() 호출 전에 정의하는게 가능해졌다.
            System.out.println("Hello " + Thread.currentThread().getName());
            return s.toUpperCase();
        });
        System.out.println(future.get());


        System.out.println("==============================================");

        // Callback이 파라미터를 받고 리턴값이 없는 경우
        CompletableFuture<Void> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "durup";
        }).thenAccept((s) -> { // callback을 get() 호출 전에 정의하는게 가능해졌다.
            System.out.println("Hello " + Thread.currentThread().getName());
            System.out.println(s.toUpperCase());
        });
        future2.get();

        System.out.println("==============================================");

        // Callback이 파라미터도 없고 리턴값도 없는 경우
        CompletableFuture<Void> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "durup";
        }).thenRun(() -> { // callback을 get() 호출 전에 정의하는게 가능해졌다.
            System.out.println("Hello " + Thread.currentThread().getName());
            System.out.println("success");
        });
        future3.get();

        /*
            ForkJoinPool
            지금까지 비동기적으로 처리했는데
            Thread pool을 만들지도 않았는데 어떻게 별도의 쓰레드에서 동작?
            Java 7에서 나온 ForkJoinPool
            Executor를 구현한 구현체 중에 하나

         */


    }
}
