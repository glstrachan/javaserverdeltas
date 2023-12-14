package org.serverdeltas;

public class Bar extends UpdatableState {
    private int x;
    private int y;
    private int[] z = new int[3];

    private int[][] w = new int[2][3];

    public Bar(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public int[] getZ() { return z; }

    public int[][] getW() { return w; }

    public void setX(int x) {
        setField("x", x);
    }

    public void setY(int y) {
        setField("y", y);
    }

    public void setZ(int[] z) {
        setField("z", z);
    }

    public void setW(int[][] w) {
        setField("w", w);
    }
}
