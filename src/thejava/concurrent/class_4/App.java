package thejava.concurrent.class_4;

import java.util.concurrent.*;
import java.util.function.Function;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // CompletableFuture 생성 & 사용
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("durup");
        System.out.println(future.get());

        // 스태틱 팩토리 메서드 이용하여 생성
        CompletableFuture<String> future1 = CompletableFuture.completedFuture("durup");
        System.out.println(future.get());

        // 리턴값이 없는 경우
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
        });
        future2.get();

        // 리턴값이 있는 경우
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "durup";
        });
        System.out.println(future3.get());

    }
}
