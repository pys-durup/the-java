package thejava.concurrent.class_3;

import java.util.concurrent.*;
import java.util.function.Function;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Runnable과 모든게 똑같지만 return값이 있다는 것만 차이점
        Callable<String> hello = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        };
        Callable<String> hello2 = () -> "Hello";
        Callable<String> hello3 = () -> {
            Thread.sleep(2000L);
            System.out.println("callable is running / Thread : " + Thread.currentThread().getName());
            return "Hello";
        };

        // runnable과 마찬가지로 submit 메서드로 호출
        // 리턴값이 있기 때문에 Future 타입으로 리턴값을 받는다
        Future<String> helloFuture = executorService.submit(hello3);
        System.out.println("Started!!");
        System.out.println(helloFuture.isDone());

        // cancel 메서드로 중단시킬 수 있다
        helloFuture.cancel(true);
//        helloFuture.cancel(false);


        // callable에 의해 만들어진 값을 꺼낼 수 있다
        // get() 메서드 이전까지는 코드가 쭉 실행이 되다가
        // get() 메서드를 만난 순간 멈춰서 결과값을 가져올때까지 기다린다 - 블록킹 콜
        // callable을 썼다고해서 애플리케이션이 빨라지지 않는다 (기다리는 경우가 있기 때문에)'
//        helloFuture.get();

        // 상태를 알수 없이 마냥 기다려야 하는가?
        // 상태를 확인하는 isDone()

        System.out.println(helloFuture.isDone());
        System.out.println("End!!");
        executorService.shutdown();

    }
}
