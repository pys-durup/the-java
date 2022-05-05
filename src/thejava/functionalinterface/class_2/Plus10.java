package thejava.functionalinterface.class_2;

import java.util.function.Function;

public class Plus10 implements Function<Integer, Integer> {
    // Function을 구현한 클래스 생성
    @Override
    public Integer apply(Integer integer) {
        return integer + 10;
    }
}
