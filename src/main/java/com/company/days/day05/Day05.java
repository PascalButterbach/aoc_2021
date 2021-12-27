package com.company.days.day05;

import com.company.days.BaseDay;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Day05 extends BaseDay {

    public Day05() {
        super(5);
    }

    @Override
    public Object solvePartOne() {

        ArrayList<PointPair> pairs = getPairs();

        ArrayList<Point> allPoints = new ArrayList<>();
        pairs.forEach(pointPair -> allPoints.addAll(pointPair.getPointsPartOne()));

        Map<Point, List<Point>> collect = allPoints.stream().collect(Collectors.groupingBy(Point::getLocation));

        return collect.entrySet().stream().filter(pointListEntry -> pointListEntry.getValue().size() >= 2).count();
    }

    @Override
    public Object solvePartTwo() {

        ArrayList<PointPair> pairs = getPairs();

        ArrayList<Point> allPoints = new ArrayList<>();
        pairs.forEach(pointPair -> allPoints.addAll(pointPair.getPointsPartTwo()));

        Map<Point, List<Point>> collect = allPoints.stream().collect(Collectors.groupingBy(Point::getLocation));

        return collect.entrySet().stream().filter(pointListEntry -> pointListEntry.getValue().size() >= 2).count();
    }

    ArrayList<PointPair> getPairs() {
        ArrayList<PointPair> pairs = new ArrayList<>();

        getInput().forEach(s -> {
            String[] split = s.split(" -> ");
            int[] start = Arrays.stream(split[0].split(",")).mapToInt(Integer::parseInt).toArray();
            int[] end = Arrays.stream(split[1].split(",")).mapToInt(Integer::parseInt).toArray();

            pairs.add(new PointPair(
                    new Point(start[0], start[1])
                    , new Point(end[0], end[1])
            ));
        });
        return pairs;
    }
}