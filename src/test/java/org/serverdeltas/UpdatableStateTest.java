package org.serverdeltas;

import org.junit.jupiter.api.Test;

public class UpdatableStateTest {
    @Test
    public void barDelta() {
        Bar bar = new Bar(1, 2);
        //System.out.println(bar.getDelta());

        bar.setX(5);
        bar.setY(6);
        bar.setZ(new int[]{1, 2, 3});
        bar.setW(new int[][]{{1, 2, 3},{1, 2, 3}});
        //System.out.println(bar.getDelta());

        bar.applyDelta("\"org.serverdeltas.Bar\": {\"z\": [2, 2, 2], \"x\": 5, \"y\": 6, \"w\": [[2, 2, 2], [3, 3, 3]]}");
        System.out.println(bar.getDelta());

        for(int i = 0; i < bar.getZ().length; i++) {
            System.out.print(bar.getZ()[i] + " ");
        }

        System.out.println();

        for(int i = 0; i < bar.getW().length; i++) {
            for(int j = 0; j < bar.getW()[i].length; j++) {
                System.out.print(bar.getW()[i][j] + " ");
            }
            System.out.println();
        }
    }
}
