package thejava.practice.day1;

import thejava.optional.class_1.Progress;

import java.util.Optional;

public class Product {
    private String name;
    private int price;
    private String info;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Optional<String> getInfo() {
        return Optional.ofNullable(info);
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
