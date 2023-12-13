package org.serverdeltas;

public class Bar extends UpdatableState {
    private int x;
    private int y;

    public Bar(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public void setX(int x) {
        setField("x", x);
    }

    public void setY(int y) {
        setField("y", y);
    }
}
