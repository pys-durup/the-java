package thejava.datetime.class_2;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class App {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant); // 2022-05-12T12:17:21.340491100Z
        System.out.println(instant.atZone(ZoneId.of("UTC"))); // 2022-05-12T12:19:56.238812900Z[UTC]

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone); // Asia/Seoul
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println(zonedDateTime); // 2022-05-12T21:18:52.162175600+09:00[Asia/Seoul]

        // 현재 시스템 zone 정보를 참고해서 가져온다
        // 만약에 서버에 배포했는데 서버가 미국에있다면 미국 zone 정보로 찍힌다
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now" + now); // 2022-05-12T21:22:18.108035800

        // 특정 일시 리턴
        LocalDateTime birthday = LocalDateTime.of(1993, Month.AUGUST, 17, 0, 0, 0);

        // 특정 Zone의 특정 일시
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        // Instant에서도 특정 Zone으로 가져올 수 있다
        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime1);



        // 날짜 비교 (인류용 시간)
        LocalDate today = LocalDate.now();
        LocalDate thisyearBirthDay = LocalDate.of(2022, Month.AUGUST, 17);

        Period period = Period.between(today, thisyearBirthDay);
        System.out.println(period.getDays()); // 24

        Period until = today.until(thisyearBirthDay);
        System.out.println(until.get(ChronoUnit.DAYS)); // 24


        // instant로 비교 (기계용 시간)
        Instant now2 = Instant.now();
        Instant plus = now2.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now2, plus);
        System.out.println(between.getSeconds()); //10


        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(dateTime.format(MMddyyyy)); // 05/12/2022
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); // 2022-05-12T21:52:06.6143883

        LocalDate parse = LocalDate.parse("07/15/1982", MMddyyyy);
        System.out.println(parse); // 1982-07-15



        ZoneId newZoneAPI = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone legacyZoneAPI = TimeZone.getTimeZone(newZoneAPI);
        Instant newInstant = new Date().toInstant();
        Date legacyInstant = Date.from(newInstant);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        LocalDateTime dateTime1 = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();


    }
}
