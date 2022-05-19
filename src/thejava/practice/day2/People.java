package thejava.practice.day2;

import java.util.Optional;

public class People {
    private String name;
    private Integer age;
    private String address;
    private Physical physical;

    public People(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Optional<Physical> getPhysical() {
        return Optional.ofNullable(this.physical);
    }

    public void setPhysical(Physical physical) {
        this.physical = physical;
    }
}
