package org.butterbach.days.day03;

import org.butterbach.days.BaseDay;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class Day03 extends BaseDay {

    public Day03() {
        super(3);
    }

    @Override
    public Object solvePartOne() {
        List<BitCount> bits = new ArrayList<>();

        getInput().forEach(s -> {
            var sArr = s.toCharArray();

            for (int i = 0; i < sArr.length; i++) {
                int finalI = i;
                Optional<BitCount> currPosOpt = bits.stream().filter(b -> b.position == finalI).findAny();
                BitCount currPos = null;

                if(currPosOpt.isPresent()){

                    currPos = currPosOpt.get();
                }else{

                    currPos = new BitCount(finalI,0,0);
                    bits.add(currPos);
                }

                if (sArr[i] == '0') {
                    currPos.zeros += 1;
                } else {
                    currPos.ones += 1;
                }
            }
        });

        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();

        for (BitCount bitCount : bits) {
                gamma.append(bitCount.zeroMostCommon() ? "0" : "1");
                epsilon.append(bitCount.zeroMostCommon() ? "1" : "0");
        }

        return Integer.parseInt(String.valueOf(gamma), 2) * Integer.parseInt(String.valueOf(epsilon), 2);
    }

    @Override
    public Object solvePartTwo() {
        return null;
    }
}
