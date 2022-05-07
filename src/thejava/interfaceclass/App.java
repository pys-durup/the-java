package thejava.interfaceclass;

public class App {
    public static void main(String[] args) {

        Foo foo = new DefaultFoo("youngsu");
        foo.printName();
        foo.printNameUpperCase();

        Foo.printinterfaceName();

    }
}
