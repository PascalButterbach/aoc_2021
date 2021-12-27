package org.butterbach.days.day01;

import org.butterbach.days.BaseDay;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class Day01 extends BaseDay {


    public Day01() {
        super(1);
    }


    @Override
    public Object solvePartOne() {

        List<Integer> collect = getInput().stream()
                .map(Integer::parseInt).toList();

        int counter = 0;

        for (int i = 0; i < collect.size() - 1; i++) {

            if (collect.get(i) < collect.get(i + 1)) {

                counter++;
            }
        }
        return counter;
    }

    @Override
    public Object solvePartTwo() {
        List<Integer> collect = getInput().stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Integer lastValue = null;
        int count = 0;
        for (int i = 0; i < collect.size(); i++) {

            List<Integer> reduce = collect.stream().skip(i).limit(3).collect(Collectors.toList());

            if (reduce.size() != 3)
                break;

            Optional<Integer> reduce1 = reduce.stream().reduce(Integer::sum);

            if (lastValue != null && lastValue < reduce1.get()) {
                count++;
            }

            lastValue = reduce1.get();


        }
        return count;
    }
}
