package thejava.lamda.class_1;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Foo {
    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.run();
    }

    private void run() {
		 /*
        자바 8 이전에는 final 키워드가 붙어 있어야 익명클래스나 로컬클래스 내부에서 사용 가능했다
        자바 8 이후에서는 fianl 키워드를 생략할 수 있는 상황이있다
        > 사실상 final인 경우 > 변경 하지 않는 경우
        final, effective final의 경우 로컬클래스, 익명클래스, 람다에서 모두 참조 가능
     */
        int baseNumber = 10;

        // 로컬 클래스 - 별도의 scope
        class LocalClasss {
            void printBaseNumber() {
                // 로컬클래스 내부에서 참조 가능
                System.out.println(baseNumber);
                int baseNumber = 11;
                // 변수가 가려짐(쉐도윙)
                System.out.println(baseNumber);
            }
        }

        // 익명 클래스 - 별도의 scope
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                // 익명클래스 바깥 baseNumber가 아닌 메서드에 전달되는 파라미터를 사용한다
                // 변수가 가려짐(쉐도윙)
                System.out.println(baseNumber);
            }
        };

        // 람다 - 동일한 scope
        // 별도의 scope가 없어서 쉐도윙 하지 않는다
        // 변수 이름을 baseNumber로 바꿀 경우
        // Variable 'baseNumber' is already defined in the scope
        IntConsumer printInt = (i ) -> {
            System.out.println(i + baseNumber);
        };

        printInt.accept(10);

        // baseNumber를 final 처럼 쓰고 있는데 변경할 경우
        // Variable used in lambda expression should be final or effectively final
        // baseNumber++;
    }
}