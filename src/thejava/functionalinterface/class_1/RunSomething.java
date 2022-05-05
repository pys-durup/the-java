package thejava.functionalinterface.class_1;

@FunctionalInterface // 애노테이션 적용
public interface RunSomething {

    // 추상메서드가 하나만 있으면 함수형 인터페이스
    // abstract void doIt(); abstract 생략 가능
    void doIt();

    // 추상메서드가 1개 이상 있는 경우 @FunctionalInterface이 에러를 발생시킨다
    //void doItSomething();

    // Java 8 부터 인터페이스에 스태틱 메서드 정의 가능
    // 인터페이스 임에도 불구하고. 인터페이스 안에다가 스태틱 메서드 정의
    public static void printName() {
        System.out.println("Keesun");
    }

    // default 메서드를 정의할 수 있다
    default void printAge() {
        System.out.println("40");
    }
}
