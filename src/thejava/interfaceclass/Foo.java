package thejava.interfaceclass;

public interface Foo {

    void printName();

    // Foo를 구현한 클래스들에게 추가 요구사항이 발생한 경우.
    // 추상 메서드를 추가한 경우 - Foo를 구현한 모든 모든 클래스가 추가한 추상 메서드를 재정의 해야한다
    // void printNameUpperCase();


    // default 메서드를 추가한 경우 - Foo를 구현한 모든 클래스에 메소드 구현체를 제공한다
    // 구현체가 모르게 추가된 기능으로 그만큼 리스크가 있다
    // 반드시 아래처럼 문서화 해야 한다
    /**
     * @implSpec
     * 이 구현체는 getName()으로 가져온 무자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    // static method
    static void printinterfaceName() {
        System.out.println("Foo");
    }

    String getName();
}
