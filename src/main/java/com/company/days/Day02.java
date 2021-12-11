package com.company.days;

import java.util.Map;
import java.util.stream.Collectors;

public class Day02 extends BaseDay {

    public Day02() {
        super(2);
    }

    @Override
    public Object solvePartOne() {

        Map<String, Integer> collect = getInput().stream()
                .map(s -> s.split(" "))
                .collect(Collectors.groupingBy(strings -> strings[0], Collectors.mapping(t -> t[1], Collectors.toList())))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, stringListEntry -> stringListEntry.getValue().stream()
                        .mapToInt(Integer::parseInt)
                        .sum()));

        return collect.get("forward") * (Math.max(collect.get("up"), collect.get("down")) - Math.min(collect.get("up"), collect.get("down")));
    }

    @Override
    public Object solvePartTwo() {
        return null;
    }
}
