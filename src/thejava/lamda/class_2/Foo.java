package thejava.lamda.class_2;

import java.util.Arrays;
import java.util.Comparator;

public class Foo {
    public static void main(String[] args) {
        String[] names = {"keesun", "whiteship", "toby"};
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        /*
            임의 인스턴스들을 거쳐 가면서 compareToIgnoreCase 라는 인스턴스 메소드를 사용한다
            String에 static한 메소드가 있는걸로 생각 할 수도 있겠지만 아니다.
         */
        String[] names2 = {"keesun", "whiteship", "toby"};
        Arrays.sort(names2, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names2));


    }
}
