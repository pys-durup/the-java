package thejava.functionalinterface.class_1;

public class Foo {
    public static void main(String[] args) {
        // Java 8 이전 - 익명 내부클래스 형태로 사용 anonymous Inner class
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("Hello");
            }
        };

        // 람다 형태의 코드 - 한줄
        RunSomething runSomething1 = () -> System.out.println("Hello");


        // 두줄 이상인 경우
        RunSomething runSomething2 = () -> {
            System.out.println("Hello");
            System.out.println("World");
        };

        runSomething2.doIt(); // 재정의한 추상메서드
        RunSomething.printName(); // 스태틱 메서드

        // 순수 함수를 보장해 주지 못하는 경우 예시 : 결과값이 변하는 경우
        RunSomething2 runSomething3 = new RunSomething2() {
            int basenumber = 10;
            @Override
            public int doit(int number) {
                basenumber++;
                return basenumber + number;
            }
        };

        System.out.println(runSomething3.doit(10)); // 21
        System.out.println(runSomething3.doit(10)); // 22
        System.out.println(runSomething3.doit(10)); // 23

    }
}
