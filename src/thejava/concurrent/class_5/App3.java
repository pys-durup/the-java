package thejava.concurrent.class_5;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class App3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return "World";
        });

        // 두개 이상의 작업을 모두 합쳐서 실행
        // 결과가 동일한 타입이라는 보장도 없고, 에러가 발생할 수도 있어서 결과값이 무의미함
        // 결과값은 null이 들어있다
        // Void 타입
//        CompletableFuture<Void> future = CompletableFuture.allOf(hello, world)
//                .thenAccept(System.out::println);
//        System.out.println(future.get());

        // 모든 작업의 결과값을 Collection으로 받고싶다
        List<CompletableFuture<String>> futures = Arrays.asList(hello, world);
        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);

        CompletableFuture<List<String>> future = CompletableFuture.allOf(futuresArray)
                .thenApply(v -> { // thenApply가 호출되는 시점에는 모든 future의 작업이 끝난 상태다
                    return futures.stream() // get()을 호출해도 된다 -> get은 checked exception을 발생 join은 unchecked exception을 발생시킨다
                            .map(f -> f.join())
                            .collect(Collectors.toList());
                });

        List<String> strings = future.get();
        strings.forEach(System.out::println);

        //
        CompletableFuture<Void> future1 = CompletableFuture.anyOf(hello, world).thenAccept(System.out::println);
        future1.get();

    }
}
