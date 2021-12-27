package org.butterbach.days;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.CommandLineRunner;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public abstract class BaseDay implements CommandLineRunner {

    private List<String> input;

    private int day;
    private boolean test = false;

    private String headerText = "";

    public BaseDay(int day) {
        this.day = day;
        headerText = "#####[]--- DAY " + this.day + " ---[]#####";
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

        System.out.println(MessageFormat.format("-==[ Result Part One [{0,number,#}] Elapsed time: [{1} ms] ]==-",
                partOne,
                TimeUnit.NANOSECONDS.toMicros(endPartOne - startPartOne)));

        long startPartTwo = System.nanoTime();
        Object partTwo = solvePartTwo();
        long endPartTwo = System.nanoTime();

        System.out.println(MessageFormat.format("-==[ Result Part Two [{0,number,#}] Elapsed time: [{1} ms] ]==-\n",
                partTwo,
                TimeUnit.NANOSECONDS.toMicros(endPartTwo - startPartTwo)));

    }

    public List<String> getInput() {
        if (input == null) {
            this.input = read();
        }

        return input;
    }

    public BaseDay asTest(){

        this.test = true;
        return this;
    }

    @SneakyThrows
    public List<String> read() {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String fileName = String.format((test ? "day_%s_test" : "day_%s"), this.day);
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        return IOUtils.readLines(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8);
    }

    public abstract Object solvePartOne();

    public abstract Object solvePartTwo();

}
