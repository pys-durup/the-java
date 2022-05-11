package thejava.optional.class_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App2 {
    public static void main(String[] args) {
        List<OnlineClass> springClass = new ArrayList<>();
        springClass.add(new OnlineClass(1, "spring boot", true));
        springClass.add(new OnlineClass(5, "rest api development", false));

        // stream에서 Optional을 리턴하는 오퍼레이션들이 몇몇 있다
        // Optional을 리턴한다는 것은 중개형 오퍼레이션이 아닌 종료형 오퍼레이션이라는 것
        // .findFirst() 스트림의 결과값이 있을수도 있고 없을수도 있다 -> 리턴값dl Optional 타당함
        Optional<OnlineClass> optional = springClass.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        Optional<OnlineClass> optional2 = springClass.stream()
                .filter(oc -> oc.getTitle().startsWith("JPA"))
                .findFirst();

        boolean present = optional.isPresent();
        boolean empty = optional2.isEmpty();
        System.out.println(present);
        System.out.println(empty);

        // get() 메서드의 경우 값이 있는경우 아무 문제 없지만
        OnlineClass onlineClass = optional.get();
        System.out.println(onlineClass.getTitle());

        // 값이 들어있지 않은 경우 문제가 생긴다 NoSuchElementException 발생
        //OnlineClass onlineClass2 = optional2.get(); // 값이 없음

        // get() 호출 전에 값이 있는지 확인하고 꺼내야 한다
        if (optional2.isPresent()) {
            OnlineClass temp = optional2.get();
            System.out.println(temp.getTitle());
        }

        // 굳이 if문을 추가하지 않아도 Optional이 제공하는 다양한 메소드들이 있다
        // ifPresent, orElse, orElseGet

        // ifPresent 사용
        // 값이 있으므로 title 출력
        optional.ifPresent(oc -> System.out.println(oc.getTitle()));
        // 값이 없으므로 아무것도 출력하지 않음
        optional2.ifPresent(oc -> System.out.println(oc.getTitle()));

        // Optional 안의 래퍼런스 값을 가져와서 많은 작업을 해야하는 경우
        // orElse 사용
        // 있는경우 Optional안의 인스턴스를 리턴한다 / 없는경우 다른 OnlineClass 타입의 인스턴스를 리턴한다
        OnlineClass onlineClass1 = optional.orElse(createNewClass());
        OnlineClass onlineClass2 = optional2.orElse(createNewClass());
        // 값이 있어도 없어도 createNew Class 메서드는 무조건 실행된다

        // orElseGet 사용
        // Supplier 매개변수
        // 값이 없는경우에만 호출한다
        OnlineClass onlineClass3 = optional.orElseGet(App2::createNewClass);
        OnlineClass onlineClass4 = optional2.orElseGet(App2::createNewClass);

        // 이미 만들어져있는 어떤 인스턴스 (상수)를 참고해서 사용할 경우 orElse
        // 동적으로 작업해서 만들어내야 하는 경우 orElseGet

        // 값이 없을때 만들어줄 수 없는 상황 -> 에러를 던진다
        // 값이 무조건 있어야하고 없을때 문제가 생기는 상황에서 사용
        // 값이 있으면 가져오고 없으면 에러를 던진다
        // orElseThrow
//        optional2.orElseThrow(() -> {
//            return new IllegalStateException();
//        });


        // 값을 걸러내는 옵션 -> 조건에 맞는 걸러낼 값이 있다는 가정하에
        // filter로 걸러낼 값이 없는 경우 빈 Optional을 리턴한다
        // filter return Optional
        Optional<OnlineClass> onlineClass5 = optional.filter(oc -> oc.getId() > 10);
        System.out.println(onlineClass5.isPresent()); // false

        Optional<OnlineClass> onlineClass6 = optional.filter(OnlineClass::isClosed);
        System.out.println(onlineClass6.isPresent()); // true


        // map
        //
        Optional<Integer> integer = optional.map(oc -> oc.getId());
        System.out.println(integer.isPresent());
        
        // map으로 꺼내는 타입이 optional 타입인 경우
        // 아래와같이 꺼내서 사용해야 한다
        Optional<Optional<Progress>> progress = optional.map(oc -> oc.getProgress());
        Optional<Progress> optional1 = progress.orElseThrow();
        Progress progress1 = optional1.orElseThrow();
        System.out.println(progress1.getStudyDuration());

        // flatMap
        // 매핑해서 꺼내는 타입이 Optional 타입인 경우 해당 Optional 컨테이너를 벗겨서 돌려준다
        Optional<Progress> optional3 = optional.flatMap(oc -> oc.getProgress());
        Progress progress2 = optional3.orElseThrow();


    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New class", false);
    }
}
