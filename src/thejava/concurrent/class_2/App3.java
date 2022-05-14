package thejava.concurrent.class_2;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App3 {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        // 특정 시간 후에 실행한다
        executorService.schedule(getRunnable("Hello"), 3, TimeUnit.SECONDS);

        // 1초 기다렸다가 2초 이후에 반복적으로 출력하라
        executorService.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS);

    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
