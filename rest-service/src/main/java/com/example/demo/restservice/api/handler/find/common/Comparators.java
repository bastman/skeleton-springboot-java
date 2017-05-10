package com.example.demo.restservice.api.handler.find.common;


import javax.validation.constraints.NotNull;
import java.time.Instant;

public class Comparators {

    public static int compareInstant(@NotNull Instant x, @NotNull Instant y, boolean descending) {
        int value = Integer.compare((int) x.toEpochMilli(), (int) y.toEpochMilli());
        if (!descending) {
            return value;
        }

        return (value * -1);
    }
}
