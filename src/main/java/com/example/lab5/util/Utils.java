package com.example.lab5.util;

import java.util.Objects;
import java.util.function.Consumer;


public class Utils {

    public static <V> boolean setIfNotNull(V value, Consumer<V> setter) {
        if (Objects.nonNull(value)) {
            setter.accept(value);
            return true;
        }
        return false;
    }
}
