package thejava.interfaceclass.class_2;

import java.util.ArrayList;
import java.util.List;

public class AppForeach {
    public static void main(String[] args) {
        /**
         * Collection 은 iterable을 상속받는다
         */
        List<String> names = new ArrayList<>();
        names.add("keesun");
        names.add("whiteship");
        names.add("toby");
        names.add("foo");

        // 기존 향상된 for문 사용
        for (String name : names) {
            System.out.println(name);
        }

        // forEach 메서드 - functional Interface Cunsumer를 받는다
        names.forEach((s) -> {
            System.out.println(s);
        });

        // forEach 메소드 & 메소드 레퍼런스로 표현
        names.forEach(System.out::println);

    }
}
