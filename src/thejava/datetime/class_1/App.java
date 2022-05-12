package thejava.datetime.class_1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {
    public static void main(String[] args) throws InterruptedException {

        Date date = new Date();
        // date인데 getTime 시간까지 다룬다
        long time = date.getTime();
        System.out.println(date);
        System.out.println(time);

        // 3초후
        Thread.sleep(1000 * 3);
        Date after3Seconds = new Date();
        System.out.println(after3Seconds);
        // 3초 이전의 시간을 설정할 수 있다
        after3Seconds.setTime(time);
        System.out.println(after3Seconds);

        // month를 받는 부분에 타입 안정성이 없다 -> int 값을 받도록 되어있음
        // 정석적인 방법은 Month라는 Enum 타입으로 지정해야 한다
        Calendar durupBirthDay = new GregorianCalendar(1993, -3, 17);
        Calendar durupBirthDay2 = new GregorianCalendar(1993, Calendar.AUGUST, 17);
        System.out.println(durupBirthDay.getTime()); // getTime을 했는데 Date 타입이 리턴됨
        durupBirthDay.add(Calendar.DAY_OF_YEAR, 1);
        System.out.println(durupBirthDay.getTime()); // mutable 객체 하루가 증가한다


    }
}
