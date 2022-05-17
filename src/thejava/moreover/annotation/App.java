package thejava.moreover.annotation;

public class App {
    public static void main(String[] args) {

    }
    // 타입 변수에만 사용할 수 있음
    static class FeelsLikeChicken<@Chicken T> {

        public static <@Chicken C> void print( C c) {
            System.out.println(c);
        }

    }
}
