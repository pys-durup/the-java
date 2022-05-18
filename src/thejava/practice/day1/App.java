package thejava.practice.day1;

import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        String[] tempArray = {"durup", "bobi", "camsee", "jabong"};

//        Arrays.sort(tempArray, (o1, o2) -> -1);
//        Arrays.stream(tempArray).forEach(System.out::println);

        Arrays.sort(tempArray, String::compareToIgnoreCase);
        Arrays.stream(tempArray).forEach(System.out::println);

        ArrayList<String> names = new ArrayList<>();
        names.add("durup");
        names.add("bobi");
        names.add("camsee");
        names.add("jabong");

        List<String> d = names.stream()
                .filter(s -> s.startsWith("d"))
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());


        d.forEach(System.out::println);

        Product computer = new Product("컴퓨터", 2000);
        Optional<String> info = computer.getInfo();
//        info.orElseThrow(IllegalStateException::new);

        String s = info.orElseGet(() -> "설명란이 비어있다");
        System.out.println(s);

        Optional<Object> empty = Optional.empty();
        Runnable empty1 = Optional::empty;

    }
}
