package thejava.concurrent.class_3;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            System.out.println("hello work start Thread -> " + Thread.currentThread().getName());
            Thread.sleep(2000L);
            return "Hello";
        };

        Callable<String> java = () -> {
            System.out.println("java work start Thread -> " + Thread.currentThread().getName());
            Thread.sleep(3000L);
            return "Java";
        };

        Callable<String> durup = () -> {
            System.out.println("durup work start Thread -> " + Thread.currentThread().getName());
            Thread.sleep(1000L);
            return "Durup";
        };

        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, durup));
        for (Future<String> f : futures) {
            System.out.println(f.get());
        }

        executorService.shutdown();
    }
}
