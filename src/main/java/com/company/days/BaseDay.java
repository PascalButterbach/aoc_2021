package com.company.days;

import lombok.Getter;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Getter
public abstract class BaseDay {

    private final List<String> input;
    private String headerText = "";

    public BaseDay(int day) {
        headerText = "#####[]--- DAY " + day + " ---[]#####";
        this.input = read(day);
    }


    public void solve() {
        System.out.println(headerText);
        long startPartOne = System.nanoTime();
        Object partOne = solvePartOne();
        long endPartOne = System.nanoTime();

        System.out.println(MessageFormat.format("-==[ Result Part One [{0}] Elapsed time: [{1} ms] ]==-",
                partOne,
                TimeUnit.NANOSECONDS.toMicros(endPartOne - startPartOne)));

        long startPartTwo = System.nanoTime();
        Object partTwo = solvePartTwo();
        long endPartTwo = System.nanoTime();

        System.out.println(MessageFormat.format("-==[ Result Part Two [{0}] Elapsed time: [{1} ms] ]==-",
                partTwo,
                TimeUnit.NANOSECONDS.toMicros(endPartTwo - startPartTwo)));

    }


    @SneakyThrows
    public static List<String> read(int day) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(String.format("day_%s.txt", day));

        return IOUtils.readLines(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8);
    }

    public abstract Object solvePartOne();

    public abstract Object solvePartTwo();

}
