package thejava.concurrent.class_3;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

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

        String s = executorService.invokeAny(Arrays.asList(hello, java, durup));
        System.out.println(s);

        executorService.shutdown();
    }
}
