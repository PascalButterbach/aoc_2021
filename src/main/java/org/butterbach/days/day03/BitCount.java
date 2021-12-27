package org.butterbach.days.day03;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BitCount {

    int position;
    int zeros;
    int ones;

    public boolean zeroMostCommon() {

        return zeros > ones;
    }
}
