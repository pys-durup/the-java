package thejava.interfaceclass.class_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class AppSpliterator {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("keesun");
        names.add("whiteship");
        names.add("toby");
        names.add("foo");

        Spliterator<String> spliterator = names.spliterator();
        Spliterator<String> spliterator2 = spliterator.trySplit();

        while (spliterator.tryAdvance(System.out::println));
        System.out.println("===================");
        while (spliterator2.tryAdvance(System.out::println));
    }
}
