package com.company.days.day09;

import com.company.days.BaseDay;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Day09 extends BaseDay {

    public Day09() {

        super(9);
    }

    @Override
    public Object solvePartOne() {

        return null;
    }

    @Override
    public Object solvePartTwo() {

        return null;
    }


    public int[][] parseInputToMap(List<String> input) {

        int inputSize = getInput().size();
        int inputRowSize = getInput().get(0).length();

        int[][] inputMap = new int[inputSize][inputRowSize];

        for (int i = 0; i < inputSize; i++) {

            for (int j = 0; j < inputRowSize; j++) {

                inputMap[i][j] = Character.getNumericValue(input.get(i).charAt(j));
            }
        }

        return inputMap;
    }

    public int[] findLowPoints(int[][] inputMap) {

        return new int[]{1, 0, 5, 5};
    }


}
