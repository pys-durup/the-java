package thejava.concurrent.class_5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 두 작업간에 연관관계가 없는 경우
        // 둘이 동시에 비동기적으로 실행
        // ex) 하나는 애플주식가격 가져오기 하나는 MS 주식가격 가져오기
        // 두 작업을 독립적으로 실행하고 둘 다 종료 했을때 콜백 실행
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return "World";
        });

        CompletableFuture<String> future = hello.thenCombine(world, (h, w) -> {
            return h + " " + w;
        });
        System.out.println(future.get());
    }
}
