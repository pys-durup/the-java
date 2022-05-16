package thejava.concurrent.class_5;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 예외처리
        // 비동기 작업에서 에러가 발생
//        boolean throwError = true;
//
//        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
//            if (throwError) { // 에러를 무조건 던지도록
//                throw new IllegalArgumentException();
//            }
//
//            System.out.println("Hello " + Thread.currentThread().getName());
//            return "Hello";
//        }).exceptionally(ex -> {
//            System.out.println(ex); // ex는 exception 타입
//            return "Error!";
//        });
//
//        System.out.println(hello.get());


        boolean throwError = true;

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            if (throwError) { // 에러를 무조건 던지도록
                throw new IllegalArgumentException();
            }

            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).handle((result, ex) -> { // 첫번째 파라미터 정상적인 경우, 두번째 파라미터 에러발생시 에러객체
            if (ex != null) { // 에러가 있는경우 에러처리
                System.out.println(ex);
                return "ERROR!";
            }
            return result;
        });

        System.out.println(hello.get());
    }
}
