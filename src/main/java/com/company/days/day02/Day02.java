package com.company.days.day02;

import com.company.days.BaseDay;
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

        return null;
    }
}
