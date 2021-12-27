package com.company.days.day05;

import java.awt.*;
import java.util.ArrayList;

public class PointPair {
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
            int diff = Math.abs(start.x - end.x) + 1;

            for (int i = 0; i < diff; i++) {

                int x = start.x > end.x ? start.x - i : start.x + i;
                int y = start.y > end.y ? start.y - i : start.y + i;
                points.add(new Point(x, y));
            }
        }
        return points;
    }
}
