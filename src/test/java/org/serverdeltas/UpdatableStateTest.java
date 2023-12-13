package org.serverdeltas;

import org.junit.jupiter.api.Test;

public class UpdatableStateTest {
    @Test
    public void barDelta() {
        Bar bar = new Bar(1, 2);
        System.out.println(bar.getDelta());

        bar.setX(5);
        bar.setY(6);
        System.out.println(bar.getDelta());

        bar.applyDelta("\"org.serverdeltas.Bar\": {\"x\": 8, \"y\": 3}");
        System.out.println(bar.getX() + " " + bar.getY());
        System.out.println(bar.getDelta());
    }
}
