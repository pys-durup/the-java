package thejava.concurrent.class_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App2 {
    public static void main(String[] args) {
        // executorService 내부에는 ThreadPool 이 있는데
        // newSingleThreadExecutor 는 ThreadPool이 1개로 생성

        // ThreadPool 2개로 설정
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(getRunnable("Hello"));
        executorService.submit(getRunnable("DURUP"));
        executorService.submit(getRunnable("The"));
        executorService.submit(getRunnable("Java"));
        executorService.submit(getRunnable("Thread"));

        // Thread는 2개지만 5개의 작업을 보낸다
        /*
            2개의 Thread에서 번갈아가면서 처리리
           DURUPpool-1-thread-2
            Hellopool-1-thread-1
            Thepool-1-thread-1
            Javapool-1-thread-2
            Threadpool-1-thread-1
         */

        executorService.shutdown();
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
