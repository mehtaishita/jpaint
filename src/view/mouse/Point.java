package view.mouse;

public class Point {
    private int x;
    private int y;

    public Point(int a, int b) {
        this.x = a;
        this.y = b;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return Integer.toString(this.x) + "," + Integer.toString(this.y);
    }
}
