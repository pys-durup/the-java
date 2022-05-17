package thejava.moreover.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@Repeatable(BhcContainer.class)
public @interface Bhc {
    String value();
}

