package thejava.lamda.class_2;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {
//        Function<String, String>
//        UnaryOperator<String> hi = (s) -> "hi " + s;

        // static 메서드를 사용하는 방법
        UnaryOperator<String> hi = Greeting::hi;
        hi.apply("youngsu");

        // 인스턴스 메서드를 사용하는 방법
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("youngsu"));

        // 매개변수 없는 생성자를 사용하는 방법
        Supplier<Greeting> greetingSupplier = Greeting::new;
        Greeting greeting2 = greetingSupplier.get();// 생성

        // 매개변수 있는 생성자
        Function<String, Greeting> greetingFunction = Greeting::new;
        Greeting greeting1 = greetingFunction.apply("youngsu");
        System.out.println(greeting1.getName());


    }
}
