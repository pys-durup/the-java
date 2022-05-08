package thejava.interfaceclass.class_2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppStream {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("keesun");
        names.add("whiteship");
        names.add("toby");
        names.add("foo");

        List<String> k = names.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("K"))
                .collect(Collectors.toList());
        k.forEach(System.out::println);

        names.removeIf(s -> s.startsWith("k"));
        names.forEach(System.out::println);

        names.sort(String::compareToIgnoreCase);
    }
}
