package thejava.lamda.class_1;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Bar {
    public static void main(String[] args) {
        Supplier<Integer> get10 = () -> {
            return 10;
        };

        // 위의 코드를 간결하게
        Supplier<Integer> get20 = () -> 20;

        // 타입은 정의하지 않아도 상관없다
        BiFunction<Integer, Integer, Integer> sum = (Integer a, Integer b) -> a + b;
        BiFunction<Integer, Integer, Integer> sum2 = (a, b) -> a + b;

        // 위의 코드를 간결하게 사용
        BinaryOperator<Integer> sum3= (a, b) -> a + b;
    }
}
