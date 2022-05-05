package thejava.functionalinterface.class_2;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        // Plus10 클래스의 인스턴스 만들어서 사용
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));

        // 람다 표현식으로 구현
        // Function
        Function<Integer, Integer> fnPlus10 = (i) -> i + 10;
        System.out.println(fnPlus10.apply(1));

        // Consumer
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10); // 10

        // Supplier
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get()); // 10

        // Predicate
        Predicate<String> startsWithYoungsu = (s) -> s.startsWith("Youngsu");
        Predicate<String> endWithPark = (s) -> s.endsWith("Park");
        Predicate<Integer> isEven = (i) -> i%2 == 0;

        System.out.println(startsWithYoungsu.test("Youngsu")); // true
        System.out.println(startsWithYoungsu.and(endWithPark).test("YoungsuPark")); // true

    }
}
