package thejava.concurrent.class_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        /*
            Excutors를 쓸 일은 거의 없다
            excute() 메서드 하나만 존재

            실질적으로 ExecutorService를 사용하는데
            Excutor을 상속 받고 다양한 기능을 가지고 있다

            ScheduledExecutorService
            주기적으로 작업 실행
            특정시간 딜레이 후 작업 실행

         */
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println("Thread " + Thread.currentThread().getName());
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        // executorService는 실행을 하고 난 후 다음 작업이 들어올 때까지
        // 대기를 하기 때문에 프로세스가 죽지 않는다 명시적으로 종료를 해줘야 한다
//        executorService.shutdown();

        // executorService.shutdown()은 graceful shutdown - 적절하게 죽인다.
        // 현재 진행중인 작업은 끝까지 마치고 프로세스를 죽인다

        executorService.shutdownNow();
        // executorService.shutdownNow()은 현재 진행중인 작업에 상관없이 바로 죽인다

    }
}
