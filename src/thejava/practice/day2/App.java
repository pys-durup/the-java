package thejava.practice.day2;

import java.util.ArrayList;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        ArrayList<People> peoples = new ArrayList<>();
        peoples.add(new People("durup", 30, "경기 군포"));
        peoples.add(new People("camsee", 30, "경기 군포"));
        peoples.add(new People("duzi", 30, "경기 군포"));
        peoples.add(new People("mini", 30, "경기 군포"));
        peoples.add(new People("bobi", 30, "경기 군포"));
        peoples.add(new People("mawang", 30, "경기 군포"));
        peoples.add(new People("jabong", 30, "경기 군포"));
        peoples.add(new People("youngman", 30, "경기 군포"));
        peoples.add(new People("gunil", 30, "경기 군포"));
        peoples.add(new People("hongjo", 30, "경기 군포"));

        People camsee = peoples.get(1);
        camsee.setPhysical(new Physical(200, 300, 400));


        // NPE
        // peoples.forEach(p -> p.getPhysical().getBenchpress());

        People durup = peoples.get(0);
        Optional<Physical> durupPhysical = durup.getPhysical();
        if (durupPhysical.isPresent()) {
            System.out.println(durupPhysical.get());
        }

        Optional<Physical> camseePhysical = camsee.getPhysical();
        if (camseePhysical.isPresent()) {
            System.out.println(camseePhysical.get().getBenchpress());
        }

        Physical physical = durupPhysical.orElse(new Physical(100, 100, 100));
        System.out.println(physical.getDeadLift());

        Physical physical1 = camseePhysical.orElse(new Physical(100, 100, 100));
        System.out.println(physical1.getDeadLift());

        Physical physical2 = durupPhysical.orElseGet(() -> {
            return new Physical(100, 200, 300);
        });
        System.out.println(physical2.getSquat());

//        durupPhysical.orElseThrow(IllegalStateException::new);

        Optional<Physical> physical3 = camseePhysical.filter(p -> {
            boolean b = p.getSquat() > 100;
            return b;
        });
        Physical physical4 = physical3.get();
        System.out.println(physical4.getSquat());


    }
}
