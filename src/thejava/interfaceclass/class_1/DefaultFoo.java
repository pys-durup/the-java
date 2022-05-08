package thejava.interfaceclass.class_1;

public class DefaultFoo implements Foo{

    private String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    public String getName() {
        return this.name;
    }


}
