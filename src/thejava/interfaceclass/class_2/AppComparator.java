package thejava.interfaceclass.class_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AppComparator {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("keesun");
        names.add("whiteship");
        names.add("toby");
        names.add("foo");

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        names.sort(compareToIgnoreCase);
//        names.sort(compareToIgnoreCase.reversed());

        names.forEach(System.out::println);

    }
}
