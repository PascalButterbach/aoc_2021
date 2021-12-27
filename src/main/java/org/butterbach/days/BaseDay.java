package org.butterbach.days;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.CommandLineRunner;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public abstract class BaseDay implements CommandLineRunner {
    private final String RED = "\u001b[31m";
    private final String GREEN = "\u001b[32m";


    private List<String> input;

    private String headerText = "";

    public BaseDay(int day) {

        headerText = "%s####################[]--- DAY %s ---[]####################".formatted(GREEN, day);
        read(day);
    }

    @Override
    public void run(String... args) throws Exception {

        solve();
    }

    public void solve() {

        System.out.println(headerText);
        long startPartOne = System.nanoTime();
        Object partOne = solvePartOne();
        long endPartOne = System.nanoTime();

        System.out.printf("%s-==[ Result Part One %s[%s]%s Elapsed time: [%s ms] ]==-\n",
                RED,
                GREEN,
                partOne,
                RED,
                TimeUnit.NANOSECONDS.toMicros(endPartOne - startPartOne));

        long startPartTwo = System.nanoTime();
        Object partTwo = solvePartTwo();
        long endPartTwo = System.nanoTime();

        System.out.printf("%s-==[ Result Part Two %s[%s]%s Elapsed time: [%s ms] ]==-\n\n",
                RED,
                GREEN,
                partTwo,
                RED,
                TimeUnit.NANOSECONDS.toMicros(endPartTwo - startPartTwo));

    }

    public List<String> getInput() {

        return input;
    }

    @SneakyThrows
    public void read(int dayNum) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String fileName = "day_%s".formatted(dayNum);
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        this.input = IOUtils.readLines(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8);
    }

    public abstract Object solvePartOne();

    public abstract Object solvePartTwo();

}
