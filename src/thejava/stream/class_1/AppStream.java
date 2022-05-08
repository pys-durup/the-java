package thejava.stream.class_1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppStream {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("keesun");
        names.add("whiteship");
        names.add("toby");
        names.add("foo");

        // 스트림은 기존 데이터 소스를 변경하지 않는다
        Stream<String> stringStream = names.stream().map(String::toUpperCase);
        stringStream.forEach(System.out::println);
        System.out.println("========================");
        names.forEach(System.out::println);

        System.out.println("lazy======================");

        // 중개형 오퍼레이션은 lazy 하다
        // 종료형 오퍼레이션이 실행되기 전까지는 실행하지 않는다
        names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        });

        System.out.println("===========================");

        // 종료형 오퍼레이션이 있어야 실행된다
        List<String> collect = names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("parallelStream() thread===============");

        List<String> collect1 = names.parallelStream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect1.forEach(System.out::println);

        System.out.println("stream() thread =======================");

        List<String> collect2 = names.stream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect2.forEach(System.out::println);

    }
}
