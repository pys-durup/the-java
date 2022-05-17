package thejava.moreover.annotation;

import java.util.Arrays;

@Bhc("양념")
@Bhc("마늘간장")
public class App3 {
    public static void main(String[] args) {
        Bhc[] bhcs = App3.class.getAnnotationsByType(Bhc.class);
        Arrays.stream(bhcs).forEach(c -> {
            System.out.println(c.value());
        });

        BhcContainer bhcContainer = App3.class.getAnnotation(BhcContainer.class);
        Arrays.stream(bhcContainer.value()).forEach(c -> {
            System.out.println(c.value());
        });
    }
}
