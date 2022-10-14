package model;

import controller.ShapeConfiguration;
import view.mouse.Point;

public class ShapeInfo {
    private Point start,end;
    private ShapeConfiguration shapeConfiguration;


    public ShapeInfo(Point start, Point end, ShapeConfiguration shapeConfiguration) {
        this.start = start;
        this.end = end;
        this.shapeConfiguration = shapeConfiguration;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public void setStart(Point newStart) {
        this.start = newStart;
    }

    public void setEnd(Point newEnd) {
        this.end = newEnd;
    }

    public ShapeConfiguration getShapeConfiguration() {
        return shapeConfiguration;
    }
}
