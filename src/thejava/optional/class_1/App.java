package thejava.optional.class_1;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        /*
            NullPointerException
            getProgress() 메서드가 기본값을 리턴하는데 레퍼런스 타입은 기본값이 null
            null에 어떤 메소드를 호출하려고하면 NullPointerException 에러 발생
         */
//        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
//        Duration studyDuration = spring_boot.getProgress().getStudyDuration();
//        System.out.println(studyDuration);


        /*
            위와같은 NullPointerException 에러를 해결했던 방법
            null 체크를 깜빡할 수 있기 때문에 종종 에러가 발생하게 된다
            매번 체크할 수 없고 사람이기 때문에 실수한다
         */
//        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
//        Progress progress = spring_boot.getProgress();
//        if (progress != null) { // null을 체크해서 null이 아닐때만 작동하도록
//            System.out.println(progress.getStudyDuration());
//        }

        /*
            2. Progress 클래스의 getProgress() 메서드에서 null을 리턴하는 그 자체가 문제이다
         */

        // Optional 사용
        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
        Optional<Progress> progress = spring_boot.getProgress();
        progress.ifPresent(p -> System.out.println(p.getStudyDuration()));


    }
}
