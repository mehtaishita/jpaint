package model;

import view.mouse.Point;

import static java.lang.Integer.min;
import static java.lang.Math.abs;

public class DrawingCalculations {
    private Point start;
    private Point end;
    private int x, y, w, h;

    public DrawingCalculations(Point start, Point end) {
        this.start = start;
        this.end = end;
        calculate();
    }

    public void setNewPoints(Point newStart,Point newEnd) {
        this.start = newStart;
        this.end = newEnd;
        calculate();
    }

    private void calculate() {
        x = min(start.getX(),end.getX());
        y = min(start.getY(),end.getY());
        w = abs(start.getX() - end.getX());
        h = abs(start.getY() - end.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }
}
