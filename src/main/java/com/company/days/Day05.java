package com.company.days;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day05 extends BaseDay{

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

    class PointPair {
        Point start;
        Point end;

        public PointPair(Point start, Point end) {
            this.start = start;
            this.end = end;
        }

        public ArrayList<Point> getPointsPartOne() {
            ArrayList<Point> points = new ArrayList<>();

            if (start.x == end.x) {

                for (int i = Math.min(start.y, end.y); i <= Math.max(start.y, end.y); i++) {

                    points.add(new Point(start.x, i));
                }
            }

            if (start.y == end.y) {

                for (int i = Math.min(start.x, end.x); i <= Math.max(start.x, end.x); i++) {

                    points.add(new Point(i, start.y));
                }
            }

            return points;
        }

        public ArrayList<Point> getPointsPartTwo() {
            ArrayList<Point> points = new ArrayList<>();

            if (start.x == end.x) {

                for (int i = Math.min(start.y, end.y); i <= Math.max(start.y, end.y); i++) {

                    points.add(new Point(start.x, i));
                }
            } else if (start.y == end.y) {

                for (int i = Math.min(start.x, end.x); i <= Math.max(start.x, end.x); i++) {

                    points.add(new Point(i, start.y));
                }
            } else {
                int diff = Math.abs(start.x  - end.x) + 1;

                for (int i = 0; i < diff; i++) {

                    int x = start.x > end.x ? start.x - i : start.x + i;
                    int y = start.y > end.y ? start.y - i : start.y + i;
                    points.add(new Point(x, y));
                }
            }
            return points;
        }
    }

}
