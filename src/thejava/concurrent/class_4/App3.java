package thejava.concurrent.class_4;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // ThredPool을 ForkJoinPool 말고 직접 제공해준 Thread pool을 사용하는 방법
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        },executorService).thenRunAsync(() -> {
            System.out.println("Hello callback" + Thread.currentThread().getName());
        },executorService);

        future.get();


        /*
        runAsync, supplyAsync()의 동작을 ForkJoinPool이 아닌 따로 제공해준 Thred pool에서 처리하고 싶은 경우
        두번째 인자로 excutor 구현체를 넘겨준다 (사용할 Thread pool)

        Callback을 ForkJoinPool이 아닌 따로 제공해준 Thred pool에서 처리하고 싶은 경우
        thenRunAsync / thenAcceptAsync / thenApplyAsync 메서드를 사용하고
        두번째 인자로 excutor 구현체를 넘겨준다 (사용할 Thread pool)

         */

        executorService.shutdown();
    }
}
