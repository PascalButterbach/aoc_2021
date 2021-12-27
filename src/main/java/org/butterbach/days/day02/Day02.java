package org.butterbach.days.day02;

import org.butterbach.days.BaseDay;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Day02 extends BaseDay {

    public Day02() {
        super(2);
    }

    @Override
    public Object solvePartOne() {

        Map<String, Long> collect = getInput().stream()
                .map(s -> s.split(" "))
                .collect(Collectors.groupingBy(strings -> strings[0], Collectors.mapping(t -> t[1], Collectors.summarizingInt(Integer::parseInt))))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, s -> s.getValue().getSum()));

        return collect.get("forward") * (Math.max(collect.get("up"), collect.get("down")) - Math.min(collect.get("up"), collect.get("down")));
    }

    @Override
    public Object solvePartTwo() {

        var inputValues = getInput().stream()
                .map(s -> s.split(" "))
                .map(s -> new Object() {
                    final String action = s[0];
                    final int value = Integer.parseInt(s[1]);
                }).toList();

        var value = new Object() {
            int horizontalPosition = 0;
            int depth = 0;
            int aim = 0;
        };

        inputValues.forEach(i -> {
            switch (i.action) {
                case "forward" -> {
                    value.horizontalPosition += i.value;
                    value.depth += (value.aim * i.value);
                }
                case "down" -> value.aim += i.value;
                case "up" -> value.aim -= i.value;
            }
        });

        return value.horizontalPosition * value.depth;
    }
}
